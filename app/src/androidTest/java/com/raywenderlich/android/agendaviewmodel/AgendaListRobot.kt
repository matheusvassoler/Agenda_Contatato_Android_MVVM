package com.raywenderlich.android.agendaviewmodel

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import junit.framework.Assert.assertTrue

class AgendaListRobot: ScreenRobot<AgendaListRobot>() {

    fun verifyEditIsFilledCorrectly(viewId: Int, text: String): AgendaListRobot {
        return enterTextIntoView(viewId, text).checkViewHasText(viewId, text)
    }
}