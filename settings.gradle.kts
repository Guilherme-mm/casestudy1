rootProject.name = "casestudy1"

include("api", "application", "dal", "domain")

project(":api").projectDir = file("modules/api")
project(":application").projectDir = file("modules/application")
project(":dal").projectDir = file("modules/infra/dal")
project(":domain").projectDir = file("modules/domain")