# CLion Meson Integration
This plugin attempts to add CMake-like integration for the Meson Build
System in CLion.

This plugin is very early in development, and is not anywhere close to
production ready. You can check the progress
[here](https://github.com/NonNullDinu/CLionMesonIntegration/projects/1).

# Building from source
## Configuration
* Create a file `gradle.properties` in `~/.gradle/` with the content: `org.gradle.jvmargs=-XX:MaxHeapSize=1024m`
* Make sure gradle user home is set to `~/.gradle/` in File > Settings > Build, Execution, Deployement > Build tools > gradle
* Load the project