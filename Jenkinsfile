pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("Build") {
            steps {
                checkout scmGit(branches: [[name: '*/main'], [name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ByronCaices/devsecops-prestabanco-backend']])
                sh "mvn clean package -DskipTests"
            }
        }
        stage("Test") {
            stages {
                stage("Unit Testing") {
                    steps {
                        sh "mvn test"
                    }
                }
            }
        }
        stage("Deploy image to Docker Hub"){
            when {
                branch "main"
            }

            steps{
                script {
                   withDockerRegistry(credentialsId:'docker-credentials') {
					sh "docker build -t saki2002/spring-image ."
					sh "docker push saki2002/spring-image"
				   }
                }
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false, onlyIfSuccessful: true
        }
    }
}