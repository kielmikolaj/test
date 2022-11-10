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
                        
                        def builder = new JsonBuilder(InputJSON)
                        builder.dependencies."ccb-frontend-apispecification-ib" = "nowa wersja"
                        println(builder)
                       // println(InputJSON)
                    }
               }
            }
        }
    }
}
