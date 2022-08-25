plugins {
    id("org.springframework.boot") version "2.7.1"
    id("org.jetbrains.kotlin.jvm")
}

springBoot {
    mainClass.set("com.example.service.MyClass")
}
