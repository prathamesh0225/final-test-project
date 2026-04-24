pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/prathamesh0225/final-test-project.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Clean Old Reports') {
            steps {
                bat '''
                if exist report rmdir /s /q report
                if exist test.jtl del test.jtl
                '''
            }
        }

        stage('Run JMeter') {
            steps {
                bat '"%JMETER%\\jmeter.bat" -n -t parabank_login_test.jmx -l test.jtl -e -o report'
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'allure-results']]
                ])
            }
        }

        stage('Publish Report') {
    steps {
        publishHTML([
            reportDir: 'report',
            reportFiles: 'index.html',
            reportName: 'JMeter Report',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: true
        ])
    }
}
    }
}
