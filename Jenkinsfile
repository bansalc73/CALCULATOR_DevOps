pipeline{
    agent any

     tools{
        maven 'MAVEN'
    } 

    environment{
        PATH = "/usr/local/Cellar/maven/3.9.0/libexec:${PATH}"
        // PATH = "/usr/local/bin/docker:${PATH}"
        // DOCKER_HOST = 'tcp://localhost:2375'
    }

    stages{
        stage('Clone Git'){
            steps{
                git 'https://github.com/bansalc73/CALCULATOR_DevOps.git'
            }
        }

        stage('Build'){
            steps {
                // dir('/Users/chiragbansal/Desktop/Test') {
                //     /* execute commands in the scripts directory */
                //     sh "javac src/Calculator.java"
                //     sh "java src/Calculator"
                // }
                // Maven build, 'sh' specifies it is a shell command
                // sh 'mvn clean install'
                // sh 'docker build -t calculator .'
                sh "mvn clean package"
                // def jarFilePath = sh(returnStdout: true, script: 'find $WORKSPACE -name "*.jar"').trim()

            
        }
            }
        
        stage('Test'){
            steps{
                 dir('/Users/chiragbansal/Desktop/Test') {
                    /* execute commands in the scripts directory */
                    // sh "javac CalculatorTest.java"
                    // sh "java CalculatorTest"
                    // sh "javac -cp lib/junit-4.13.jar:lib/hamcrest-core-1.3.jar -d bin src/*.java test/*.java"
                    // sh "java -cp lib/junit-4.13.jar:lib/hamcrest-core-1.3.jar:bin org.junit.runner.JUnitCore CalculatorTest"
                    sh "mvn test"
                }
                
            }
        }
        stage('Containerize') {
            steps {
                // sh "export PATH=$PATH:/usr/local/bin/docker"
                sh "docker build -t calculator ."
            }
        }

        stage('Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker_HUb', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker tag calculator bansalc73/image123:latest'
                    sh 'docker push bansalc73/image123:latest'
                }
            }
        }
    }
}
