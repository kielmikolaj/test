import groovy.json.*

            pipeline
{
                        agent any

                        
            stages{
stage('Bump API version in json') 
{
            
           
            
            steps {
                       // dir('test'){
                                    script{
                                                 def jsonSlurper = new JsonSlurper()
                                                def config = jsonSlurper.parse('https://github.com/kielmikolaj/test/blob/5ed1dd6219f548e7ad38de01f306978b4b08c417/package.json'.toURL())
                                                println(config)
                                    }
                       // }
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
