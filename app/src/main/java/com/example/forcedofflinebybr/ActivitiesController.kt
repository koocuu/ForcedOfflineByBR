package com.example.forcedofflinebybr

import java.util.ArrayList

object ActivitiesController {
    private val activities = ArrayList<BaseActivity>()
    fun addActivity(activity: BaseActivity){
        activities.add(activity)
    }
    fun desActivity(activity: BaseActivity){
        activities.remove(activity)
    }
    fun finishAll(){
        for (activity in activities){
            if (!activity.isFinishing)
            activity.finish()
        }
    }
}