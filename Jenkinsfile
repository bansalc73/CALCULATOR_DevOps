pipeline{
    agent any

    stages{
        stage('Clone Git'){
            steps{
                git 'https://github.com/bansalc73/CALCULATOR_DevOps.git'
            }
        }

        stage('Build'){
            steps {
                dir('/Users/chiragbansal/Desktop/Test/src') {
                    /* execute commands in the scripts directory */
                    sh "javac Calculator.java"
                    sh "java Calculator"
                }
                // Maven build, 'sh' specifies it is a shell command
                // sh 'mvn clean install'
            
        }
            }
        
        stage('Test'){
            steps{
                 dir('/Users/chiragbansal/Desktop/Test') {
                    /* execute commands in the scripts directory */
                    // sh "javac CalculatorTest.java"
                    // sh "java CalculatorTest"
                    sh "javac -cp lib/junit-4.13.jar:lib/hamcrest-core-1.3.jar -d bin src/*.java test/*.java"
                    sh "java -cp lib/junit-4.13.jar:lib/hamcrest-core-1.3.jar:bin org.junit.runner.JUnitCore CalculatorTest"
                }
                
            }
        }
    }
}
