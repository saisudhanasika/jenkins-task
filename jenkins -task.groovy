pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'saisudha', url: 'https://github.com/saisudhanasika/jenkins-task.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building the code using Maven.'
                // Example build command
                // sh 'mvn clean package'
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit tests.'
                // Example unit test command
                // sh 'mvn test'

                echo 'Running integration tests.'
                // Example integration test command
                // sh 'mvn verify'
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
                    to: 'saisudhanasika5@gmail.com'
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Analyzing code using SonarQube.'
                // Example code analysis command
                // withSonarQubeEnv('SonarQube') {
                //     sh 'mvn sonar:sonar'
                // }
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing security scan.'
                // Example security scan command
                // sh 'dependency-check.sh --project myApp --scan .'
            }
            post {
                success {
                    emailext attachLog: true,
                    body: 'Security scan passed.',
                    subject: 'Security Scan Success',
                    to: 'saisudhanasika5@gmail.com'
                }
                failure {
                    emailext attachLog: true,
                    body: 'Security vulnerabilities found.',
                    subject: 'Security Scan Failure',
                    to: 'saisudhanasika5@gmail.com'
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying the application to staging server.'
                // Example deployment command
                // sh 'aws deploy create-deployment --application-name MyApp --deployment-group-name StagingGroup --s3-location bucket=mybucket,key=myapp.zip,bundleType=zip'
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging environment.'
                // Example integration test command on staging
                // sh 'newman run tests.postman_collection.json'
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying the application to production server.'
                // Example deployment command
                // sh 'aws deploy create-deployment --application-name MyApp --deployment-group-name ProductionGroup --s3-location bucket=mybucket,key=myapp.zip,bundleType=zip'
            }
        }
    }
}
