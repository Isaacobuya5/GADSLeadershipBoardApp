package com.example.gadsleadershipboardapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {

    int numTabs;

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity, int numItems) {
        super(fragmentActivity);
        this.numTabs = numItems;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new LearningLeadersFragment().newInstance();
            case 1:
                return new SkillLeadersFragment().newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return numTabs;
    }
}
