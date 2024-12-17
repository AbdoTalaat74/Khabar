package com.loc.newsapp.presentation.news_navigator

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.bookmark.BookmarkScreen
import com.loc.newsapp.presentation.bookmark.BookmarkViewModel
import com.loc.newsapp.presentation.details.DetailsEvent
import com.loc.newsapp.presentation.details.DetailsScreen
import com.loc.newsapp.presentation.details.DetailsViewModel
import com.loc.newsapp.presentation.home.HomeScreen
import com.loc.newsapp.presentation.home.HomeViewModel
import com.loc.newsapp.presentation.navgraph.Route
import com.loc.newsapp.presentation.news_navigator.components.BottomNavigationItem
import com.loc.newsapp.presentation.news_navigator.components.NewsBottomNavigation
import com.loc.newsapp.presentation.search.SearchScreen
import com.loc.newsapp.presentation.search.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsNavigator() {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(title = "Home", icon = R.drawable.ic_home, route = "home"),
            BottomNavigationItem(title = "Search", icon = R.drawable.ic_search, route = "search"),
            BottomNavigationItem(
                title = "bookmark",
                icon = R.drawable.ic_bookmark,
                route = "bookmark"
            ),
        )
    }


    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem = remember(key1 = backStackState) {
        when (backStackState?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.SearchScreen.route -> 1
            Route.BookMarkScreen.route -> 2
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route in listOf(
            Route.HomeScreen.route,
            Route.SearchScreen.route,
            Route.BookMarkScreen.route
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        bottomBar = {
            if (isBottomBarVisible) {
                NewsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> {
                                navigateToTap(
                                    navController = navController,
                                    route = Route.HomeScreen.route
                                )
                            }

                            1 -> {
                                navigateToTap(
                                    navController = navController,
                                    route = Route.SearchScreen.route
                                )
                            }

                            2 -> {
                                navigateToTap(
                                    navController = navController,
                                    route = Route.BookMarkScreen.route
                                )
                            }
                        }
                    }
                )
            }

        }
    ) { paddingValues ->
        val bottomPadding = paddingValues.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    articles = articles,
                    navigateToSearchScreen = {
                        navigateToTap(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )
                    },
                    navigateToDetailsScreen = {
                        navigateToDetails(navController = navController, article = it)
                    }
                )
            }

            composable(route = Route.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                SearchScreen(
                    state = state,
                    event = viewModel::onEvent,
                    navigateToDetails = {
                        navigateToDetails(navController = navController, article = it)
                    }
                )
            }

            composable(route = Route.DetailsScreen.route) {
                val viewModel: DetailsViewModel = hiltViewModel()
                if (viewModel.sideEffect != null){
                    Toast.makeText(LocalContext.current,viewModel.sideEffect,Toast.LENGTH_LONG).show()
                    viewModel.onEvent(DetailsEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
                    ?.let { article ->
                        viewModel.checkIsSaved(article)
                        DetailsScreen(
                            article = article,
                            event = viewModel::onEvent,
                            navigateUp = { navController.navigateUp() },
                            isArticleSaved = viewModel.isArticleSaved.value
                        )
                    }

            }

            composable(route = Route.BookMarkScreen.route) {
                val viewModel: BookmarkViewModel = hiltViewModel()
                val state = viewModel.state.value

                BookmarkScreen(
                    state = state,
                    navigateToDetailsScreen = { article ->
                        navigateToDetails(
                            navController = navController,
                            article = article
                        )
                    })

            }

        }
    }
}

private fun navigateToTap(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let {
            popUpTo(it) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetails(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(Route.DetailsScreen.route)
}