package com.example.junit


import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    fun setUp() {
        mainActivity = MainActivity()
    }

    @Test
    fun `calculateLength should return empty string when name is blank`() {
        val result = mainActivity.calculateLengthunit("  ")
        assertEquals("Password is required field", result)
    }

    @Test
    fun `calculateLength should return name length when name is not blank`() {
        val result = mainActivity.calculateLengthunit("hadith")
        assertEquals("Length of the Name should be greater than 6", result)
    }
}
