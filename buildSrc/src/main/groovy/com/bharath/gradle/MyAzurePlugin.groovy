package com.bharath.gradle

import org.gradle.api.Project
import org.gradle.api.Plugin

class MyAzurePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task("copyToBucket") {
            doLast {
                println "File copied to bucket."
            }
        }
        project.task("deployToEngine") {
            doLast {
                println "App deployed to Engine."
            }
        }
    }
}