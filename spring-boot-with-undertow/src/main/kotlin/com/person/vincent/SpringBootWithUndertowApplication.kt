package com.person.vincent

import io.undertow.UndertowOptions
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootWithUndertowApplication {

    @Bean
    fun embeddedServletContainerFactory(): UndertowEmbeddedServletContainerFactory {
        val factory = UndertowEmbeddedServletContainerFactory()
        factory.addBuilderCustomizers(
                UndertowBuilderCustomizer { builder ->
                    builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true)
                }
        )
        return factory
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootWithUndertowApplication::class.java, *args)
}
