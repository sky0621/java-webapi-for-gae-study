# java-webapi-for-gae-study

$ mvn archetype:generate -Dappengine-version=1.9.67 -Djava8=true -Dfilter=com.google.appengine.archetypes:
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO] 
[INFO] 
[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
Choose archetype:
1: remote -> com.google.appengine.archetypes:appengine-flexible-archetype (A basic Java application with Google App Engine flexible.)
2: remote -> com.google.appengine.archetypes:appengine-skeleton-archetype (A skeleton application with Google App Engine)
3: remote -> com.google.appengine.archetypes:appengine-standard-archetype (A basic Java application with Google App Engine Standard)
4: remote -> com.google.appengine.archetypes:endpoints-skeleton-archetype (A skeleton project using Cloud Endpoints Frameworks with Google App Engine Standard)
5: remote -> com.google.appengine.archetypes:guestbook-archetype (A guestbook application with Google App Engine)
6: remote -> com.google.appengine.archetypes:hello-endpoints-archetype (A simple starter application using Cloud Endpoints Frameworks with Google App Engine Standard)
7: remote -> com.google.appengine.archetypes:skeleton-archetype (Archetype with a README about Google App Engine archetypes)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 4
Choose com.google.appengine.archetypes:endpoints-skeleton-archetype version: 
1: 1.0
2: 1.1
3: 1.1.1-1.9.4
4: 1.1.2-1.9.20
5: 1.1.3-1.9.21
6: 1.1.4-1.9.25
7: 1.1.5-1.9.38
8: 2.0.0
Choose a number: 8: 
Define value for property 'groupId': com.example.sky0621.fs2
Define value for property 'artifactId': com.example.sky0621.fs2
Define value for property 'version' 1.0-SNAPSHOT: : 
Define value for property 'package' com.example.sky0621.fs2: : 
[INFO] Using property: appengine-plugin = 1.3.1
[INFO] Using property: appengine-sdk = 1.9.53
[INFO] Using property: endpoints-frameworks = 2.0.7
[INFO] Using property: endpoints-plugin = 1.0.0
[INFO] Using property: google-cloud-project = YOUR-PROJECT-ID
[INFO] Using property: gradle-appengine-plugin = +
[INFO] Using property: gradle-endpoints-frameworks = +
[INFO] Using property: gradle-endpoints-plugin = +
Confirm properties configuration:
groupId: com.example.sky0621.fs2
artifactId: com.example.sky0621.fs2
version: 1.0-SNAPSHOT
package: com.example.sky0621.fs2
appengine-plugin: 1.3.1
appengine-sdk: 1.9.53
endpoints-frameworks: 2.0.7
endpoints-plugin: 1.0.0
google-cloud-project: YOUR-PROJECT-ID
gradle-appengine-plugin: +
gradle-endpoints-frameworks: +
gradle-endpoints-plugin: +
 Y: : y
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: endpoints-skeleton-archetype:2.0.0
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.example.sky0621.fs2
[INFO] Parameter: artifactId, Value: com.example.sky0621.fs2
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: com.example.sky0621.fs2
[INFO] Parameter: packageInPathFormat, Value: com/example/sky0621/fs2
[INFO] Parameter: appengine-sdk, Value: 1.9.53
[INFO] Parameter: endpoints-plugin, Value: 1.0.0
[INFO] Parameter: endpoints-frameworks, Value: 2.0.7
[INFO] Parameter: gradle-endpoints-frameworks, Value: +
[INFO] Parameter: groupId, Value: com.example.sky0621.fs2
[INFO] Parameter: gradle-appengine-plugin, Value: +
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: gradle-endpoints-plugin, Value: +
[INFO] Parameter: google-cloud-project, Value: YOUR-PROJECT-ID
[INFO] Parameter: package, Value: com.example.sky0621.fs2
[INFO] Parameter: artifactId, Value: com.example.sky0621.fs2
[INFO] Parameter: appengine-plugin, Value: 1.3.1
[INFO] Project created from Archetype in dir: /work/src/java/github.com/sky0621/java-webapi-for-gae-study/com.example.sky0621.fs2
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 47:34 min
[INFO] Finished at: 2018-11-20T22:54:51+09:00
[INFO] Final Memory: 18M/195M
[INFO] ------------------------------------------------------------------------
