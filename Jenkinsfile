pipeline {
    agent any

    trigger {
        pollSCM('0/10 * * * *')
    }

    stages {
        stage('Build') {
            git 'https://github.com/ssj256x/jenkins-demo.git'
            sh './mvnw -Dmaven.test.failure.ignore=true clean package'
        }
        post {
            success {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts 'target/*.jar'
            }
        }
    }
}