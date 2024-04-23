pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Clean the workspace
                deleteDir()
                
                // Checkout the Git repository
                git branch: 'main', url: 'https://github.com/nadir-0000/Gestion_Ecole.git'
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Navigate to the directory containing the Maven project (root directory)
                    
                        // Run Maven commands (clean, test, package)
                        sh 'mvn clean test package'
                        
                        // Check if the JAR file exists and execute it
                        if (fileExists('target/GeestionEcole-1.0-SNAPSHOT.jar')) {
                            sh "java -jar target/GeestionEcole-1.0-SNAPSHOT.jar"
                        } else {
                            echo "Erreur: Le fichier JAR n'a pas été trouvé."
                        }
                    
                }
            }
        }
    }
}
