package eu.mshade.enderframe.plugin

data class PluginManifest(val name: String, val version: String, val main: String, val description: String, val authors: List<String>, val depends: List<String> = listOf())
