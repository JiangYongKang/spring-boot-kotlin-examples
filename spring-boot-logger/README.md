`SpringBoot` 内部使用 `Commons Logging` 来记录日志，但也保留外部接口可以让一些日志框架来进行实现，例如 `Java Util Logging`、`Log4J2` 还有 `Logback`。如果你想用某一种日志框架来进行实现的话，就必须先配置，默认情况下，`SpringBoot` 使用 `Logback` 作为日志实现的框架。
### 基本的日志设置
默认的情况下，SpringBoot 启动时会在控制台打印 `ERROR` `WARN` `INFO` 这三种级别的日志。如果感觉信息不够，可以在 `application.properties` 中配置开启 `debug` 模式。
```properties
debug=true
```
在生产环境中，可以通过命令行参数开启：
```bash
$ java -jar demo-1.0-SNAPSHOT.jar --debug
```
通过 `logging.level` 选项，可以精确配置具体包的日志输出级别。
```properties
logging.level.root=warn
logging.level.org.springframework.web=info
logging.level.org.hibernate=error
```
默认情况下，SpringBoot 是不会将日志输出到文件中的，可以通过以下配置开启。如果试图输出到文件中，则必须开启 `logging.level.root`。否者输出的信息为空。如果只配置 `path`，会默认在项目根目录下生成 `spring.log` 来记录日志。`logging.file` 可以设置绝对路径也可以设置相对路径。这两个不可以都配置。
```properties
logging.level.root=info
logging.path=/Users/vincent/spring-boot-with-kotlin-examples/spring-boot-logger/
logging.file=/Users/vincent/spring-boot-with-kotlin-examples/spring-boot-logger/foo.log
logging.file.max-size=1MB
logging.file.max-history=10
```
### 使用 logback 输出日志
当使用 `LogBack` 的时候，`SpringBoot` 会默认加载 `logback-spring.xml` `logback-spring.groovy` `logback.xml` `logback.groovy` 文件。所以我们可以使用以上任意一个作为文件名，这里使用 `logback-spring.xml` 作为文件名，这也是官方文档的推荐。
下面是一份 `LogBack` 的配置文件，注释已经能很好的说明每一个元素的作用。
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- %d 表示日期 %thread 表示线程名  %-5level 级别从左显示5个字符宽度 %msg 日志消息 %n 是换行符 -->
<configuration scan="true" scanPeriod="60 seconds" debug="false">
    <contextName>LogBack</contextName>
    <property name="LOG_HOME" value="/Users/vincent/developer/spring-boot-with-kotlin-examples/spring-boot-logger/log"/>

    <!--输出到控制台-->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>INFO</level>
        </filter>
        <encoder>
            <!--控制台的输出格式-->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %contextName [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!--输出到文件-->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!--日志文件的保存地址和保留天数-->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_HOME}/logback-%d{yyyy-MM-dd}.log</fileNamePattern>
            <MaxHistory>30</MaxHistory>
        </rollingPolicy>
        <!--日志文件的输出格式-->
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %contextName [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
        <!--日志文件的最大大小-->
        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <MaxFileSize>10MB</MaxFileSize>
        </triggeringPolicy>
    </appender>

    <!--日志输出级别-->
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="FILE"/>
    </root>

    <!-- logback为java中的包 -->
    <logger name="com.person.vincent"/>

    <!--hibernate logger setting-->
    <logger name="org.hibernate.type.descriptor.sql.BasicBinder" level="TRACE"/>
    <logger name="org.hibernate.type.descriptor.sql.BasicExtractor" level="DEBUG"/>
    <logger name="org.hibernate.SQL" level="DEBUG"/>
    <logger name="org.hibernate.engine.QueryParameters" level="DEBUG"/>
    <logger name="org.hibernate.engine.query.HQLQueryPlan" level="DEBUG"/>

    <!--ibatis logger setting-->
    <logger name="com.apache.ibatis" level="TRACE"/>
    <logger name="java.sql.Connection" level="DEBUG"/>
    <logger name="java.sql.Statement" level="DEBUG"/>
    <logger name="java.sql.PreparedStatement" level="DEBUG"/>

    <!--日志异步到数据库-->
    <!--
        <appender name="DB" class="ch.qos.logback.classic.db.DBAppender">
            <connectionSource class="ch.qos.logback.core.db.DriverManagerConnectionSource">
                <dataSource class="com.mchange.v2.c3p0.ComboPooledDataSource">
                    <driverClass>com.mysql.jdbc.Driver</driverClass>
                    <url>jdbc:mysql://127.0.0.1:3306/databaseName</url>
                    <user>root</user>
                    <password>root</password>
                </dataSource>
            </connectionSource>
        </appender>
    -->
</configuration>
```
这时候，启动你的应用。可以从控制台上看到以下信息。同时，项目根目录下会产生一个 `log` 文件夹，里面保存了日志文件。
```log
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v2.0.0.BUILD-SNAPSHOT)

2018-02-12 14:27:16.844 LogBack [main] INFO  c.p.v.SpringBootLoggerApplicationKt - Starting SpringBootLoggerApplicationKt on Strikingly-vincent with PID 7826 (/Users/vincent/developer/spring-boot-with-kotlin-examples/spring-boot-logger/out/production/classes started by vincent in /Users/vincent/developer/spring-boot-with-kotlin-examples)
2018-02-12 14:27:16.849 LogBack [main] INFO  c.p.v.SpringBootLoggerApplicationKt - No active profile set, falling back to default profiles: default
2018-02-12 14:27:16.926 LogBack [main] INFO  o.s.b.w.s.c.AnnotationConfigServletWebServerApplicationContext - Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@13e39c73: startup date [Mon Feb 12 14:27:16 CST 2018]; root of context hierarchy
2018-02-12 14:27:17.737 LogBack [main] INFO  o.s.b.w.e.tomcat.TomcatWebServer - Tomcat initialized with port(s): 8080 (http)
2018-02-12 14:27:17.745 LogBack [main] INFO  o.a.catalina.core.StandardService - Starting service [Tomcat]
2018-02-12 14:27:17.745 LogBack [main] INFO  o.a.catalina.core.StandardEngine - Starting Servlet Engine: Apache Tomcat/8.5.27
```
