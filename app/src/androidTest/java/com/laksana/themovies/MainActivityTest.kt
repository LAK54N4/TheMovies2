package com.laksana.themovies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.laksana.themovies.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun getMovies() {
        onView(withText(R.string.tab_text_1)).perform(ViewActions.click())
        onView(withId(R.id.recyclerView_movies))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))

        onView(withText(R.string.tab_text_2)).perform(ViewActions.click())
        onView(withId(R.id.recyclerView_movies))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
    }

    @Test
    fun detailMovies(){
        onView(withId(R.id.recyclerView_movies))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
        onView(withId(R.id.recyclerView_movies))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, ViewActions.click()))

        onView(withId(R.id.img_detailPoster))
                .check(matches(isDisplayed()))
        onView(withId(R.id.img_background))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_releaseDateValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_languageValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_overviewValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_budgetValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtimeValue))
                .check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun detailTvShow(){
        onView(withText(R.string.tab_text_2)).perform(ViewActions.click())
        onView(withId(R.id.recyclerView_movies))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
        onView(withId(R.id.recyclerView_movies))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, ViewActions.click()))
        onView(withId(R.id.img_detailPoster))
                .check(matches(isDisplayed()))
        onView(withId(R.id.img_background))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_releaseDateValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_languageValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_overviewValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_episodesValue))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_sessionValue))
                .check(matches(isDisplayed()))

        pressBack()
    }

}