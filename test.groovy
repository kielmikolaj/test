import groovy.json.*

pipeline
{
    agent any

    stages {
        stage('Bump API version in json') {
            steps {
                dir('test'){
                     git branch: 'main',
                     url: 'https://github.com/kielmikolaj/test.git'

                    script{
                        
                        //def config = jsonSlurper.parse(new File('package.json'))
                        def jsonFile = readFile(file: "package.json")
                        def jsonSlurper = new JsonSlurper().parseText(jsonFile)
                        //def versionFind = jsonSlurper.dependencies.find { it.name == "ccb-frontend-apispecification-ib" }
                        //version.value."ccb-frontend-apispecification-ib" = "nowa wersja"
                        //println new JsonBuilder(jsonSlurper).toPrettyString()
                        // println(inputFile)
                        //inputFile["wersja"] = 'nowa wersja'
                        //writeJSON file: "package.json", json: inputFile
                        def jbuilder = new JsonBuilder(jsonSlurper)
                        jbuilder."dependencies"."ccb-frontend-apispecification-ib" = "nowa wersja"
                        //println(jbuilder)
                        jsonFile = null

                    }
               }
            }
        }
    }
}
