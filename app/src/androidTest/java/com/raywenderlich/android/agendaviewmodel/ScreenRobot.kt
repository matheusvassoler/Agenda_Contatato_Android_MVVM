package com.raywenderlich.android.agendaviewmodel

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

abstract class ScreenRobot<T> {

    fun checkViewIsVisible(viewId: Int): T {
        onView(withId(viewId)).check(matches(isDisplayed()))

        return this as T
    }

    fun clickOnView(viewId: Int): T {
        onView(withId(viewId)).perform(click())

        return this as T
    }

    fun enterTextIntoView(viewId: Int, text: String): T {
        onView(withId(viewId)).perform(typeText(text))

        return this as T
    }

    fun replaceTextIntoView(viewId: Int, text: String): T {
        onView(withId(viewId)).perform(replaceText(text))

        return this as T
    }

    fun checkViewHasText(viewId: Int, text: String): T {
        onView(withId(viewId)).check(matches(withText(text)))

        return this as T
    }
}