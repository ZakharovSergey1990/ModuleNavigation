package com.example.modulenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.first_module.FirstPageApi
import com.example.first_module.FirstPageApiImpl
import com.example.modulenavigation.ui.theme.ModuleNavigationTheme
import com.example.second_module.SecondPage
import com.example.second_module.SecondPageApi
import com.example.second_module.SecondPageApiImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModuleNavigationTheme {
                val navController = rememberNavController()

                val firstPageApi: FirstPageApi = FirstPageApiImpl()
                val secondPageApi: SecondPageApi = SecondPageApiImpl()

                val navActions = NavActions(
                    navController, firstPageApi.firstPageRoute(), secondPageApi.secondPageRoute()
                )


                Scaffold(bottomBar = {
                    BottomMenu(
                        controller = navController,
                        navActions = navActions,
                        firstPageRoute = firstPageApi.firstPageRoute(),
                        secondPageRoute = secondPageApi.secondPageRoute()
                    )
                }) {
                    AppNavGraph(
                        navController = navController,
                        startDestination = firstPageApi.firstPageRoute(),
                        pages = listOf(firstPageApi, secondPageApi)
                    )
                }
            }
        }
    }
}


class NavActions(
    val navController: NavController, firstPageRoute: String, secondPageRoute: String
) {

    val goBack: () -> Unit = {
        navController.popBackStack()
    }

    val goToFirstPage: () -> Unit = {
        navController.navigate(firstPageRoute)
    }

    val goToSecondPage: () -> Unit = {
        navController.navigate(secondPageRoute)
    }

    val goToThirdPage: () -> Unit = {
        navController.navigate("/third")
    }
}


@Composable
fun BottomMenu(
    controller: NavController,
    navActions: NavActions,
    firstPageRoute: String,
    secondPageRoute: String
) {

    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val selectedColor = Color.White
    val unselectedColor = Color.Gray
    if (currentRoute in listOf(firstPageRoute, secondPageRoute, "/third")) {
        BottomNavigation(elevation = 8.dp) {
            BottomNavigationItem(
                icon = { Text(text = "first", maxLines = 1) },
                label = { },
                selected = currentRoute == firstPageRoute,
                onClick = { navActions.goToFirstPage() },
                alwaysShowLabel = false,
                selectedContentColor = selectedColor,
                unselectedContentColor = unselectedColor,
            )

            BottomNavigationItem(
                icon = { Text(text = "second", maxLines = 1) },
                label = { },
                selected = currentRoute == secondPageRoute,
                onClick = { navActions.goToSecondPage() },
                alwaysShowLabel = false,
                selectedContentColor = selectedColor,
                unselectedContentColor = unselectedColor,
            )

            BottomNavigationItem(
                icon = { Text(text = "third", maxLines = 1) },
                label = { },
                selected = currentRoute == "/third",
                onClick = { navActions.goToThirdPage() },
                alwaysShowLabel = false,
                selectedContentColor = selectedColor,
                unselectedContentColor = unselectedColor,
            )
        }
    }
}

@Composable
fun ThirdPage() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Third")
    }
}



