plugins {
    id("org.jetbrains.intellij.platform")
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

dependencies {
    intellijPlatform {
        // Set platformLocalPath (e.g. in ~/.gradle/gradle.properties) to use an IDE already on disk
        // instead of downloading platformVersion.
        val localPath = providers.gradleProperty("platformLocalPath")
        if (localPath.isPresent) {
            local(localPath.get())
        } else {
            intellijIdea(providers.gradleProperty("platformVersion"))
        }
    }
}

intellijPlatform {
    // A theme contributes no settings pages, so there is nothing to index.
    buildSearchableOptions = false

    pluginConfiguration {
        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
            untilBuild = provider { null }
        }
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}

// Standalone editor scheme for Settings | Editor | Color Scheme | Import Scheme.
val exportColorScheme = tasks.register<Copy>("exportColorScheme") {
    from("src/main/resources/themes/tsdh-light.xml")
    into(layout.buildDirectory.dir("colorScheme"))
    rename { "tsdh-light.icls" }
}

tasks.named("buildPlugin") {
    finalizedBy(exportColorScheme)
}
