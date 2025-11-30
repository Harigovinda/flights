pipeline {
    agent any

    tools {
        maven 'Maven set up'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t flights-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                // stop old container if running
                bat '''
                docker stop flights-app-container || true
                docker rm flights-app-container || true
                '''

                // run new container
                bat 'docker run -d -p 8085:8085 --name flights-app-container flights-app'
            }
        }
    }
}
