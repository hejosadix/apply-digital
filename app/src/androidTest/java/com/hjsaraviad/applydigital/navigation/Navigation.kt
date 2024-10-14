package com.hjsaraviad.applydigital.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainNavigation(navController = navController)
        }
    }

    @Test
    fun navigate_comments_screen() {
        composeTestRule.waitUntil {
            composeTestRule.onNodeWithTag("comments").isDisplayed()
        }
        composeTestRule.onNodeWithTag("comments").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun navigate_web_view_screen() {
        composeTestRule.waitUntilAtLeastOneExists(hasTestTag("swipeItemWithActions"))
        composeTestRule.onNodeWithTag("comments").performScrollToIndex(1).performClick()
        composeTestRule.waitUntilExactlyOneExists(hasTestTag("webview"))
        composeTestRule.onNodeWithTag("webview").assertIsDisplayed()
    }
}