node {
	def root = tool name: 'Go 1.13', type: 'go'
	withEnv(["GOROOT=${root}", "PATH+GO=${root}/bin:${HOME}/go/bin"]) {
		stage('Checkout'){
			echo 'Checking out SCM'
			office365ConnectorSend message: "checkout", status:"started", webhookUrl:'https://outlook.office.com/webhook/312bb46b-563d-4a01-98b3-19a6af343ee4@13a84ba8-5a74-4cdf-a639-57395cf71a8f/JenkinsCI/989bf646578b4ae7b4292217cc784740/26be0387-a489-467b-bfe7-e257962735fd'
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
