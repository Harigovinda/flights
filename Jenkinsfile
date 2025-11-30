pipeline {
    agent any

    tools {
        maven 'Maven set up'   // Your Maven installation name in Jenkins
    }

    environment {
        IMAGE_NAME = "flights-app"
        CONTAINER_NAME = "flights-container"
    }

    stages {

        stage('Build Maven') {
            steps {
                echo "Building Spring Boot application..."
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Docker Build') {
            steps {
                echo "Building Docker image..."
                script {
                    docker.build("${IMAGE_NAME}")
                }
            }
        }

        stage('Stop Old Container') {
            steps {
                script {
                    echo "Stopping old container if exists..."
                    bat """
                    docker stop %CONTAINER_NAME% || echo No container to stop
                    docker rm %CONTAINER_NAME% || echo No container to remove
                    """
                }
            }
        }

        stage('Run New Docker Container') {
            steps {
                echo "Starting new Docker container..."
                bat """
                docker run -d -p 8085:8085 --name %CONTAINER_NAME% %IMAGE_NAME%
                """
            }
        }
    }
}
