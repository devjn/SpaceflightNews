plugins {
    id("com.jfayz.android-application")
    id("com.google.devtools.ksp")
}
android {
    namespace = "com.devjn.spaceflightnews"

    defaultConfig {
        applicationId = "com.jfayz.spaceflightnews"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(project(":data"))
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.glide)
    ksp(libs.glide.ksp)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
}
