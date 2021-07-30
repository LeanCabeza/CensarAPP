package com.example.censar

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.censar.view.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)

class InstrumentedTest {

    @get:Rule
    var activityRule:ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun vistaAlta() {
        Espresso.onView(
            ViewMatchers.withId(R.id.btn_alta))
            .perform(ViewActions.click())
        Espresso.onView(
            ViewMatchers.withId(R.id.btn_alta))
            .perform(ViewActions.click())

    }

    @Test
    fun vistaListar() {
        Espresso.onView(
            ViewMatchers.withId(R.id.btn_listar))
            .perform(ViewActions.click())
    }

    @Test
    fun testInformes() {
        Espresso.onView(
            ViewMatchers.withId(R.id.btn_informes))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.info_btn_asc))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.info_btn_pobresa))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.info_btn_desocupado))
            .perform(ViewActions.click())


    }
}

