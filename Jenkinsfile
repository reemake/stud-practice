pipeline {
    agent any

    environment {
            M2_HOME = "/Program Files/Java/apache-maven-3.8.6"
            PATH = "${M2_HOME}/bin:${PATH}"
        }

    stages {
        stage("Compile code") {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage("Tests") {
            when {
                branch 'feature/*'
            }
            steps {
                bat 'mvn test'
            }
        }
        stage("Static analyse") {
            when {
                branch 'develop'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }
        stage("Report") {
            when {
                branch 'feature/*'
            }
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        stage("Install") {
            steps {
                bat 'mvn install'
            }
        }
        stage("Publish") {
            steps {
                bat 'copy "main\\target\\xml-parser-1.0-jar-with-dependencies.jar" "C:\\xml-parser-1.0.jar"'
            }
        }
    }
}
