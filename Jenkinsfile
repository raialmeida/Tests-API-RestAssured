pipeline {
    agent any

    options {
        ansiColor('xterm')
        timeout(time: 20, unit: 'MINUTES')
    }
    
    stages {
        stage('Build') {
            steps { 
                 // Clean before build
                cleanWs()     
                // We need to explicitly checkout from SCM here
                checkout scm
                sh 'mkdir -p ./allure-results'
                sh 'docker-compose build'
            }
        }

        stage('Test and Report') {
            steps {
                echo 'running tests'
                sh 'docker-compose run --rm api-test mvn test -ntp'
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
                                results: [[path: 'allure-results']],
                                report: 'allure-report'
                        ])
                    }
            } 
    }
}