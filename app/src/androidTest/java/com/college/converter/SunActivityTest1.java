package com.college.converter;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SunActivityTest1 {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void sunActivityTest1() {
        try {
            Thread.sleep(5929);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.first_id), withContentDescription("Sunrise/Sunset"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainToolbar),
                                        1),
                                1),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        try {
            Thread.sleep(5929);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction button = onView(
                allOf(withId(R.id.button_search), withText("SEARCH"),
                        withParent(allOf(withId(R.id.linear_layout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        try {
            Thread.sleep(5929);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction button2 = onView(
                allOf(withId(R.id.button_save), withText("SAVE"),
                        withParent(allOf(withId(R.id.linear_layout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        try {
            Thread.sleep(5929);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction button3 = onView(
                allOf(withId(R.id.button_read), withText("HISTORY"),
                        withParent(allOf(withId(R.id.linear_layout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        try {
            Thread.sleep(5929);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction editText = onView(
                allOf(withId(R.id.editText_latitude), withText("0"),
                        withParent(allOf(withId(R.id.linear_layout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText.check(matches(withText("0")));

        try {
            Thread.sleep(5929);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.third_id), withContentDescription("Dictionary"),
                        withParent(withParent(withId(R.id.bottom_navigation))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        try {
            Thread.sleep(5929);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction frameLayout2 = onView(
                allOf(withId(R.id.third_id), withContentDescription("Dictionary"),
                        withParent(withParent(withId(R.id.bottom_navigation))),
                        isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}