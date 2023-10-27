pipeline {
    agent any

    options {
        ansiColor('xterm')
        timeout(time: 20, unit: 'MINUTES')
    }
    
    stages {
        stage('Build') {
            steps {      
                // We need to explicitly checkout from SCM here
                checkout scm
                sh 'mkdir -p ./API-RestAssured/allure-results'
                sh 'docker-compose -f API-RestAssured/docker-compose.yml build'
            }
        }

        stage('Test and Report') {
            steps {
                echo 'running tests'
                sh 'docker-compose -f API-RestAssured/docker-compose.yml run --rm api-test mvn test'
            }
        }
    }

    post {
        always{
        		junit '**/target/surefire-reports/*.xml'
                script{
                        allure([
                                includeProperties: false, 
                                jdk: '', 
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'API-RestAssured/allure-results']],
                                report: 'API-RestAssured/allure-report'
                        ])
                    }
            } 
    }
}