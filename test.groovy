import groovy.json.*

pipeline
{
    agent any

    stages {
        stage('Bump API version in json') {
            steps {
                dir('test'){
                    script{
                        //def jsonSlurper = new JsonSlurper()
                        //def config = jsonSlurper.parse(new File('package.json'))
                        def inputFile = new File("package.json")
                        def InputJSON = new JsonSlurper().parseText(inputFile.text)
                        println(InputJSON)
                    }
                }
            }
        }
    }
}
            
//             steps 
//             {
//                 script 
//                 {
//                     dir('test') 
//                     {
//                        // git branch: "$params.UPDATE_BOM_BRANCH",
//                                 //credentialsId: 'fbujenkinsccbref',
//                             //    url: 'https://github.com/kielmikolaj/test.git'
                                
                                
                      
                                
                                
//                        /* sh "git config user.name ${GIT_COMMITTER_NAME}"
//                         sh "git config user.email ${GIT_COMMITTER_EMAIL}"
//                         sh """git commit -am 'bump ccb-frontend-api-ib to ${newVersion}'"""
//                         sshagent(credentials: ['fbujenkinsccbref']) {
//                             sh "git push origin ${params.UPDATE_BOM_BRANCH}" 
//                         } */
//                   //  }
//               //  }
//           //  }
// //}
