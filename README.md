
Introduction
An academic project to showcase how to consume a RESTful web service with Java to get all demanded information about weather and Dependency 
Management with Maven

API
One Call API
Geocoding API
IP address location API

Requirements
You'll need to go create an account to get an API key (https://home.openweathermap.org/api_keys)

Dependencies
Jackson (for the JSON -> Java POJO Deserialization)
<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.12.1</version>
</dependency>

JUnit (for writing Unit Tests)
<dependency>
      <groupId>junit</groupId>
      <artifactId>junit-dep</artifactId>
      <version>4.11</version>
      <type>pom</type>
      <scope>test</scope>
</dependency>

Apache HttpClient (to consume the API)
<dependency>
   <groupId>org.apache.httpcomponents</groupId>
   <artifactId>httpclient</artifactId>
   <version>4.1.1</version>
</dependency>

Apache Log4j
<dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.14.0</version>
</dependency>

Maven Coordinates
To add this library as a dependency add the following maven coordinates into your pom.xml file

<dependency>
    <groupId>gr.unipi.gr</groupId>
    <artifactId>WeatherAPI</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>