pipeline {
    agent any

    tools {
        maven 'Maven set up'    // Name you gave in Global Tool Configuration
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}
