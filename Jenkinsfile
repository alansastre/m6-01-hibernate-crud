pipeline {
    agent any
    tools {
        maven "maven3.8.1"
        jdk "jdk16"
    }
    stages {
        stage('Show path') {
            steps {
                bat 'echo %PATH%'
            }
        }
    }
}