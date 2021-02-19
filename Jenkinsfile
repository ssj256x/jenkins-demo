pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/ssj256x/jenkins-demo.git'
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }
        stage('Test') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts 'target/*.jar'
            }
        }
    }
}
