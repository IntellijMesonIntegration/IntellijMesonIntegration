# CLion Meson Integration
This plugin attempts to add CMake-like integration for the Meson Build
System in CLion.

This plugin is very early in development, and is not anywhere close to
production ready. You can check the progress
[here](https://github.com/NonNullDinu/CLionMesonIntegration/projects/1).

Also, feel free to join [our discord](https://discord.gg/ZFFANpR) if
you are interested in the plugin.

# Latest release
[v.0.0.1-SNAPSHOT](https://github.com/IntellijMesonIntegration/IntellijMesonIntegration/releases/tag/0.0.1-SNAPSHOT)

# Building from source
## Configuration
* Make sure gradle can download clion and jbr without going out of heap space; a simple fix if you encounter this: add/increase MaxHeapSize to about 1 GiB(`org.gradle.jvmargs=-XX:MaxHeapSize=1024m`) in `~/.gradle/gradle.properties`.
* Load the project