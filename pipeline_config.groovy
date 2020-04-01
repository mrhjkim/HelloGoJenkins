allow_scm_jenkinsfile = false
libraries{
  common
  make
  github{
	  source_type = "github"
  }
  sonarqube{
    credential_id = "sonarqube"
    sonar_server = "SonarQube"
    enforce_quality_gate = false
  }
}
