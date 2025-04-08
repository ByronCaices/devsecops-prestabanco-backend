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
        stage("Deploy image"){
            when {
                branch "main"
            }
            steps {
                sh "docker build . -t prestabanco/backend:latest"
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false, onlyIfSuccessful: true
        }
    }
}