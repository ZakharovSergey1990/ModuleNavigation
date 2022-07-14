package com.example.register_module

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.register(
    featureApi: RegisterPageApi,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}

//fun AppNavGraph.register(
//featureApi: RegisterPageApi,
//navController: NavHostController,
//modifier: Modifier = Modifier
//) {
//    featureApi.registerGraph(
//        navGraphBuilder = this,
//        navController = navController,
//        modifier = modifier
//    )
//}