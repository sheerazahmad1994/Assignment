package com.example.kids.core.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.android.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class LoginActivityTest{
    @get: Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)


    @Test
    fun test_IsEmailBoxInView(){
        onView(withId(R.id.edtLoginEmail)).check(matches(isDisplayed()))
    }
}