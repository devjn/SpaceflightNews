dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include("linter-plugins")
include("android-plugins")
// Include all subfolders that contain a 'build.gradle.kts' as subprojects
//rootDir.listFiles()?.filter { File(it, "build.gradle.kts").exists() }?.forEach { subproject ->
//    include(subproject.name)
//}