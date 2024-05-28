pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building.'
                
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running Unit and Integration Tests.'
               
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Running Code Analysis...'
               
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Running Security Scan.'
                
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to Staging.'
                
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running Integration Tests on Staging.'
                
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying to Production.'
                
            }
        }
    }
    post {
        always {
            echo 'Sending Email Notification.'
            emailext (
                to: 'saisudhanasika5@gmail.com',
                subject: "Jenkins Build ${currentBuild.currentResult}: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: "Build ${currentBuild.currentResult}: Check console output at ${env.BUILD_URL}",
                attachLog: true
            )
        }
    }
}
