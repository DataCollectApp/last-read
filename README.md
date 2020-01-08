# last-read
Library for managing last read markers

### How to
Create table to store markers:
```sql
CREATE TABLE last_read
(
    name         VARCHAR(64) NOT NULL,
    id           VARCHAR(64) NOT NULL,
    updated_time VARCHAR(64) NOT NULL
);
```
Make sure you have the following dependencies:
```java
<dependencies>
    <dependency>
        <groupId>app.datacollect</groupId>
        <artifactId>last-read</artifactId>
        <version>0.1.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
        <version>2.2.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>app.datacollect</groupId>
        <artifactId>time</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```
Add `EnableLastRead` annotation to import classes:
```java
@SpringBootApplication
@EnableLastRead
public class ApplicationStarter {
  public static void main(String[] args) {
    SpringApplication.run(ApplicationStarter.class, args);
  }
}
```
Autowire `LastReadService` in the components which needs to manage a marker:
```java
@Service
public class ExcitingService {
  private final LastReadService lastReadService;

  public ExcitingService(LastReadService lastReadService) {
    this.lastReadService = lastReadService;
  }
}
```
Get a marker:
```java
Optional<String> marker = lastReadService.getLastReadId('MARKER_NAME');
```
Save a new marker:
```java
lastReadService.saveLastReadId('MARKER_NAME', '<id>');
```
Update an existing marker:
```java
lastReadService.updateLastReadId('MARKER_NAME', '<id>');
```
