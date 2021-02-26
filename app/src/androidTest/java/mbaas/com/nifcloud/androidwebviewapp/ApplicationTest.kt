package mbaas.com.nifcloud.androidwebviewapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.web.assertion.WebViewAssertions
import androidx.test.espresso.web.model.Atoms
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import mbaas.com.nifcloud.androidwebviewapp.Utils.waitFor
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ApplicationTest {
    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun init() {
        // Specify a valid string.
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("mbaas.com.nifcloud.androidwebviewapp", appContext.packageName)
    }

    @Test
    fun webViewTest() {
        onView(withText("WebViewApp")).check(matches(isDisplayed()))
        onView(withText("▼ Tap here ▼")).check(matches(isDisplayed()))
        onView(withId(R.id.btnInfo)).check(matches(isDisplayed())).perform(click())
        onView(isRoot()).perform(waitFor(1000))
        onWebView(withId(R.id.webviewInfo)).forceJavascriptEnabled()
        onWebView(withId(R.id.webviewInfo)).check(WebViewAssertions.webMatches(Atoms.getCurrentUrl(), Matchers.containsString("index.html")))
        onView(withId(R.id.btnBack)).check(matches(isDisplayed())).perform(click())
    }
}