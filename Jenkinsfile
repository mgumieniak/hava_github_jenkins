pipeline {
     agent any
     stages {
          stage("Compile") {
               steps {
                    sh "./gradlew compileJava"
               }
          }
          stage("Unit test") {
               steps {
                    sh "./gradlew test"
               }
          }
          stage("Build and push image") {
              steps {
                    withCredentials([usernamePassword( credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                       sh "./gradlew jib --image=maciejgum/java-github-jenkins -Djib.to.auth.username=${USERNAME} -Djib.to.auth.password=${PASSWORD}"
                    }
              }
          }
     }
}
