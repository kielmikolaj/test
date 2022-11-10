import groovy.json.*


//stage('Bump API version in json') 
//{
            
            def jsonSlurper = new JsonSlurper()
            config = jsonSlurper.parse(new File('package.json'))
            println(config
            
            
            
            //steps 
           // {
               // script 
              //  {
                  //  dir('test') 
                  //  {
                       // git branch: "$params.UPDATE_BOM_BRANCH",
                                //credentialsId: 'fbujenkinsccbref',
                            //    url: 'https://github.com/kielmikolaj/test.git'
                                
                                
                      
                                
                                
                       /* sh "git config user.name ${GIT_COMMITTER_NAME}"
                        sh "git config user.email ${GIT_COMMITTER_EMAIL}"
                        sh """git commit -am 'bump ccb-frontend-api-ib to ${newVersion}'"""
                        sshagent(credentials: ['fbujenkinsccbref']) {
                            sh "git push origin ${params.UPDATE_BOM_BRANCH}" 
                        } */
                  //  }
              //  }
          //  }
//}
