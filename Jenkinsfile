pipeline { agent any stages { stage('Checkout') { steps { // clean the directory sh "rm -rf *" //
Checkout the Git repository sh "git clone https://github.com/nadir-0000/Gestion_Ecole.git" } }
stage('Build') { steps { // Here, we can can run Maven commands script { def currentDir = pwd()
echo "Current directory: ${currentDir}" // Navigate to the directory containing the Maven project
dir('java-maven/maven') { // Run Maven commands sh 'mvn clean test package' sh "java -jar
target/GeestionEcole-1.0-SNAPSHOT.jar" } } } } } }
