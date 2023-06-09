plugins {
    id("peonlee.android.application")
    id("peonlee.android.application.compose")
    id("peonlee.android.hilt")
    id("peonlee.android.sns.login.application")
}

android {
    namespace = "com.peonlee"
    defaultConfig {
        applicationId = "com.peonlee"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":feature:login"))
    implementation(project(":feature:evaluate"))
    implementation(project(":feature:main"))
    implementation(project(":feature:detail"))
    implementation(project(":feature:review"))

    implementation(libs.androidx.core.splashscreen)
}
