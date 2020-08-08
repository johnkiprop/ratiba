package com.example.soko.base

import android.app.Application
import com.example.soko.di.ActivityInjector
import timber.log.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject


 open class MyApplication : Application(){
    @Inject lateinit var activityInjector: ActivityInjector
     protected var component: ApplicationComponent? = null
    override fun onCreate() {
        super.onCreate()
        component = initComponent()
        component!!.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
     protected fun initComponent(): ApplicationComponent? {
         return  DaggerApplicationComponent.builder()
             .applicationModule(ApplicationModule(this))
             .build()
     }

   fun getAcInjector(): ActivityInjector? {
        return  activityInjector
    }


}