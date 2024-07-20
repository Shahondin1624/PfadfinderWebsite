import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

version = "0.2.2"

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
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
                implementation(compose.materialIconsExtended)
                implementation("dev.chrisbanes.material3:material3-window-size-class-multiplatform:0.5.0")
//                implementation("io.github.wojciechosak:calendar:1.0.1")
            }
        }
        val jsMain by getting {
            dependsOn(commonMain)
        }
        val wasmJsMain by getting {
            dependsOn(commonMain)
        }
    }

    tasks {
        val releaseBuildLocation =
            project.projectDir
                .resolve("composeApp")
                .resolve("build")
                .resolve("dist")
                .resolve("productionExecutable")
        val clearDocsFolder = "clearDocsFolder"
        val release = "release"

        named("jsBrowserProductionWebpack") {
            dependsOn("wasmJsProductionExecutableCompileSync")
        }

        named("wasmJsBrowserProductionWebpack") {
            dependsOn("jsProductionExecutableCompileSync")
        }

        register("printVersion") {
            doLast {
                println(version)
            }
        }

        register<Delete>(clearDocsFolder) {
            group = release
            description = "Deletes the previous release"
            delete(fileTree(project.projectDir.resolve("docs")))
        }

        register<Copy>("copyRelease") {
            group = release
            logger.lifecycle("Copying release to /docs")
            from(releaseBuildLocation)
            into(project.projectDir.resolve("docs"))
        }

        register(release) {
            doLast {
                logger.lifecycle("Creating versions-file")
                val docsFolder = project.projectDir.resolve("docs")
                val versionsFile = docsFolder.resolve("version.txt")
                versionsFile.createNewFile()
                versionsFile.writeText(version.toString())
            }
        }
    }
}


