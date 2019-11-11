package com.bluesky.toa.ui.chat.adapters;

import android.content.Context;

import com.bluesky.toa.R;
import com.bluesky.toa.ui.chat.fragments.ContactsFragment;
import com.bluesky.toa.ui.chat.fragments.ConversationsFragment;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.contacts, R.string.conversations};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ContactsFragment contactsTab = new ContactsFragment();
                return contactsTab;
            case 1:
                ConversationsFragment conversationsTab = new ConversationsFragment();
                return conversationsTab;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}