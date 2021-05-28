package com.zhuandian.movie.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhuandian.base.BaseAdapter;
import com.zhuandian.base.BaseViewHolder;
import com.zhuandian.movie.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * desc:
 * author: xiedong
 * date: 3/26/21
 **/
public class SeatAdapter extends BaseAdapter<Integer, BaseViewHolder> {
    @BindView(R.id.tv_seat)
    TextView tvSeat;
    private int spanCount;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public SeatAdapter(List<Integer> mDatas, Context context, int spanCount) {
        super(mDatas, context);
        this.spanCount = spanCount;
    }

    @Override
    protected void converData(BaseViewHolder myViewHolder, Integer integer, int position) {
        ButterKnife.bind(this, myViewHolder.itemView);
        tvSeat.setText(((position) / spanCount + 1) + "排\n" + ((position) % spanCount + 1) + "号");
        tvSeat.setBackgroundResource(integer.intValue() == 1 ? R.drawable.shape_seat_selected : R.drawable.shape_seat_normal);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(integer.intValue(), position);
                }
            }
        });
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_seat;
    }

    public interface OnItemClickListener {
        void onItemClick(int value, int position);
    }
}


