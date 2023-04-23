plugins {
    id("com.jfayz.android-library")
}

android {
    namespace = "com.devjn.spaceflightnews"
}

dependencies {
    api(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    testImplementation(libs.junit)
}
