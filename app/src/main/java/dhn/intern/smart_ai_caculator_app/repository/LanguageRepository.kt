package dhn.intern.smart_ai_caculator_app.repository

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import dhn.intern.smart_ai_caculator_app.data.language.LanguagePreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class LanguageRepository(
    private val dataStore: DataStore<Preferences>
) {

    val selectedLanguageFlow: Flow<String> =
        dataStore.data.map { prefs ->
            prefs[LanguagePreferences.LANGUAGE_CODE] ?: "en"
        }

    suspend fun saveLanguage(code: String) {
        dataStore.edit { prefs ->
            prefs[LanguagePreferences.LANGUAGE_CODE] = code
        }
    }
}
