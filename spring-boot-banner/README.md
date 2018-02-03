对于使用过 `SpringBoot` 的开发者来说，程序启动的时候输出的由字符组成的 `Spring` 符号并不陌生。这个是 `SpringBoot` 为自己设计的 `Banner` 如下所示：

<!-- more -->
```txt
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v2.0.0.BUILD-SNAPSHOT)
```
在自己的项目中，我们可以 `DIY` 这个启动的 `Banner`，可以通过如下三种方式实现。

这个应该是最方便的一种实现方式了，在 `${root}/resources/` 目录下创建一个 `banner.txt` 文件，然后将想要打印的 `ASCII` 字符粘贴进去，就可以了。下面的就是 `${root}/resources/banner.txt` 文件的内容
```txt
${AnsiColor.BRIGHT_GREEN}
 _
| |
| |__   __ _ _ __  _ __  _   _   _ __   _____      __  _   _  ___  __ _ _ __
| '_ \ / _` | '_ \| '_ \| | | | | '_ \ / _ \ \ /\ / / | | | |/ _ \/ _` | '__|
| | | | (_| | |_) | |_) | |_| | | | | |  __/\ V  V /  | |_| |  __/ (_| | |
|_| |_|\__,_| .__/| .__/ \__, | |_| |_|\___| \_/\_/    \__, |\___|\__,_|_|
            | |   | |     __/ |                         __/ |
            |_|   |_|    |___/                         |___/
Application Version :           ${application.version}
Application Title :             ${application.title}
Spring Boot Version :           ${spring-boot.version}
```
`${}` 是 `SpringBoot` 提供的占位符，`AnsiColor.BRIGHT_GREEN` 是一个枚举值，可以改变 `banner` 在控制台中的输出颜色。`${application.version}` `${application.title}` 在后面会解释。

`springboot` 是非常灵活的，我们可以在 `${root}/resources/application.properties` 文件中定义 `banner` 的相关配置项。常见的几个配置如下所示。
```properties
# 字符集的设置
spring.banner.charset=utf-8
# 指定 banner 的文件名
spring.banner.location=banner.txt
# 输出的位置，可选值还有 log off
spring.main.banner-mode=console
```

`banner` 还可以通过 `Java` 代码的方式来实现。`SpringBoot` 提供了一个接口 `Banner`，我们可以通过实现它的 `printBanner` 方法来从代码层面进行设置。
```kotlin
class MyBanner : Banner {
    override fun printBanner(environment: Environment, sourceClass: Class<*>, out: PrintStream) {
        out.println("==============================================")
        // 设置环境变量，否则会抛出异常
        out.println("Application Version: " + environment["APP_VERSION"])
        out.println("Application Name:    " + environment["APP_NAME"])
        out.println("Spring Boot version: " + environment["SPRING_BOOT_VERSION"])
        out.println("==============================================")
    }
}
```
修改启动类：
```kotlin
fun main(args: Array<String>) {
    val application = SpringApplication(SpringBootBannerApplication::class.java)
    application.setBanner(MyBanner())
    application.run(*args)
}
```
上面提到的在 `banner.txt` 中的占位符该如何使用？`${spring-boot.version}` 这个属性可以直接使用，它会输出当前使用的 SpringBoot 当前的版本。`${application.version}` 和 `${application.title}` 分别用来输出应用程序的版本和名字，这两个属性如果想正常使用，应该在 `MANIFEST.MF` 文件中声明 `Implementation-Version: 1.0` 和 `Implementation-Title: spring boot banner example` 这两个属性。也就意味着这两个属性只能在启动可执行 `Jar` 文件的时候彩后输出。可以在 `build.gradle` 文件中去声明。
```groovy
bootJar {
    manifest {
        attributes(
                "Manifest-Version": 1.0,
                "Implementation-Version": 1.0,
                "Implementation-Title": "spring boot banner example",
        )
    }
}
```
生成的 `MANIFEST.MF` 文件:
```properties
Manifest-Version: 1.0
Implementation-Title: spring boot banner example
Implementation-Version: 1.0
```
如果使用的是 `IntelliJ IDEA` 可以在 `${root}/build/temp/bootJar/MANIFEST.MF` 中查看该文件。
在 `console` 中启动 `SpringBoot`
```txt
$ gradle bootJar

BUILD SUCCESSFUL in 0s
3 actionable tasks: 3 up-to-date

$ java -jar build/libs/spring-boot-banner-1.0-SNAPSHOT.jar

 _
| |
| |__   __ _ _ __  _ __  _   _   _ __   _____      __  _   _  ___  __ _ _ __
| '_ \ / _` | '_ \| '_ \| | | | | '_ \ / _ \ \ /\ / / | | | |/ _ \/ _` | '__|
| | | | (_| | |_) | |_) | |_| | | | | |  __/\ V  V /  | |_| |  __/ (_| | |
|_| |_|\__,_| .__/| .__/ \__, | |_| |_|\___| \_/\_/    \__, |\___|\__,_|_|
            | |   | |     __/ |                         __/ |
            |_|   |_|    |___/                         |___/
Application Version :           1.0
Application Formatted Version :  (v1.0)
Application Title :             spring boot banner example
Spring Boot Version :           2.0.0.BUILD-SNAPSHOT
Spring Boot Formatted Version :  (v2.0.0.BUILD-SNAPSHOT)

==============================================
```

`$ gradle bootJar` 这个命令需要 `spring-boot-gradle-plugin` 这个插件才可以使用
```groovy
buildscript {
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springboot_version}")
    }
}
```
如何关闭 `banner` ? `Banner.Mode.OFF` 可以做到
```kotlin
fun main(args: Array<String>) {
    val application = SpringApplication(SpringBootBannerApplication::class.java)
    application.setBannerMode(Banner.Mode.OFF)
    application.run(*args)
}
```

参考链接
[https://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#boot-features-banner](https://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#boot-features-banner)
[https://www.concretepage.com/spring-boot/spring-boot-custom-banner-example](https://www.concretepage.com/spring-boot/spring-boot-custom-banner-example)