pluginManagement {
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

rootProject.name = "My Applicationn"
include(":app")
include(":001_flash")
include(":002_calculator")
include(":learning")
include(":fragment")
include(":layout_inflater")
include(":allinone")
include(":dhammachannel")
