allow_scm_jenkinsfile = false
libraries{
  common
  make
  sonarqube{
    credential_id = "sonarqube"
    sonar_server = "SonarQube"
    enforce_quality_gate = false
  }
}
