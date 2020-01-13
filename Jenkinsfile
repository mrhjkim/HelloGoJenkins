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

		stage('Coverage Report'){
			echo 'Generating Coverage Report'
			sh 'make coverjenkins'
			cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: 'reports/coverage/*.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false
		}
	}	
}
