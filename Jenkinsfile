def UPSTREAM_PROJECTS_LIST = [ "Mule-runtime/mule-integration-tests/4.1.5-AUGUST",
                               "Mule-runtime/mule-http-service/1.2.0",
                               "Mule-runtime/mule-oauth-service/1.1.6",
                               "Mule-runtime/mule-scheduler-service/1.1.7",
                               "Mule-runtime/mule-soap-service/1.1.8",
                               "Mule-runtime/mule-embedded-api/1.1.3-AUGUST",
                               "Mule-runtime/mule-maven-client/1.2.1-AUGUST" ]

Map pipelineParams = [ "upstreamProjects" : UPSTREAM_PROJECTS_LIST.join(','),
                       "mavenSettingsXmlId" : "mule-runtime-maven-settings-MuleSettings",
                       "projectType" : "Runtime" ]

runtimeBuild(pipelineParams)
