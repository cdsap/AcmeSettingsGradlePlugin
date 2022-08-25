package io.github.acme.settings.gradle.plugin

import com.gradle.enterprise.gradleplugin.GradleEnterpriseExtension
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.api.initialization.resolve.DependencyResolutionManagement
import org.gradle.api.initialization.resolve.RepositoriesMode
import org.gradle.kotlin.dsl.configure

class AcmeSettingsGradlePlugin : Plugin<Settings> {

    override fun apply(target: Settings) {

        target.plugins.apply("com.gradle.enterprise")
        target.plugins.apply("com.gradle.common-custom-user-data-gradle-plugin")
        target.configure<GradleEnterpriseExtension> {
            server = "http://ge.acme.com" // Replace the url with your GE instance
            allowUntrustedServer = true
            buildScan {
                publishAlways()
                capture {
                    isTaskInputFiles = true
                }
                isUploadInBackground = System.getenv("CI") == null
            }
        }
        target.dependencyResolutionManagement {

            repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
            repositories {
                gradlePluginPortal()
                google()
                mavenCentral()
            }
        }
    }
}
