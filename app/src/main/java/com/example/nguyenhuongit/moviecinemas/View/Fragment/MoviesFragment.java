package com.example.nguyenhuongit.moviecinemas.View.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenhuongit.moviecinemas.Adapter.BannerAdapter;
import com.example.nguyenhuongit.moviecinemas.Adapter.ComingSoonAdapter;
import com.example.nguyenhuongit.moviecinemas.Adapter.OpenThisWeekAdapter;
import com.example.nguyenhuongit.moviecinemas.Data.Banner;
import com.example.nguyenhuongit.moviecinemas.Data.ComingSoon;
import com.example.nguyenhuongit.moviecinemas.Data.OpenThisWeek;
import com.example.nguyenhuongit.moviecinemas.R;
import com.viewpagerindicator.LinePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MoviesFragment extends Fragment implements View.OnClickListener {
    //khai báo đối tượng cho banner
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<Banner> bannerArrayList;
    //khai báo list image banner
    private int[] myImageList = new int[]{R.drawable.image_banner_1, R.drawable.image_banner_2,
            R.drawable.image_banner_1,R.drawable.image_banner_4};

    //khai báo đối tượng cho opening this week
    RecyclerView recycle_open_this_week;
    OpenThisWeekAdapter openThisWeekAdapter;
    private List<OpenThisWeek> openThisWeekArrayList = new ArrayList<>();

    //khai báo đối tượng cho coming soon
    RecyclerView recycle_coming_soon;
    ComingSoonAdapter comingSoonAdapter;
    private List<ComingSoon> comingSoonArrayList = new ArrayList<>();

    //khai báo
    public TextView txt_open_this_week, txt_coming_soon;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_movies, container, false);

        //tạo list banner
        bannerArrayList = new ArrayList<>();
        bannerArrayList = populateList();

        //ánh xạ
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new BannerAdapter(getContext(),bannerArrayList));

        LinePageIndicator indicator = (LinePageIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        //Set line indicator radius
        final float density = getResources().getDisplayMetrics().density;
        indicator.setStrokeWidth(3 * density);
        indicator.setLineWidth(20 * density);
        //set color
        indicator.setSelectedColor(getResources().getColor(R.color.selectedbanner));
        indicator.setUnselectedColor(getResources().getColor(R.color.unselectedbanner));

        //set page equals arraylist
        NUM_PAGES =bannerArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        //time swap image
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

        //open this week
        recycle_open_this_week = view.findViewById(R.id.recycleview_open_this_week);
        OpeningThisWeek();
        //coming soon
        recycle_coming_soon = view.findViewById(R.id.recycleview_coming_soon);
        ComingSoon();

        //mapping
        txt_open_this_week = view.findViewById(R.id.txt_open_this_week);
        txt_coming_soon = view.findViewById(R.id.txt_coming_soon);
        //click
        ControlClick();

        return view;
    }

    private void ControlClick() {
        txt_open_this_week.setOnClickListener(this);
        txt_coming_soon.setOnClickListener(this);
    }

    private void OpeningThisWeek() {
        //DATA
        OpenThisWeek openThisWeek = new OpenThisWeek(R.drawable.image_otw_cua_lai_vo_bau,"Cua Lại Vợ Bầu");
        openThisWeekArrayList.add(openThisWeek);

        openThisWeek = new OpenThisWeek(R.drawable.image_otw_bi_kip_luyen_rong,"Bí Kíp Luyện Rồng 3");
        openThisWeekArrayList.add(openThisWeek);

        openThisWeek = new OpenThisWeek(R.drawable.image_otw_trang_quynh,"Trạng Quỳnh");
        openThisWeekArrayList.add(openThisWeek);

        openThisWeek = new OpenThisWeek(R.drawable.image_otw_alita_thien_than_chien_binh,"ALITA: Battle Angel");
        openThisWeekArrayList.add(openThisWeek);

        openThisWeek = new OpenThisWeek(R.drawable.image_otw_cung_tam_ke,"Cung Tâm Kế");
        openThisWeekArrayList.add(openThisWeek);

        openThisWeek = new OpenThisWeek(R.drawable.image_otw_vu_quy_dai_nao,"Vu Quy Đại Náo");
        openThisWeekArrayList.add(openThisWeek);

        openThisWeek = new OpenThisWeek(R.drawable.image_otw_tinh_dau_tho_ngay,"Tình Đầu Thơ Ngây");
        openThisWeekArrayList.add(openThisWeek);

        openThisWeek = new OpenThisWeek(R.drawable.image_otw_tao_quay,"Táo Quậy");
        openThisWeekArrayList.add(openThisWeek);

        //SET RECYCLEVIEW
        openThisWeekAdapter = new OpenThisWeekAdapter(getContext(),R.layout.item_movies_shows,openThisWeekArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycle_open_this_week.setLayoutManager(linearLayoutManager);
        recycle_open_this_week.setItemAnimator(new DefaultItemAnimator());
        recycle_open_this_week.setAdapter(openThisWeekAdapter);
        openThisWeekAdapter.notifyDataSetChanged();
    }

    private void ComingSoon() {
        //DATA
        ComingSoon comingSoon = new ComingSoon(R.drawable.image_cs_avengers_endgame,"AVENGERS: End Game");
        comingSoonArrayList.add(comingSoon);

        comingSoon = new ComingSoon(R.drawable.image_cs_godzilla_king_of_the_monsters,"GODZILLA");
        comingSoonArrayList.add(comingSoon);
        comingSoon = new ComingSoon(R.drawable.image_cs_sinh_nhat_chet_choc,"Happy Death Day U2");
        comingSoonArrayList.add(comingSoon);
        comingSoon = new ComingSoon(R.drawable.image_cs_hellboy,"HELLBOY");
        comingSoonArrayList.add(comingSoon);
        comingSoon = new ComingSoon(R.drawable.image_cs_shazam,"SHAZAM");
        comingSoonArrayList.add(comingSoon);
        comingSoon = new ComingSoon(R.drawable.image_cs_aladdin,"ALADDIN");
        comingSoonArrayList.add(comingSoon);

        //SET RECYCLEVIEW
        comingSoonAdapter = new ComingSoonAdapter(getContext(),R.layout.item_movies_shows,comingSoonArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycle_coming_soon.setLayoutManager(linearLayoutManager);
        recycle_coming_soon.setItemAnimator(new DefaultItemAnimator());
        recycle_coming_soon.setAdapter(comingSoonAdapter);
        comingSoonAdapter.notifyDataSetChanged();
    }

    private ArrayList<Banner> populateList() {
        ArrayList<Banner> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            Banner banner = new Banner();
            banner.setImage_drawable(myImageList[i]);
            list.add(banner);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_open_this_week:
                Toast.makeText(getContext(), "This open this week", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_coming_soon:
                Toast.makeText(getContext(), "This coming soon", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
