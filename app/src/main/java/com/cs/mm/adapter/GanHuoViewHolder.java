package com.cs.mm.adapter;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cs.mm.R;
import com.cs.mm.model.GanHuo;
import com.cs.mm.util.TimeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by exbbefl on 6/12/2016.
 */
public class GanHuoViewHolder extends BaseViewHolder<GanHuo.Result> {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.who)
    TextView who;
    @BindView(R.id.time)
    TextView time;

    public GanHuoViewHolder(ViewGroup parent) {
        super(parent, R.layout.ganhuo_item);
    }

    @Override
    public void setData(GanHuo.Result data){
        super.setData(data);

        title.setText(data.getDesc());
        type.setText(data.getType());

        if (data.getType().equals("Android")){
            setDrawableLeft(R.drawable.ic_android_black_24dp);
        }else if (data.getType().equals("iOS")){
            setDrawableLeft(R.drawable.ic_whatshot_black_24dp);
        }else {
            setDrawableLeft(R.drawable.ic_play_circle_filled_black_24dp);
        }

        who.setText(data.getWho());
        time.setText(TimeUtil.getFormatTime(data.getPublishedAt()));
    }

    private void setDrawableLeft(int imageId) {
        Drawable drawable = getContext().getResources().getDrawable(imageId);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        type.setCompoundDrawables(drawable,null,null,null);
    }
}
