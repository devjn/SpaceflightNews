plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(project(":linter-plugins"))
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}
