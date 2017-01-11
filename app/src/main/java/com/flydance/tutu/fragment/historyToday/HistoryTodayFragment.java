package com.flydance.tutu.fragment.historyToday;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flydance.basemodule.utils.TDateUtils;
import com.flydance.tutu.R;
import com.flydance.tutu.base.BaseFragment;
import com.flydance.tutu.bean.HistoryTodayListBean;
import com.flydance.tutu.widget.LinearLayoutColorDivider;

import java.util.List;

import butterknife.Bind;


public class HistoryTodayFragment extends BaseFragment implements HistoryTodayContract.View {
	HistoryTodayContract.Presenter presenter;

	@Bind(R.id.rv)
	RecyclerView rv;
	HistoryTodayAdapter adapter;


	@Override
	public int getLayoutID() {
		return R.layout.fragment_history_today;
	}

	@Override
	public void initView() {
		presenter = new HistoryTodayPresenter(this);
		presenter.start();

		adapter = new HistoryTodayAdapter();
		rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
		rv.setItemAnimator(new DefaultItemAnimator());
		rv.addItemDecoration(new LinearLayoutColorDivider(getResources(), R.color.transparent, R.dimen.rv_item_divider,
			RecyclerView.VERTICAL));
		rv.setAdapter(adapter);
	}

	@Override
	public void initTitle(TextView titleName, View ivBack, View ivMenu, View titleRoot) {

		titleName.setText("历史的今天");
		ivBack.setVisibility(View.GONE);
		((ImageView) ivMenu).setImageResource(R.mipmap.time);
		ivMenu.setVisibility(View.VISIBLE);
	}


	@Override
	public void onSucceess(List<HistoryTodayListBean> listBeen) {
		adapter.setData(listBeen);
	}

	@Override
	public void onFail(String msg) {

	}

	@Override
	public String getDate() {
		return TDateUtils.getCurrentMonth() + "/" + TDateUtils.getCurrentDay();
	}

	@Override
	public void setPresenter(HistoryTodayContract.Presenter presenter) {
		this.presenter = presenter;
	}

}
