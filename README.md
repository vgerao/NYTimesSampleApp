# NYTimesSampleApp

Implemented Using the following: 

1) MVVM Architectural Pattern 
2) Android JetPack Components   
3) Dagger 2 for Dependency Injection
4) Retrofit with Okhttp
5) Room DataBase for data caching 
6) JUnit and Mockito for Unit testing   



# Build Process : 

Open terminal in Android Studio (if the system is windows) and type the below command to generate debug build 

gradlew.bat assembleDebug or 

gradlew assembleDebug or 

./gradlew assembleDebug

# For release build Use the following command 

./gradlew assembleRelease or 

gradlew.bat assembleRelease or 

gradlew assembleRelease

# Generate Sonarqube report :

Open gradle.properties and update the below line with the sonarqube server url

systemProp.sonar.host.url=http://localhost:9000

Before running the sonarqube job, make sure the project version has been updated in the build.gradle. On every run, increment the version by 1.

            property "sonar.sources", "src/main"
            property "sonar.projectName", "NYTimesSampleApp" // Name of your project
            property "sonar.projectVersion", "1.0.0" // Version of your project
            property "sonar.projectDescription", "NYTimesSampleApp list out the most popular Articles"
			
For running the sonarqube job, type the below command in the terminal. 

./gradlew sonarqube assembleDebug


# Generate code coverage report :

Open terminal and type the following command

./gradlew clean jacocoTestReport

The coverage report will be generated on the following path.

app/build/reports/tests/testDebugUnitTest
