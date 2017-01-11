package com.flydance.tutu.fragment.historyToday;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flydance.tutu.R;
import com.flydance.tutu.bean.HistoryTodayListBean;

import java.util.List;

/**
 * Created by tutu on 2017/1/11.
 */

public class HistoryTodayAdapter extends RecyclerView.Adapter<HistoryTodayAdapter.ViewHolder> {
	private List<HistoryTodayListBean> data;


	public void setData(List<HistoryTodayListBean> data) {
		this.data = data;
		notifyDataSetChanged();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_today_item, parent,
			false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		HistoryTodayListBean bean = data.get(position);
		holder.date.setText(bean.getDate());
		holder.title.setText(bean.getTitle());
	}

	@Override
	public int getItemCount() {
		if (data == null) {
			return 0;
		}
		return data.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		TextView date;
		TextView title;

		public ViewHolder(View itemView) {
			super(itemView);

			date = (TextView) itemView.findViewById(R.id.tv_date);
			title = (TextView) itemView.findViewById(R.id.tv_title);
		}
	}
}
