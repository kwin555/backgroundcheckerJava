plugins {
  java
  jacoco
  pmd
  application
}

//application {
//  mainClassName = "locator.ISSInit"
//}

repositories {
  mavenCentral()
  maven ( url = "<https://repo1.maven.org/maven2/>")
}

dependencies {
  testCompile("org.junit.jupiter:junit-jupiter-api:5.2.0")
  testRuntime("org.junit.jupiter:junit-jupiter-engine:5.2.0")
  testRuntime("org.junit.platform:junit-platform-console:1.2.0")
  testImplementation("org.hamcrest:hamcrest:2.1")

  compile(group = "org.json", name = "json", version = "20190722")
  compile(group = "org.slf4j", name = "slf4j-jdk14", version = "1.7.25")
  compile(group = "commons-lang", name = "commons-lang", version = "2.6")
  testCompile(group = "org.mockito", name = "mockito-core", version = "2.1.0")
}

sourceSets {
  main {
    java.srcDirs("BackgroundCheck/src")
  }
  test {
    java.srcDirs("BackgroundCheck/tests")
  }
}

tasks {
  val treatWarningsAsError =
    listOf("-Xlint:unchecked", "-Xlint:deprecation", "-Werror")

  getByName<JavaCompile>("compileJava") {
    options.compilerArgs = treatWarningsAsError
  }

  getByName<JavaCompile>("compileTestJava") {
    options.compilerArgs = treatWarningsAsError
  }
}

val test by tasks.getting(Test::class) {
  useJUnitPlatform {}
}

pmd {
  ruleSets = listOf()
  ruleSetFiles = files("../conf/pmd/ruleset.xml")
}

defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")