plugins {
  java
  application
}

repositories {
  jcenter()
}

sourceSets {
  main {
    java {
      setSrcDirs(listOf("src"))
    }
  }
}


dependencies {
  implementation("com.google.guava:guava:28.0-jre")
  testImplementation("junit:junit:4.12")
}

application {
  mainClassName = "cyberpunk.App"
}
