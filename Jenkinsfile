def UPSTREAM_PROJECTS_LIST = [ "Mule-runtime/mule-integration-tests/mule-4.2.1",
                               "Mule-runtime/mule-http-service/1.4.2",
                               "Mule-runtime/mule-oauth-service/1.2.0",
                               "Mule-runtime/mule-scheduler-service/1.2.2",
                               "Mule-runtime/mule-soap-service/1.2.0",
                               "Mule-runtime/mule-embedded-api/support/1.2.0",
                               "Mule-runtime/mule-maven-client/support/1.4.0" ]

Map pipelineParams = [ "upstreamProjects" : UPSTREAM_PROJECTS_LIST.join(','),
                       "mavenSettingsXmlId" : "mule-runtime-maven-settings-MuleSettings",
                       "projectType" : "Runtime" ]

runtimeBuild(pipelineParams)
