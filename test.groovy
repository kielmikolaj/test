import groovy.json.*
/*
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
*/





def content = """
{
   "app":{ },
   "at":2,
   "badv":[ ],
   "bcat":[ ],
   "device":{
      "carrier":"310-410",
      "connectiontype":3,
      "devicetype":1,
      "dnt":0,
      "dpidmd5":"268d403db34e32c45869bb1401247af9",
      "dpidsha1":"1234" 
   }
}"""

def slurped = new JsonSlurper().parseText(content)
def builder = new JsonBuilder(slurped)
builder.content.device.dpidsha1 = 'abcd'  
println(builder.toPrettyString())
