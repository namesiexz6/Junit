package com.example.junit

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun calculateLength_validInput_shouldDisplayLength() {
        val name = "John"
        onView(withId(R.id.etName)).perform(typeText(name), closeSoftKeyboard())
        onView(withId(R.id.btnCalculate)).perform(click())
        onView(withId(R.id.tvLength)).check(matches(withText("Your name length is: ${name.length}")))
    }

    @Test
    fun calculateLength_emptyInput_shouldNotDisplayLength() {
        onView(withId(R.id.btnCalculate)).perform(click())
        onView(withId(R.id.tvLength)).check(matches(withText("")))
    }
}
