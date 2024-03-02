pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
        git "Default"
    }
    environment {
        PATH="/opt/homebrew/bin/:/usr/local/bin:$PATH"
        ANSIBLE_PASS = credentials('ANSIBLE_VAULT_PASSWORD')
    }

    stages {
            stage('Get Code') {
                steps {
                    git branch: 'main', url: 'https://github.com/yashrtalele/calculator.git'
                }
            }
            stage('Run Tests') {
              steps {
                sh "mvn test"
              }
            }
            stage('Build Code') {
                steps {
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }
                       /* 
            stage('Docker Build') {
                steps {
                    sh "whereis docker"
                    //sh "docker build -t yashrtalele/calculator:latest ."
                }
            }
            
            stage('Docker Push') {
                steps {
                    sh "docker push yashrtalele/calculator:latest"
                    
                }
            }*/
            
            stage('Docker via ansible') {
                steps {
                    // ansiblePlaybook credentialsId: 'SSH', disableHostKeyChecking: true, installation: 'ansible', playbook: 'docker-playbook.yml'
                    ansiblePlaybook([
                        playbook: 'docker-playbook.yml',
                        installation: 'ansible',
                        colorized: true,
                        credentialsId: 'SSH',
                        disableHostKeyChecking: true,
                        extraVars: [
                            USER: "yashrtalele",
                            PASS: "${ANSIBLE_PASS}"
                        ]
                    ]) 
                }
            }
            stage('Kubernetes via ansible') {
                steps {
                    ansiblePlaybook credentialsId: 'SSH', disableHostKeyChecking: true, installation: 'ansible', playbook: 'kubernetes-playbook.yml'
                }
            }
        }
        post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            always {
                junit 'target/surefire-reports/**/*.xml'
            }
            failure {
                echo "Failure"
            }
        }
        
}
