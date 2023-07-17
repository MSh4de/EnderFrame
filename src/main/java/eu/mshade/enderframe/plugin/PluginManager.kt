package eu.mshade.enderframe.plugin

import java.io.InputStream
import java.nio.file.Path

interface PluginManager {

    fun loadPlugin(path: Path): Plugin

    fun loadPlugins(directory: Path)

    fun enablePlugin(plugin: Plugin)

    fun enablePlugins()

    fun disablePlugin(plugin: Plugin)

    fun getPluginManifest(inputStream: InputStream): PluginManifest
}