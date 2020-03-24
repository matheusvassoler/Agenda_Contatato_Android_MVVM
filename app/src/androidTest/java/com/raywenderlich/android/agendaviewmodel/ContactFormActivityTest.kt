package com.raywenderlich.android.agendaviewmodel

import android.app.Activity
import android.app.Instrumentation
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.raywenderlich.android.agendaviewmodel.agendaList.AgendaListActivity
import com.raywenderlich.android.agendaviewmodel.agendaList.AgendaListAdapter
import com.raywenderlich.android.agendaviewmodel.contactForm.ContactFormActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactFormActivityTest {

    //@get: Rule
    //val activityRule = ActivityScenarioRule(ContactFormActivity::class.java)

    @Test
    fun test_insertNewContact() {
        var activityScenario = ActivityScenario.launch(AgendaListActivity::class.java)
        onView(withId(R.id.activity_agenda_list_fabAddContact)).perform(click())

        onView(withId(R.id.activity_contact_form_editName)).perform(typeText("Matheus"))
        onView(withId(R.id.activity_contact_form_editPhone)).perform(typeText("111111"))
        onView(withId(R.id.activity_contact_form_editEmail)).perform(typeText("matheus@gmail.com"))

        onView(withId(R.id.activity_contact_form_btnAddContact)).perform(click())

        onView(withId(R.id.activity_agenda_list)).check(matches(isDisplayed()))
        onView(withId(R.id.agenda_list)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectContactItemIsContactFormVisible() {
        var activityScenario = ActivityScenario.launch(AgendaListActivity::class.java)
        onView(withId(R.id.activity_agenda_list_fabAddContact)).perform(click())

        onView(withId(R.id.activity_contact_form_editName)).perform(typeText("Matheus"))
        onView(withId(R.id.activity_contact_form_editPhone)).perform(typeText("111111"))
        onView(withId(R.id.activity_contact_form_editEmail)).perform(typeText("matheus@gmail.com"))

        onView(withId(R.id.activity_contact_form_btnAddContact)).perform(click())

        onView(withId(R.id.agenda_list)).perform(actionOnItemAtPosition<AgendaListAdapter.ViewHolder>(0, click()))

        onView(withId(R.id.activity_contact_form)).check(matches(isDisplayed()))
    }

    @Test
    fun test_updateContact() {
        var activityScenario = ActivityScenario.launch(AgendaListActivity::class.java)
        onView(withId(R.id.activity_agenda_list_fabAddContact)).perform(click())

        onView(withId(R.id.activity_contact_form_editName)).perform(typeText("Matheus"))
        onView(withId(R.id.activity_contact_form_editPhone)).perform(typeText("111111"))
        onView(withId(R.id.activity_contact_form_editEmail)).perform(typeText("matheus@gmail.com"))

        onView(withId(R.id.activity_contact_form_btnAddContact)).perform(click())

        onView(withId(R.id.agenda_list)).perform(actionOnItemAtPosition<AgendaListAdapter.ViewHolder>(0, click()))

        onView(withId(R.id.activity_contact_form_editName)).perform(replaceText("Lucas"))

        onView(withId(R.id.activity_contact_form_btnAddContact)).perform(click())

        onView(withId(R.id.agenda_list)).perform(actionOnItemAtPosition<AgendaListAdapter.ViewHolder>(0, click()))

        onView(withId(R.id.activity_contact_form_editName)).check(matches(withText("Lucas")))

    }
}