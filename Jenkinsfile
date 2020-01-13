node {
	def root = tool name: 'Go 1.13', type: 'go'
	withEnv(["GOROOT=${root}", "PATH+GO=${root}/bin:${HOME}/go/bin"]) {
		stage('Checkout'){
			echo 'Checking out SCM'
			checkout scm
		}

		stage('Pre Test'){
			echo 'Pulling Dependencies'
			sh 'make dep'
		}

		stage('Build'){
			echo 'Build'
			sh 'make build'
		}

		stage('Test'){
			echo 'Test'
			sh 'make junittest'
			junit 'reports/unittest/*.xml'
		}
	}	
}
