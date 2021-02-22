package com.cos.myapplication5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class UserFragment extends Fragment {

    private UserFragmentPagerAdapter userFragmentPagerAdapter;
    private ViewPager vpContainer;
    private TabLayout tabs;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);


        vpContainer = view.findViewById(R.id.vp_container);
        tabs = view.findViewById(R.id.tabs);

        userFragmentPagerAdapter = new UserFragmentPagerAdapter(getChildFragmentManager(),1);

        userFragmentPagerAdapter.addFragment(new Frag1());
        userFragmentPagerAdapter.addFragment(new Frag2());

        vpContainer.setAdapter(userFragmentPagerAdapter);

        tabs.setupWithViewPager(vpContainer);

        tabs.getTabAt(0).setIcon(R.drawable.ic_apps);
        tabs.getTabAt(1).setIcon(R.drawable.ic_glyph_regular_id_card);



        return view;
    }
}
