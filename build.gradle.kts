import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.2" apply false
	id("io.spring.dependency-management") version "1.1.2" apply false
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22" apply false
	kotlin("plugin.jpa") version "1.8.22" apply false
}

allprojects{
	group = "com.sim"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<JavaCompile>{
		sourceCompatibility = "17"
		targetCompatibility = "17"
	}

	repositories {
		mavenCentral()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects{
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-kapt")

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		runtimeOnly("com.mysql:mysql-connector-j")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}
}