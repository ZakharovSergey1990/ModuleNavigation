package com.example.second_module

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.register_module.RegisterPageApi

interface SecondPageApi: RegisterPageApi {
    fun secondPageRoute(): String
}

interface SecondPageSubgraphApi {
    fun goToTextPage(txt: String)
}

class SecondPageApiImpl : SecondPageApi, SecondPageSubgraphApi {

    private val baseRoute = "second_page"

    override fun secondPageRoute() = baseRoute

    override fun goToTextPage(text: String) {
        navController.navigate("second_page/text_page/$text")
    }

    var navController: NavController?  = null

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder, navController: NavHostController, modifier: Modifier
    ) {
        this.navController = navController

        navGraphBuilder.composable(baseRoute) {
            SecondPage(this)
        }

        navGraphBuilder.composable("$baseRoute/text_page/{text}") {
            TextPage(text = it.arguments?.getString("text") ?: "")
        }
    }

}
