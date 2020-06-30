pipeline {
	agent {label 'master'}
	tools {
		maven 'maven'
		jdk 'jdk8'
		git 'Default'
	}
	options {
		timeout(time: 15, unit: 'MINUTES')
		buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '3'))
	}
	stages {
		stage('Sonalqube Analysis') {
			steps {
				script {
					if (env.BRANCH_NAME.startsWith("PR-")) {
						withCredentials([[$class: 'StringBinding', credentialsId: 'sungsu9022-bot', variable: 'GITHUB_ACCESS_TOKEN']]) {
							withSonarQubeEnv() {
                                sh "mvn clean compile -P sonarqube war:exploded sonar:sonar" +
									" -Dsonar.sourceEncoding=UTF-8" +
									" -Dsonar.analysis.mode=preview" +
									" -Dsonar.github.repository=/sungsu9022/spring-boot-boilerplate" +
									" -Dsonar.github.endpoint=https://github.com" +
									" -Dsonar.github.login=sungsu9022-bot" +
									" -Dsonar.github.oauth=${GITHUB_ACCESS_TOKEN}" +
									" -Dsonar.github.pullRequest=${env.CHANGE_ID}" +
									" -Dsonar.issuesReport.console.enable=true" +
									" -Dsonar.github.disableInlineComments=true"
							}
						}
					} else {
						sh "mvn clean compile -P sonarqube war:exploded sonar:sonar"
					}
				}
			}
		}
	}
}
