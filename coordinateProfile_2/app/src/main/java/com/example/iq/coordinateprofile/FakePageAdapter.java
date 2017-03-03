package com.example.iq.coordinateprofile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by iQ on 3/3/2017.
 */

public class FakePageAdapter extends RecyclerView.Adapter<FakePageAdapter.FakePageVH> {
private final int numItems;

    public FakePageAdapter(int numItems){
        this.numItems = numItems;
    }

    @Override
    public FakePageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card,parent,false);
        return new FakePageVH(itemView);
    }

    @Override
    public void onBindViewHolder(FakePageVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numItems;
    }

    public class FakePageVH extends RecyclerView.ViewHolder {
        public FakePageVH(View itemView) {
            super(itemView);
        }
    }

}
