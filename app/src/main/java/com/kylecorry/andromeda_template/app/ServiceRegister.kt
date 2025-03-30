package com.kylecorry.andromeda_template.app

import android.content.Context
import com.kylecorry.andromeda.core.cache.AppServiceRegistry
import com.kylecorry.andromeda_template.infrastructure.persistence.AppDatabase
import com.kylecorry.andromeda_template.ui.FormatService

object ServiceRegister {
    fun setup(context: Context) {
        val appContext = context.applicationContext

        // Shared services
        AppServiceRegistry.register(FormatService.getInstance(appContext))
        AppServiceRegistry.register(AppDatabase.getInstance(appContext))
    }
}