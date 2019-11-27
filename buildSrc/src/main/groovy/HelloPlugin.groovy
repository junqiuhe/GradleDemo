import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloPlugin2 implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.task("helloPlugin2Task"){

            group 'customPlugin'

            doFirst {
                println "Hello Plugin 2"
            }
        }
    }
}