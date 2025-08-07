package com.example.ransomedetector

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(private val appList: List<AppInfo>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    inner class AppViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val appNameTextView: TextView = view.findViewById(R.id.appNameTextView)
        val packageNameTextView: TextView = view.findViewById(R.id.packageNameTextView)
        val riskStatusTextView: TextView = view.findViewById(R.id.riskStatusTextView)
        val permissionsTextView: TextView = view.findViewById(R.id.permissionsTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = appList[position]
        holder.appNameTextView.text = app.appName
        holder.packageNameTextView.text = app.packageName
        holder.riskStatusTextView.text = app.riskCategory
        holder.permissionsTextView.text = "Permissions:\n" + app.permissions.joinToString("\n")
    }

    override fun getItemCount(): Int = appList.size
}
