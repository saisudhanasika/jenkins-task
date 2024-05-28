pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Example build tool: Maven
                // sh 'mvn clean package'
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running Unit and Integration Tests...'
                // Example test tool: JUnit
                // sh 'mvn test'
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Running Code Analysis...'
                // Example code analysis tool: SonarQube
                // sh 'sonar-scanner'
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Running Security Scan...'
                // Example security scan tool: OWASP Dependency Check
                // sh 'dependency-check.sh --project myApp --scan .'
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to Staging...'
                // Example deployment: AWS CLI
                // sh 'aws deploy ...'
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running Integration Tests on Staging...'
                // Example test tool: Postman/Newman
                // sh 'newman run tests.postman_collection.json'
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying to Production...'
                // Example deployment: AWS CLI
                // sh 'aws deploy ...'
            }
        }
    }
    post {
        always {
            echo 'Sending Email Notification...'
            emailext (
                to: 'saisudhanasika5@gmail.com',
                subject: "Jenkins Build ${currentBuild.currentResult}: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: "Build ${currentBuild.currentResult}: Check console output at ${env.BUILD_URL}",
                attachLog: true
            )
        }
    }
}
