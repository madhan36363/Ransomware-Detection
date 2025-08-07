package com.example.ransomedetector

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AppListFragment(private val type: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_app_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val pm = requireContext().packageManager
        val allApps = pm.getInstalledApplications(PackageManager.GET_META_DATA).map { app ->
            val permissions = try {
                pm.getPackageInfo(app.packageName, PackageManager.GET_PERMISSIONS).requestedPermissions?.toList()
                    ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
            val isHidden = pm.getLaunchIntentForPackage(app.packageName) == null
            val isSystem = (app.flags and android.content.pm.ApplicationInfo.FLAG_SYSTEM) != 0
            val score = calculateScore(permissions, isHidden)
            val risk = when {
                score >= 3 -> "Malicious"
                score == 2 -> "Suspicious"
                else -> "Safe"
            }
            AppInfo(
                appName = pm.getApplicationLabel(app).toString(),
                packageName = app.packageName,
                permissions = permissions,
                isHidden = isHidden,
                isSystemApp = isSystem,
                riskCategory = risk,
                score = score
            )
        }

        val filteredApps = when (type) {
            "System" -> allApps.filter { it.isSystemApp }
            "Known" -> allApps.filter { !it.isSystemApp && KNOWN_APPS.contains(it.packageName) }
            else -> allApps.filter { !it.isSystemApp && !KNOWN_APPS.contains(it.packageName) }
        }

        recyclerView.adapter = AppAdapter(filteredApps)
        return view
    }

    private fun calculateScore(permissions: List<String>, isHidden: Boolean): Int {
        var score = 0
        if (permissions.contains("android.permission.SYSTEM_ALERT_WINDOW")) score += 2
        if (permissions.count { it.startsWith("android.permission.") } >= 3) score += 2
        if (permissions.contains("android.permission.CAMERA") && permissions.contains("android.permission.RECORD_AUDIO")) score += 1
        if (isHidden) score += 1
        return score
    }

    companion object {
        val KNOWN_APPS = setOf(
            "com.facebook.katana",
            "com.instagram.android",
            "com.whatsapp"
        )
    }
}
