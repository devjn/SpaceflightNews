plugins {
    id("org.jlleitschuh.gradle.ktlint")
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
//    version.set("0.42.0")
    android.set(true)
}