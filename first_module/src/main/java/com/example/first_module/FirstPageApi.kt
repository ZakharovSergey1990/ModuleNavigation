package com.example.first_module

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.register_module.RegisterPageApi

interface FirstPageApi: RegisterPageApi {
    fun firstPageRoute(): String
}

class FirstPageApiImpl(
    navGraphBuilder: NavGraphBuilder,
    navController: NavHostController,
    modifier: Modifier
) : FirstPageApi {

    init {
        navGraphBuilder.composable(baseRoute) {
            FirstPage()
        }
    }

    private val baseRoute = "first_page"

    override fun firstPageRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            FirstPage()
        }
    }
}