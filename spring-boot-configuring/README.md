`Spring Boot` 允许我们将配置外部化，以便可以在不同环境中使用相同的应用程序代码。 我们可以使用 `properties`、`yml` 文件，环境变量和命令行参数来外部化配置。 属性值可以通过使用 `@Value` 注解直接注入到 `bean` 中，通过 `Spring` 的 `Environment` 抽象来访问，或者通过 `@ConfigurationProperties` 绑定到结构化对象。

### @Value 注解
假设 `application.properties` 中存在以下属性
```properties
server.servlet.context-path=/spring-boot-configuring
```
可以通过以下形式来获取属性的值
```kotlin
@Value("\${server.servlet.context-path}")
private lateinit var contentPath: String
```

### 随机数
通过 `${random.xxx}` 可以生成随机数
```properties
random.int=${random.int}
random.less=${random.int(10)}
random.uuid=${random.uuid}
random.secret=${random.value}
```

### @ConfigurationProperties 注解
假设 `application.properties` 中配置了一下属性
```properties
spring.thymeleaf.cache=true
spring.thymeleaf.mode=HTML
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.enabled=true
```
创建读取配置文件的实体类，注意：`prefix` 参数指定配置文件中的需要读取属性的前缀，这里为 `spring.thymeleaf`
```kotlin
@Component
@ConfigurationProperties(prefix = "spring.thymeleaf")
class ThymeleafConfig {
    var cache: Boolean? = null
    var enabled: Boolean? = null
    var mode: String? = null
    var prefix: String? = null
    var suffix: String? = null
}
```
### EnvironmentAware
如何获取到系统的环境变量？在 `SpringBoot` 中可以 通过实现 `EnvironmentAware` 接口来读取。
```kotlin
@Configuration
class MyEnvironmentAware : EnvironmentAware {

    private val logger = LoggerFactory.getLogger(MyEnvironmentAware::class.java)

    override fun setEnvironment(environment: Environment) {
        // 读取系统的环境变量
        logger.info("JAVA_HOME: " + environment.getProperty("JAVA_HOME"))
        // 读取配置文件中的环境变量
        logger.info("SERVER_SERVLET_CONTENT_PATH: " + environment.getProperty("server.servlet.content-path"))
    }
}
```