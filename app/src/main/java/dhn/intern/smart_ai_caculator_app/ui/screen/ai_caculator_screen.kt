package dhn.intern.smart_ai_caculator_app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dhn.intern.smart_ai_caculator_app.R
import dhn.intern.smart_ai_caculator_app.ui.components.NavBar_basic

@Composable
fun ai_caculator_screen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            NavBar_basic(
                title = R.string.menu_ai_calculator,
                icon = R.drawable.history_time,
                navController = navController,
                onclick = {
                    //Navigation to AI Calculator Screen
                }
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

        }
    }
}