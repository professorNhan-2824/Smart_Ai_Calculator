package dhn.intern.smart_ai_caculator_app

import android.app.Application
import dhn.intern.smart_ai_caculator_app.di.appModule
import dhn.intern.smart_ai_caculator_app.ui.navigation.AppNavHost
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SmartCalculatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SmartCalculatorApp)
            modules(appModule)
        }
    }
}
