package com.loc.newsapp.presentation.onboarding

sealed class OnBoardingEvent {
    data object SavaAppEntry : OnBoardingEvent()
}