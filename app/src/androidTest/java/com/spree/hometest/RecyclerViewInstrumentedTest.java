package com.spree.hometest;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.spree.hometest.views.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class RecyclerViewInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void init() {
        System.out.println("init");
    }

    @Test
    public void mainRecyclerView_swipeTest() throws Exception{
        Thread.sleep(3000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(swipeUp());

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(26, swipeUp()));

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(ViewActions.swipeUp());

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(ViewActions.swipeDown());

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(25, click()));

        Thread.sleep(1000);

        onView(withId(R.id.txt_back)).perform(ViewActions.pressBack());

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(ViewActions.swipeDown());

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(15, click()));

        Thread.sleep(1000);

        onView(withId(R.id.txt_back)).perform(ViewActions.pressBack());

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(ViewActions.swipeUp());

        Thread.sleep(3000);
    }
}
