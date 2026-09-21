pipeline {
    agent { label 'campus-slave' }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Browser to run tests on')
        choice(name: 'SUITE_XML_FILE', choices: ['testng.xml', 'testng-selenide.xml'], description: 'TestNG suite to run')
        choice(name: 'CUCUMBER_TAGS', choices: ['@regression', '@smoke'], description: 'Cucumber tag filter (ignored by the Selenide suite)')
        choice(name: 'ENV', choices: ['ci', 'local'], description: 'Environment config to use')
    }

    triggers {
        pollSCM('H/5 * * * *')
        cron('H 0 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/eduardorichards/campusautomation-v4.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn clean test -Denv=${params.ENV} -Dsuite.xml.file=${params.SUITE_XML_FILE} -Dbrowser=${params.BROWSER} -Dcucumber.filter.tags=\"${params.CUCUMBER_TAGS}\""
            }
        }

        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/TEST-*.xml'
                archiveArtifacts artifacts: 'target/cucumber-reports/**', allowEmptyArchive: true
            }
        }
    }
}
