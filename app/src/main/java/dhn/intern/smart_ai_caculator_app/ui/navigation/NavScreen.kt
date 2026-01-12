package dhn.intern.smart_ai_caculator_app.ui.navigation

import dhn.intern.smart_ai_caculator_app.enum.HistorySource

sealed class NavScreen {

    object PlashScreen : NavScreen() {
        const val route = "plash_screen"
    }

    object SelectLanguage : NavScreen() {
        const val route = "selectlanguage_screen"
    }

    object HomeScreen : NavScreen() {
        const val route = "home_screen"
    }

    object SettingScreen : NavScreen() {
        const val route = "setting_screen"
    }

    object BasicCaculatorScreen : NavScreen() {
        const val route = "basic_caculator"
    }

    object AiCaculatorScreen : NavScreen() {
        const val route = "ai_caculator"
    }

    object HistoryScreen {
        const val route = "history_screen/{source}"

        fun createRoute(source: HistorySource): String {
            return "history_screen/${source.name}"
        }
    }
}