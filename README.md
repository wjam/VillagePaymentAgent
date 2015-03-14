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

If you prefer to run integration tests from your preferred IDE then you might need to get Jetty up and running executing
next step.

## Run
The simplest way to run the application is to run `mvn jetty:run` and the go to `http://localhost:8080/` in your browser.


## Code Quality via SonarQube

Previously know as Sonar, SonarQube is an open platform to manage code quality.  As such, it covers the seven axes of code quality also know as the "developers' seven deadly sins".

### Installation
 1. Download LTS version and install from [SonarQube](http://www.sonarqube.org/downloads/) website.  You can install it in the directory of your own choosing.  We refer to this directory as `<sonarqube>`.
 2. The application binaries are installed in an OS-dependent folder under `<sonarqube>/bin`. For example, the OS X binaries will be in the `<sonarqube>/bin/macosx-universal-64` sub-directory.
 3. Using the command line, cd the directory as outlined in step 2. Start sonarqube from your command line using `./sonar start` or if you prefer to tail `./sonar console`;
 4. Setup a Maven profile for sonar.  You'll need to add the following to your Maven `settings.xml` file.  Usually this will be in `$HOME/.m2`.

```
<settings>
...
    <profiles>
       ...
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
    </profiles>
</settings>
```

### Run
 1. As sonarqube is running on port 9000 open a browser tab and navigate to `http://localhost:9000` to make sure it is working.
 2. From your project path run `mvn clean install`.
 3. If previous step is successful run `mvn sonar:sonar` or you can have it in one go `mvn clean install sonar:sonar`.
 4. Refresh the browser tab from step 1.  You should see the current project metrics.
