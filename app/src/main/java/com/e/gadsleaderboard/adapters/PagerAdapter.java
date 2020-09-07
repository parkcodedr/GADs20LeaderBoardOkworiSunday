package com.e.gadsleaderboard.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.e.gadsleaderboard.fragments.LearningLeader;
import com.e.gadsleaderboard.fragments.SkillIQLeader;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        position = position+1;
        if(position==1){
            LearningLeader leader = new LearningLeader();
            return leader;
        }else{
            SkillIQLeader leader = new SkillIQLeader();
            return leader;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position+1;
        if(position ==1){
            return "LEARNING LEADER";
        }else{
            return "SKILLIQ LEADER";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
