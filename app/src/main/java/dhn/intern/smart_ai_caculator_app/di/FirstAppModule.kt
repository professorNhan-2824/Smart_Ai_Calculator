package dhn.intern.smart_ai_caculator_app.di

import dhn.intern.smart_ai_caculator_app.repository.AppRepository
import dhn.intern.smart_ai_caculator_app.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val FirstAppModule = module {
    single { AppRepository(get()) }
    viewModel { AppViewModel(get()) }
}
