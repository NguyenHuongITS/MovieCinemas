package com.example.nguyenhuongit.moviecinemas.View.Activity;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nguyenhuongit.moviecinemas.View.Fragment.AccountFragment;
import com.example.nguyenhuongit.moviecinemas.Adapter.ViewPagerAdapter;
import com.example.nguyenhuongit.moviecinemas.Data.Banner;
import com.example.nguyenhuongit.moviecinemas.View.Fragment.MoviesFragment;
import com.example.nguyenhuongit.moviecinemas.R;
import com.example.nguyenhuongit.moviecinemas.View.Fragment.TicketsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Layout
    public TabLayout tabLayout;
    public ViewPager viewPager;
    public ViewPagerAdapter viewPagerAdapter;
    public Context context;

    //fragment
    public AccountFragment accountFragment = new AccountFragment();
    public MoviesFragment moviesFragment = new MoviesFragment();
    public TicketsFragment ticketsFragment = new TicketsFragment();

    //khai báo đối tượng banner
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<Banner> bannerArrayList;
    public View view;

    //khai báo list image banner
    private int[] myImageList = new int[]{R.drawable.image_banner_1, R.drawable.image_banner_2,
            R.drawable.image_banner_3,R.drawable.image_banner_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ẩn action bar
        ActionBarHide();
        //ánh xạ
        Mapping();
        //thêm fragment
        AddFragment();

    }

    private void ActionBarHide() {
        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();
    }

    private void Mapping() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_paper_main);
    }

    private void AddFragment() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //add fragment adapter
        viewPagerAdapter.AddFragment(moviesFragment, "Movies");
        viewPagerAdapter.AddFragment(ticketsFragment, "My Tickets");
        viewPagerAdapter.AddFragment(accountFragment, "Account");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //set icon fragment
        tabLayout.getTabAt(0).setIcon(R.drawable.icon_movies);
        tabLayout.getTabAt(1).setIcon(R.drawable.icon_ticket);
        tabLayout.getTabAt(2).setIcon(R.drawable.icon_account);

        //set color icon
        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.tablayoutselect),PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.tablayout),PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.tablayout),PorterDuff.Mode.SRC_IN);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tablayoutselect),PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tablayout),PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
