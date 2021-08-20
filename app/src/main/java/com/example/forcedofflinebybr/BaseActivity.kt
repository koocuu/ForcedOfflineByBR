package com.example.forcedofflinebybr

import android.content.*
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {
    private val offlineReceiver = OfflineReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivitiesController.addActivity(this)
    }

    override fun onResume() {
        super.onResume()

        IntentFilter("com.example.forcedofflinebybr.FORCE_OFFLINE").apply {
            registerReceiver(offlineReceiver,this)
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(offlineReceiver)
    }
    override fun onDestroy() {
        super.onDestroy()
        ActivitiesController.desActivity(this)
    }

    inner class OfflineReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent?) {
            AlertDialog.Builder(context).apply {
                setTitle("Warning")
                setMessage("U r gonna be FORCED OFFLINE")
                setCancelable(false)
                setPositiveButton("OK") { _, _ ->
                    ActivitiesController.finishAll()
                    startActivity(Intent(context,LoginActivity::class.java))


                }
            }.show()
        }

    }
}