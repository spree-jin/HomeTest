package com.spree.hometest;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.spree.hometest.views.DetailActivity;
import com.spree.hometest.views.MainActivity;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@FixMethodOrder
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ItemClickInstrumentedTest {

    @Before
    public void init() {
        System.out.println("init");
    }

    @Test
    public void mainRecyclerView_itemClickTest() throws Exception{

        Thread.sleep(3000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(25, click()));

        Thread.sleep(1000);

        onView(withId(R.id.txt_back)).perform(ViewActions.pressBack());

        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.mainRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(15, click()));

        Thread.sleep(1000);

        onView(withId(R.id.txt_back)).perform(ViewActions.pressBack());

        Thread.sleep(1000);

        onView(withId(R.id.txt_back)).perform(ViewActions.pressBack());
    }
}
