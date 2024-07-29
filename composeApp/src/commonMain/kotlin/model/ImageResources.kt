package model

import org.jetbrains.compose.resources.DrawableResource

data class LocalImageResource(val resource: DrawableResource) : ResourceAccessor

data class RemoteImageResource(val link: String) : ResourceAccessor