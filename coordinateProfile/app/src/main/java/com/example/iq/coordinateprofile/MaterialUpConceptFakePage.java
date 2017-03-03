package com.example.iq.coordinateprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by iQ on 3/3/2017.
 */

public class MaterialUpConceptFakePage extends Fragment {
    private RecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mRecyclerView = (RecyclerView)inflater.inflate(R.layout.fragment_pager,container,false);
        return mRecyclerView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initRecylerView();
    }
    private void initRecylerView(){
        mRecyclerView.setAdapter(new FakePageAdapter(5));
    }
    public static Fragment newInstance(){
        return new MaterialUpConceptFakePage();
    }
}
