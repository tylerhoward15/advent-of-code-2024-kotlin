plugins {
    kotlin("jvm") version "2.1.0"
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.11.1"
    }
}

dependencies {
    // https://mvnrepository.com/artifact/com.google.ortools/ortools-java
    implementation("com.google.ortools:ortools-java:9.11.4210")
}