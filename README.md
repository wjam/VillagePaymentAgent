# VillagePaymentAgent #
Village Payment Agent Backend Code

## Prerequisites
 * Java 1.8
 * db-derby-10.11.1.1 (or greater)
 * apache-maven-3.0.4 (or greater)

## Build
`mvn package` or `mvn install`

## Test
`mvn test`

`mvn integration-test`

## Run
The simplest way to run the application is to run `mvn jetty:run` and the go to `http://localhost:8080/` in your browser.


## Sonarqube

Previously know as Sonar, Sonarqube is an open platform to manage code quality.
As such, it covers the seven axes of code quality also know as the Developers seven deadly sins.

To run Sonarqube locally:
 1. Download It from Sonarqube website;
 2. Put in a desired location such as ~/usersHome/Projects/sonarqube;
 3. From sonarqube path go to ../Projects/sonarqube/bin/macosx-universal-64 if your OS is MacOS;
 3.1 Otherwise find the relevant OS folder in ../Projects/sonarqube/bin.
 4. Start sonarqube from your command line using "./sonar start" or if you prefer to tail "./sonar console".
 5. Setup a Maven profile for sonar. Optionally if you would like to use an external database then within sonar profile 
    properties you'll have to provide this. Your Maven settings.xml must look something similar as bellow.

<settings>
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
     </profiles>
</settings>

 6. As sonarqube is running on port 9000 go to your http://localhost:9000 to make sure it is working;
 7. From your project path run "mvn clean install"
 8. If previous step is successful run "mvn sonar:sonar" or you can have it in one go "mvn clean install sonar:sonar"
