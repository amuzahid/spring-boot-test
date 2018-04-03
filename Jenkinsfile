pipeline {
    agent any
    tools {
        maven 'MAVEN_3_5_3'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean package' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        stage ('Test'){
            steps {
                sh 'mvn test'
            }
        }
        stage ('Deploy'){
            steps{
                sh 'java -jar target/product-app-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}