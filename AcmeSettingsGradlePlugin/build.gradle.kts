plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

dependencies {
    implementation("com.gradle:common-custom-user-data-gradle-plugin:1.8")
    implementation("com.gradle.enterprise:com.gradle.enterprise.gradle.plugin:3.11.1")
}

gradlePlugin {
    plugins {
        register("AcmeSettingsGradplePlugin") {
            id = "io.github.acme.settings.gradle.plugin"
            implementationClass = "io.github.acme.settings.gradle.plugin.AcmeSettingsGradlePlugin"
        }
    }
}
