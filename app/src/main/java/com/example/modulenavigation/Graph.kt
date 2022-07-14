package com.example.modulenavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.first_module.FirstPageApi
import com.example.first_module.FirstPageApiImpl
import com.example.register_module.RegisterPageApi
import com.example.register_module.register
import com.example.second_module.SecondPageApi
import com.example.second_module.SecondPageApiImpl

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    pages: List<RegisterPageApi>
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("/third"){
            ThirdPage()
        }
        pages.forEach { registerPageApi ->
//            register(registerPageApi,
//            navController = navController,
//            modifier = modifier)
            registerPageApi.registerGraph(
                navGraphBuilder = this,
                navController = navController,
                modifier = modifier
            )

        }
    }
}