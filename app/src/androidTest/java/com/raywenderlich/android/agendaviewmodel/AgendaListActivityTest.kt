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
    fun verifyIfAgendaListIsVisible() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.checkViewIsVisible(R.id.activity_agenda_list)
    }

    @Test
    fun verifyIfFabIsVisible() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.checkViewIsVisible(R.id.activity_agenda_list_fabAddContact)
    }

    @Test
    fun verifiyFabClick() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.clickOnView(R.id.activity_agenda_list_fabAddContact)
    }

    @Test
    fun verifyNextScreenIsVisible() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.clickOnView(R.id.activity_agenda_list_fabAddContact)
        agendaListRobot.checkViewIsVisible(R.id.activity_contact_form)
    }
}