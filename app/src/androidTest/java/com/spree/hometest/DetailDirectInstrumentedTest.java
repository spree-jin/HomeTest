package com.spree.hometest;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.spree.hometest.models.Attributes;
import com.spree.hometest.models.Data;
import com.spree.hometest.views.DetailActivity;
import com.spree.hometest.views.MainActivity;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.parceler.Parcels;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
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
public class DetailDirectInstrumentedTest {

    @Rule
    public ActivityTestRule<DetailActivity> detailActivityRule =
            new ActivityTestRule<>(DetailActivity.class, true, false);

    @Before
    public void init() {
        System.out.println("init");
    }

    @Test
    public void intentDetail() throws Exception{
        Thread.sleep(3000);

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String strReview = appContext.getString(R.string.txt_review);

        Attributes attributes = new Attributes();
        attributes.setName("TEST");
        attributes.setPrice("1234");
        attributes.setReviewsCount(10);
        Data data = new Data();
        data.setAttributes(attributes);

        Intent intent = new Intent();
        intent.putExtra("Product", Parcels.wrap(data));
        detailActivityRule.launchActivity(intent);

        Thread.sleep(1000);

        onView(withId(R.id.txt_product)).check(matches(withText(data.getAttributes().getName())));
        onView(withId(R.id.txt_review)).check(matches(withText(data.getAttributes().getReviewsCount() + " " + strReview)));
        onView(withId(R.id.txt_price)).check(matches(withText(data.getAttributes().getPrice())));

        Thread.sleep(5000);
    }
}
