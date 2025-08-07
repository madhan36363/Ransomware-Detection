package com.example.ransomedetector

data class AppInfo(
    val appName: String,
    val packageName: String,
    val permissions: List<String>,
    val isHidden: Boolean,
    val isSystemApp: Boolean,
    val riskCategory: String,
    val score: Int
)
