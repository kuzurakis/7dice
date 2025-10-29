plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-controls:20")
    implementation("org.openjfx:javafx-fxml:20")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.mockito:mockito-core:5.5.0")
}

application {
    mainClass.set("com.sevendice.app.App")
}

tasks.test {
    useJUnitPlatform()
}