pipeline {
    agent any

    stages {

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
                bat '"%JMETER_HOME%\\bin\\jmeter.bat" -n -t parabank_login_test.jmx -l test.jtl -e -o report'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: 'report',
                    reportFiles: 'index.html',
                    reportName: 'JMeter Report'
                ])
            }
        }
    }
}