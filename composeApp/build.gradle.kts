import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

version = "0.1.3"

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                        add(project.projectDir.path + "/commonMain/")
                        add(project.projectDir.path + "/wasmJsMain/")
                    }
                }
            }
        }
        binaries.executable()
    }
    js(IR) {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
            }
        }
        binaries.executable()
    }

    sourceSets {

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
            implementation(compose.materialIconsExtended)
        }
    }

    tasks.register<Exec>("dockerBuildWasm") {
        group = "docker"
        description = "Builds the Docker image for wasm."
        dependsOn("wasmJsBrowserDistribution")
        commandLine("docker", "build", "-f", "wasm.Dockerfile", "-t", "pfadfinder-website-wasm:${project.version}", ".")
    }

    tasks.register<Exec>("dockerBuildJs") {
        group = "docker"
        description = "Builds the Docker image for js."
        dependsOn("jsBrowserDistribution")
        commandLine("docker", "build", "-f", "js.Dockerfile", "-t", "pfadfinder-website-js:${project.version}", ".")
    }

    tasks.register<Exec>("dockerRunWasm") {
        group = "docker"
        description = "Runs the Docker image."
        dependsOn("dockerBuild")
        commandLine("docker", "run", "-p", "80:80", "pfadfinder-website-wasm:${project.version}")
    }

    tasks.register<Exec>("dockerRunJs") {
        group = "docker"
        description = "Runs the Docker image."
        dependsOn("dockerBuild")
        commandLine("docker", "run", "-p", "80:80", "pfadfinder-website-js:${project.version}")
    }

    tasks.register<Exec>("release") {
        group = "release"
        description = "Compiles each target and then builds docker images"
        mustRunAfter("dockerBuildWasm")
        mustRunAfter("dockerBuildJs")
    }
}


