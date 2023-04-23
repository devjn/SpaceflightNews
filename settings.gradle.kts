rootProject.name = "SpaceFlightNews"

pluginManagement {
    // Get our own convention plugins from 'gradle/plugins'
    includeBuild("gradle/plugins")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// Include all subfolders that contain a 'build.gradle.kts' as subprojects
rootDir.listFiles()?.filter { File(it, "build.gradle.kts").exists() }?.forEach { subproject ->
    include(subproject.name)
}
