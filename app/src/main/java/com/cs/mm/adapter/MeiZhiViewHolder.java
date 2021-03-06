package com.cs.mm.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cs.mm.R;
import com.cs.mm.model.GanHuo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by exbbefl on 6/12/2016.
 */
public class MeiZhiViewHolder extends BaseViewHolder<GanHuo.Result> {
    private ImageView image;

    public MeiZhiViewHolder(ViewGroup parent) {
        super(parent, R.layout.meizhi_item);
        image = $(R.id.image);
    }

    @Override
    public void setData(GanHuo.Result data) {
        super.setData(data);
        Glide.with(getContext())
                .load(data.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
    }
}

