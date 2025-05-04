package com.loc.newsapp.presentation.navgraph

sealed class Route(
    val route:String
){
    data object OnBoardingScreen:Route(route = "onBoardingScreen")
    data object HomeScreen:Route(route = "homeScreen")
    data object SearchScreen:Route(route = "searchScreen")
    data object BookMarkScreen:Route(route = "bookMarkScreen")
    data object DetailsScreen:Route(route = "detailsScreen")
    data object AppStartingNavigation:Route(route = "AppStartingNavigation")
    data object NewsNavigation:Route(route = "newsNavigation")
    data object NewsNavigatorScreen:Route(route = "newsNavigatorScreen")
}