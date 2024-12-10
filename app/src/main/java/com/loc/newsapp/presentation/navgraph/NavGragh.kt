package com.loc.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.loc.newsapp.presentation.bookmark.BookmarkScreen
import com.loc.newsapp.presentation.bookmark.BookmarkViewModel
import com.loc.newsapp.presentation.onboarding.OnBoardingScreen
import com.loc.newsapp.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination) {
        navigation(
            route = Route.AppStartingNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = onBoardingViewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewModel.state.value, navigate = {})
            }

        }
    }
}