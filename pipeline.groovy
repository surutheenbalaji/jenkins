pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Add your build steps here
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Add your test steps here
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy steps here
            }
        }
    }
    post {
        always {
            emailext (
                to: 'your-email@example.com',
                subject: "Jenkins Build ${currentBuild.fullDisplayName}",
                body: "Build completed with status: ${currentBuild.currentResult}",
                attachLog: true
            )
        }
    }
}
