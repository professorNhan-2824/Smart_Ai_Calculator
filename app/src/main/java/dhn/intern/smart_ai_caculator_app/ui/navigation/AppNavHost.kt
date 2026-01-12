package dhn.intern.smart_ai_caculator_app.ui.navigation

import android.graphics.pdf.content.PdfPageGotoLinkContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.savedstate.SavedStateRegistryController
import dhn.intern.smart_ai_caculator_app.enum.HistorySource
import dhn.intern.smart_ai_caculator_app.ui.screen.BasicCaculatorScreen
import dhn.intern.smart_ai_caculator_app.ui.screen.HistoryScreen
import dhn.intern.smart_ai_caculator_app.ui.screen.HomeScreen
import dhn.intern.smart_ai_caculator_app.ui.screen.LanguageScreen
import dhn.intern.smart_ai_caculator_app.ui.screen.SettingScreen
import dhn.intern.smart_ai_caculator_app.ui.screen.SplashScreen
import dhn.intern.smart_ai_caculator_app.ui.screen.ai_caculator_screen
import dhn.intern.smart_ai_caculator_app.viewmodel.AppViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavScreen.PlashScreen.route,
    appViewModel: AppViewModel = koinViewModel()
) {
    val isFirstLaunch by appViewModel.isFirstLaunch.collectAsState()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(NavScreen.PlashScreen.route) {
            SplashScreen()
            LaunchedEffect(isFirstLaunch) {
                delay(1200)

                val target = if (isFirstLaunch) {
                    NavScreen.SelectLanguage.route
                } else {
                    NavScreen.HomeScreen.route
                }

                navController.navigate(target) {
                    popUpTo(NavScreen.PlashScreen.route) {
                        inclusive = true
                    }
                }
            }
        }


        composable(NavScreen.SelectLanguage.route){
            LanguageScreen(
                navController = navController
            )
        }

        composable(NavScreen.HomeScreen.route){
            HomeScreen(
                navController = navController
            )
        }

        composable(NavScreen.SettingScreen.route){
            SettingScreen(
                navController = navController
            )
        }

        composable(NavScreen.BasicCaculatorScreen.route){
            BasicCaculatorScreen(
                navController = navController
            )
        }
        composable(NavScreen.AiCaculatorScreen.route){
            ai_caculator_screen(
                navController = navController
            )
        }


        composable(
            route = NavScreen.HistoryScreen.route,
            arguments = listOf(
                navArgument("source") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val source = backStackEntry.arguments
                ?.getString("source")
                ?.let { HistorySource.valueOf(it) }
                ?: HistorySource.CALCULATOR

            HistoryScreen(
                navController = navController,
                source = source
            )
        }



    }
}