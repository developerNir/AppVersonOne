package com.example.mychatgpt;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;


public class homeFragment extends Fragment {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TabLayout tabLayout;
    FrameLayout frameLayoutOne;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // introducing fragment element ---------------------------------
        tabLayout = view.findViewById(R.id.tabLayout);
        frameLayoutOne = view.findViewById(R.id.frameLayoutOne);

        // default add home One fragment==================================
        fragmentReplace(new homeOneFragment());

        // add tab select listener ============================================
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPosition = tab.getPosition();

                if (tabPosition == 0){
                    Toast.makeText(getContext(), "home", Toast.LENGTH_SHORT).show();
                    fragmentReplace(new homeOneFragment());
                } else if (tabPosition == 1) {
                    fragmentReplace(new serviceFragment());
                    Toast.makeText(getContext(), "service", Toast.LENGTH_SHORT).show();
                } else if (tabPosition == 2) {
                    fragmentReplace(new shopingFragment());
                    Toast.makeText(getContext(), "notification", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // end tab select listener =======================================






        return view;




    }

    // fragment layout replace ============================================
    private void fragmentReplace(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutOne, fragment);
        fragmentTransaction.commit();
    }

}