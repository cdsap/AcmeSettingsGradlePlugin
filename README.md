#### AcmeSettingsGradlePlugin
This project shows how to encapsulate Gradle Enterprise build logic in a Gradle Settings Plugin.
It contains two project examples using composite builds applying the plugin defined in this project.

The main goal is to reuse the Gradle Enterprise configuration across different projects in the organization:

![Org](/resources/org_plugin.png "Org")

#### Structure
* acme-android-project: Android project using the AcmeSettingsGradlePlugin
* acme-backend-project: Spring project using the AcmeSettingsGradlePlugin
* AcmeSettingsGradlePlugin: Settings Plugin including the build logic

#### AcmeSettingsGradlePlugin content
* Gradle Enterprise Plugin
* Common Custom User Data Gradle Plugin
* Gradle Enterprise and Build Scan configuration

#### Usage

##### Composite Builds
Include the Gradle Settings Plugin path in the `pluginManagment` block at settings.gradle:
```
pluginManagement {
    includeBuild "../AcmeSettingsGradlePlugin"
    ...
}
```
Apply the plugin id provided by the plugin:
```
plugins {
    id("io.github.acme.settings.gradle.plugin")
}
```

##### Published plugin
This project shows only the configuration with composite builds. If your plugin has been published to
Gradle Plugin Portal or an external repository, apply the plugin including the version:
```
plugins {
    id("io.github.acme.settings.gradle.plugin") version "0.0.1"
}
```
To learn more about how to publish plugins, check https://docs.gradle.org/current/userguide/publishing_gradle_plugins.html

### Example

##### Android Project
```
cd acme-android-project
./gradlew assembleDebug
```
##### Backend Project
```
cd acme-backend-project
./gradlew assemble
```

##### Output
The Gradle Enterprise dashboard shows builds used by different projects with the same Settings Plugin.
![Example](/resources/ge.png "Example Gradle Enterprise output")

