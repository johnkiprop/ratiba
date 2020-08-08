package com.example.soko.ui

import com.example.soko.lifecycle.ActivityLifecycleTask
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet


@Module
abstract class NavigationModule {
    @Binds
    abstract fun provideScreenNavigator(screenNavigator: DefaultScreenNavigator?): ScreenNavigator?

    @Binds
    @IntoSet

    abstract fun bindScreenNavigatorTask(screenNavigator: DefaultScreenNavigator?): ActivityLifecycleTask?
}