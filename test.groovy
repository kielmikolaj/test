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
                        //def jsonSlurper = new JsonSlurper()
                        //def config = jsonSlurper.parse(new File('package.json'))
                        def inputFile = readFile(file: "package.json")
                        def InputJSON = new JsonSlurper().parseText(inputFile)
                        
                        inputFile['ccb-frontend-apispecification-ib'] = 'nowa wersja'
                        writeJSON file: 'package.json', json: inputFile
                       // def jbuilder = new JsonBuilder(InputJSON)
                       // jbuilder.inputFile.dependencies."ccb-frontend-apispecification-ib" = "nowa wersja"
                       // println(jbuilder)
                       // println(InputJSON)
                    }
               }
            }
        }
    }
}
