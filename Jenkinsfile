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
                sh 'mvn test sonar:sonar -Dsonar.host.url=http://1ocalhost:9000 -Dsonar.login=07a0049e146a45a0952b8dd15328cfd25e9606b1'
            }
        }
        stage ('Deploy'){
            steps{
                sh '''
                    docker rm -f myjob
                    docker run -d --name myjob -p 9999:8090 product
                '''
            }
        }
    }
}