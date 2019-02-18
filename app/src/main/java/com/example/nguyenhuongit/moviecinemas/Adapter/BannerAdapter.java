package com.example.nguyenhuongit.moviecinemas.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nguyenhuongit.moviecinemas.Data.Banner;
import com.example.nguyenhuongit.moviecinemas.R;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    private ArrayList<Banner> bannerArrayList;
    private LayoutInflater inflater;
    private Context context;

    public BannerAdapter(Context context, ArrayList<Banner> bannerArrayList){
        this.context = context;
        this.bannerArrayList = bannerArrayList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = inflater.inflate(R.layout.layout_banner_slideshow, container, false);
        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image_view_banner);


        imageView.setImageResource(bannerArrayList.get(position).getImage_drawable());

        container.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public int getCount() {
        return bannerArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }


}
