pipeline{
    agent any

     tools{
        maven 'MAVEN'
    } 

    environment{
        PATH = "/usr/local/Cellar/maven/3.9.0/libexec:${PATH}"
        DOCKER_IMAGE = 'bansalc73/calc_dev_ops123:latest'
        CONTAINER_NAME = 'calc_container'
        PORTS = '8080:80'
    }

    stages{
        stage('Clone Git'){
            steps{
                git 'https://github.com/bansalc73/CALCULATOR_DevOps.git'
            }
        }

        stage('Build'){
            steps {
                sh "mvn clean package"
            }
        }
        
        stage('Test'){
            steps{
                 dir('/Users/chiragbansal/Desktop/Test') {
                    sh "mvn test"
                }
                
            }
        }
        stage('Containerize (Push to Dockerhub and pull from Dockerhub)') {
            steps {
                sh "docker build -t calculator ."
                withCredentials([usernamePassword(credentialsId: 'docker_HUb', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker tag calculator bansalc73/calc_dev_ops123:latest'
                    sh 'docker push bansalc73/calc_dev_ops123:latest'
                }
                sh 'docker pull bansalc73/calc_dev_ops123:latest'

            }
        }

        stage('Ansible Deployment') {
            steps {
                script { 
                    sh 'ansible-playbook -i inventory deploy.yml'
                }
            }
        }

    }
}
