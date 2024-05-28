pipeline {
    agent any
    stages {
        stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'saisudha nasika', url: 'https://github.com/saisudhanasika/jenkins-task.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building the code using Maven.'
                
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit tests.'
                
                echo 'Running integration tests.'
                
            }
            post {
                success {
                    emailext attachLog: true,
                    body: 'Unit and integration tests passed.',
                    subject: 'Test Success',
                    to: 'saisudhanasika5@gmail.com'
                }
                failure {
                    emailext attachLog: true,
                    body: 'Unit and integration tests failed.',
                    subject: 'Test Failure',
                    to: 'saisudhanasika@gmail.com'
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Analyzing code using SonarQube.'
                
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing security scan.'
                
            }
            post {
                success {
                    emailext attachLog: true,
                    body: 'Security scan passed',
                    subject: 'Security Scan Success',
                    to: 'saisudhanasika5@gmail.com'
                }
                failure {
                    emailext attachLog: true,
                    body: 'Security vulnerabilities found',
                    subject: 'Security Scan Failure',
                    to: 'wali.walimahesh16@gmail.com'
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying the application to staging server.'
                /
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging environment.'
                
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying the application to production server.'
               
            }
        }
    }
}
has context menu


has context menu
