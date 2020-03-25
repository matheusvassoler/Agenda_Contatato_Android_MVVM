package com.raywenderlich.android.agendaviewmodel

import android.app.Activity
import android.app.Instrumentation
import android.util.Log
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.raywenderlich.android.agendaviewmodel.agendaList.AgendaListActivity
import com.raywenderlich.android.agendaviewmodel.agendaList.AgendaListAdapter
import com.raywenderlich.android.agendaviewmodel.contactForm.ContactFormActivity
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactFormActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(ContactFormActivity::class.java)

    @Test
    fun verifyIfEditTextNameIsVisible() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.checkViewIsVisible(R.id.activity_contact_form_editName)
    }

    @Test
    fun verifyIfEditTextPhoneIsVisible() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.checkViewIsVisible(R.id.activity_contact_form_editPhone)
    }

    @Test
    fun verifiyIfEditTextEmailIsVisible() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.checkViewIsVisible(R.id.activity_contact_form_editEmail)
    }

    @Test
    fun verifiyIfAddContactButtonIsVisible() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.checkViewIsVisible(R.id.activity_contact_form_btnAddContact)
    }

    @Test
    fun verifyEditTextNameIsFilled() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.verifyEditIsFilledCorrectly(R.id.activity_contact_form_editName, "Matheus")
    }

    @Test
    fun verifyEditTextPhoneIsFilled() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.verifyEditIsFilledCorrectly(R.id.activity_contact_form_editPhone, "11111")
    }

    @Test
    fun verifyEditTextEmailIsFilled() {
        val agendaListRobot = AgendaListRobot()

        agendaListRobot.verifyEditIsFilledCorrectly(R.id.activity_contact_form_editEmail, "matheus@gmail.com")
    }

}