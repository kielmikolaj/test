import groovy.json.JsonBuilder
import groovy.json.JsonSlurperClassic 

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
 
                        def jsonSlurper = new groovy.json.JsonSlurperClassic()
                        //def config = jsonSlurper.parse(new File('package.json'))
                        def inputFile = readFile(file: "package.json")
                        def InputJSON = jsonSlurper.parseText(inputFile)
                        // println(inputFile)
                        //inputFile["wersja"] = 'nowa wersja'
                        //writeJSON file: "package.json", json: inputFile
                        def jbuilder = new JsonBuilder(InputJSON)
                        jbuilder.inputFile.dependencies.wersja = "nowa wersja"
                        println(jbuilder)

                    }
               }
            }
        }
    }
}
