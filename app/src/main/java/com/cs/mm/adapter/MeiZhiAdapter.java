package com.cs.mm.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cs.mm.model.GanHuo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by exbbefl on 6/12/2016.
 */
public class MeiZhiAdapter extends RecyclerArrayAdapter<GanHuo.Result> {
    public MeiZhiAdapter(Context context){
        super(context);
    }
    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeiZhiViewHolder(parent);
    }
}
