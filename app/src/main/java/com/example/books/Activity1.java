package com.example.books;

import static com.example.books.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class Activity1 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  DbHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_1);

        tabLayout = (TabLayout) findViewById(id.tablay);
        viewPager = (ViewPager) findViewById(id.viewpag);
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addfragment(new frag1(), "Books List Locally");
        adapter.addfragment(new frag2(), "Book List Remotely");

        viewPager.setAdapter(adapter);
    }

}
