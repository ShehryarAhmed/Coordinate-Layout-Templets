package com.example.iq.coordinateprofile;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Material_up_concept extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    private static final int PERCENTAGE_TO_ABINATE_AVATAR = 20;
    private boolean mIsAvtarShow= true;
    private ImageView mprofileImage;
    private int mMaxScrollSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_up_concept);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.materialup_tabs);
        ViewPager viewPager = (ViewPager)findViewById(R.id.materialup_viewPager);
        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.materialup_appbar);
        mprofileImage= (ImageView)findViewById(R.id.material_profile_image);

        Toolbar toolbar = (Toolbar)findViewById(R.id.materialup_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        appBarLayout.addOnOffsetChangedListener(this);
        mMaxScrollSize = appBarLayout.getTotalScrollRange();
        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();
            int percentage= (Math.abs(verticalOffset)) *100 /mMaxScrollSize;

        if (percentage >=PERCENTAGE_TO_ABINATE_AVATAR && mIsAvtarShow){
            mIsAvtarShow = false;
            mprofileImage.animate().scaleX(0).scaleY(0).setDuration(200).start();
        }
        if (percentage<=PERCENTAGE_TO_ABINATE_AVATAR && !mIsAvtarShow){
            mIsAvtarShow =true;
            mprofileImage.animate().scaleX(1).scaleY(1).start();
        }
    }
    class TabsAdapter extends FragmentPagerAdapter{
        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return MaterialUpConceptFakePage.newInstance();
                case 1:
                    return MaterialUpConceptFakePage.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0: return "TAB 1";
                case 1: return "TAB 2";
            }
            return "";
        }
    }
}
