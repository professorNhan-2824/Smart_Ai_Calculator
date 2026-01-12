package dhn.intern.smart_ai_caculator_app.di

import androidx.room.Room
import dhn.intern.smart_ai_caculator_app.data.CalculatorDatabase
import dhn.intern.smart_ai_caculator_app.repository.CalculatorHistoryRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            CalculatorDatabase::class.java,
            "calculator_db"
        ).build()
    }

    single { get<CalculatorDatabase>().historyDao() }

    single { CalculatorHistoryRepository(get()) }
}
