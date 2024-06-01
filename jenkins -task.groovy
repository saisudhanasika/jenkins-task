pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Performing build...'
            }
            post {
                success {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Success: Build Stage',
                         body: 'The build stage completed successfully.'
                }
                failure {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Failure: Build Stage',
                         body: 'The build stage failed. Please check the Jenkins logs for more details.'
                }
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit and integration tests...'
                // Example command for running tests, replace with actual commands
                // sh 'run-tests.sh'
            }
            post {
                success {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Success: Unit and Integration Tests Stage',
                         body: 'The unit and integration tests stage completed successfully.'
                }
                failure {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Failure: Unit and Integration Tests Stage',
                         body: 'The unit and integration tests stage failed. Please check the Jenkins logs for more details.'
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Performing code analysis...'
                // Example command for code analysis, replace with actual commands
                // sh 'run-code-analysis.sh'
            }
            post {
                success {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Success: Code Analysis Stage',
                         body: 'The code analysis stage completed successfully.'
                }
                failure {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Failure: Code Analysis Stage',
                         body: 'The code analysis stage failed. Please check the Jenkins logs for more details.'
                }
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing security scan...'
                // Example command for security scan, replace with actual commands
                // sh 'run-security-scan.sh'
            }
            post {
                success {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Success: Security Scan Stage',
                         body: 'The security scan stage completed successfully.'
                }
                failure {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Failure: Security Scan Stage',
                         body: 'The security scan stage failed. Please check the Jenkins logs for more details.'
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging...'
                // Example command for deployment, replace with actual commands
                // sh 'deploy-to-staging.sh'
            }
            post {
                success {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Success: Deploy to Staging Stage',
                         body: 'The deploy to staging stage completed successfully.'
                }
                failure {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Failure: Deploy to Staging Stage',
                         body: 'The deploy to staging stage failed. Please check the Jenkins logs for more details.'
                }
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging...'
                // Example command for integration tests, replace with actual commands
                // sh 'run-staging-tests.sh'
            }
            post {
                success {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Success: Integration Tests on Staging Stage',
                         body: 'The integration tests on staging stage completed successfully.'
                }
                failure {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Failure: Integration Tests on Staging Stage',
                         body: 'The integration tests on staging stage failed. Please check the Jenkins logs for more details.'
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying to production...'
                // Example command for production deployment, replace with actual commands
                // sh 'deploy-to-production.sh'
            }
            post {
                success {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Success: Deploy to Production Stage',
                         body: 'The deploy to production stage completed successfully.'
                }
                failure {
                    mail to: 'saisudhanasika5@gmail.com',
                         subject: 'Pipeline Failure: Deploy to Production Stage',
                         body: 'The deploy to production stage failed. Please check the Jenkins logs for more details.'
                }
            }
        }
    }
}
