package com.raywenderlich.android.agendaviewmodel

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.raywenderlich.android.agendaviewmodel.agendaList.AgendaListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AgendaListActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(AgendaListActivity::class.java)

    @Test
    fun test_backPressToAgendaListActivity() {
        onView(withId(R.id.activity_agenda_list_fabAddContact))
            .perform(click())

        onView(withId(R.id.activity_contact_form))
            .check(matches(isDisplayed()))

        pressBack()

        onView(withId(R.id.activity_agenda_list))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_navContactFormActivity() {
        onView(withId(R.id.activity_agenda_list_fabAddContact)).perform(click())

        onView(withId(R.id.activity_contact_form)).check(matches(isDisplayed()))
    }
}