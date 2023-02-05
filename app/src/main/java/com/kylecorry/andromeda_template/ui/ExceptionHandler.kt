package com.kylecorry.andromeda_template.ui

import android.util.Log
import com.kylecorry.andromeda.exceptions.*
import com.kylecorry.andromeda_template.R
import com.kylecorry.andromeda_template.infrastructure.errors.FragmentDetailsBugReportGenerator

object ExceptionHandler {

    fun initialize(activity: MainActivity) {
        val handler = EmailExceptionHandler(
            activity,
            AggregateBugReportGenerator(
                listOf(
                    AppDetailsBugReportGenerator(activity.getString(R.string.app_name)),
                    AndroidDetailsBugReportGenerator(),
                    DeviceDetailsBugReportGenerator(),
                    FragmentDetailsBugReportGenerator(),
                    StackTraceBugReportGenerator()
                )
            )
        ) { context, log ->
            Log.e(context.getString(R.string.app_name), log)
            BugReportEmailMessage(
                context.getString(R.string.error_occurred),
                context.getString(R.string.error_occurred_message),
                context.getString(R.string.email_developer),
                context.getString(android.R.string.cancel),
                context.getString(R.string.email),
                "Error in ${context.getString(R.string.app_name)}"
            )
        }
        handler.bind()
    }

}