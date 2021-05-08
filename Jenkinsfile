pipeline {
  agent any
  stages {
    stage('pp') {
      steps {
        sh '''sh \'mkdir -p AndroidSampleApp\'
dir("AndroidSampleApp"){
    git branch:\'master\', url:\'https://gitee.com/sfboy/AndroidSampleApp.git\'
}'''
      }
    }

  }
}