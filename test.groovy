stage('Bump API version in bom') {
            when {
                expression { params.UPDATE_BOM == true }
            }
            steps {
                dir('ccb-tools/gitflow/temp') {
                    script {
                        PROJECT_VERSION = sh(script: 'mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate \
                                            -Dexpression=project.version -q -DforceStdout', returnStdout: true).trim()
                    }
                }
                script {
                    dir('ccb-bom-modules') {
                        git branch: "$params.UPDATE_BOM_BRANCH",
                                credentialsId: 'fbujenkinsccbref',
                                url: 'ssh://git@fbu-git.krakow.comarch:2224/ccb-ref/backend/components/ccb-bom-modules.git'
                        sh """mvn org.codehaus.mojo:versions-maven-plugin:2.5:set-property \
                              -DallowDowngrade=false -DgenerateBackupPoms=false -DallowSnapshots=false \
                              -DnewVersion='${newVersion}' -Dproperty='ccb-frontend-api-ib.version'"""
                        sh "git config user.name ${GIT_COMMITTER_NAME}"
                        sh "git config user.email ${GIT_COMMITTER_EMAIL}"
                        sh """git commit -am 'bump ccb-frontend-api-ib to ${newVersion}'"""
                        sshagent(credentials: ['fbujenkinsccbref']) {
                            sh "git push origin ${params.UPDATE_BOM_BRANCH}"
                        }
                    }
                }
            }
        }
