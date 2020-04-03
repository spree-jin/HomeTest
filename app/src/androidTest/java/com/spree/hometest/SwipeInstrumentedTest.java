package com.spree.hometest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.intent.IntentStubberRegistry;


import com.spree.hometest.models.Attributes;
import com.spree.hometest.models.Data;
import com.spree.hometest.viewholder.MainRecyclerViewHolder;
import com.spree.hometest.views.DetailActivity;
import com.spree.hometest.views.MainActivity;

import junit.framework.TestCase;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.parceler.Parcels;

import java.util.concurrent.TimeUnit;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@FixMethodOrder
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SwipeInstrumentedTest {

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

        Thread.sleep(500);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(ViewActions.swipeDown());

        Thread.sleep(3000);
    }
}
