package tech.shalecode.eyesonfootball

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import tech.shalecode.eyesonfootball.Views.Matchs.MatchActivity
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import org.junit.Test
import tech.shalecode.eyesonfootball.R.id.*

@RunWith(AndroidJUnit4::class)
class MatchActivityTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(MatchActivity::class.java)

//    @Test
//    fun testRecyclerViewBehavior() {
//        Thread.sleep(1000)
//        onView(withId(listMatches))
//            .check(matches(isDisplayed()))
//        Thread.sleep(1000)
//        onView(withId(listMatches)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
//        Thread.sleep(1000)
//        onView(withId(listMatches))
//                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
//    }

    @Test
    fun testAppBehavior() {
        Thread.sleep(1000)
        onView(withId(leagueSpinner)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(leagueSpinner)).perform(click())
        Thread.sleep(1000)
        onView(withText("Italian Serie A")).perform(click())
    }

    @Test
    fun testNextMatch() {
        Thread.sleep(1000)
        onView(withId(next_match_nav)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(next_match_nav)).perform(click())
        Thread.sleep(1000)
        onView(withId(listMatches)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(listMatches)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
        Thread.sleep(1000)
        onView(withId(listMatches)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        Thread.sleep(1000)
        Espresso.pressBack()
    }

    @Test
    fun testLastMatches() {
        Thread.sleep(1000)
        onView(withId(last_match_nav)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(last_match_nav)).perform(click())
        Thread.sleep(1000)
        onView(withId(listMatches)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(listMatches)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
        Thread.sleep(1000)
        onView(withId(listMatches)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        Thread.sleep(1000)
        Espresso.pressBack()
    }
}