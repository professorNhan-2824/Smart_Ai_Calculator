package dhn.intern.smart_ai_caculator_app.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dhn.intern.smart_ai_caculator_app.data.language.LocaleManager
import dhn.intern.smart_ai_caculator_app.repository.LanguageRepository
import dhn.intern.smart_ai_caculator_app.repository.ThemeRepository
import dhn.intern.smart_ai_caculator_app.util.dataStore
import dhn.intern.smart_ai_caculator_app.viewmodel.LanguageViewModel
import dhn.intern.smart_ai_caculator_app.viewmodel.ThemeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ThemesModule = module {
    single<DataStore<Preferences>> {
        androidContext().dataStore
    }

    // Locale
    single { LocaleManager() }


    // Repository
    single { ThemeRepository(get()) }

    // ViewModel
    viewModel { ThemeViewModel(get()) }
}