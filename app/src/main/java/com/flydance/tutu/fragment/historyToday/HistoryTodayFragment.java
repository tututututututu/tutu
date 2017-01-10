package com.flydance.tutu.fragment.historyToday;

import com.flydance.tutu.R;
import com.flydance.tutu.base.BaseFragment;
import com.flydance.tutu.bean.HistoryTodayListBean;

import java.util.List;


public class HistoryTodayFragment extends BaseFragment implements HistoryTodayContract.View{
	HistoryTodayContract.Presenter  presenter;


	@Override
	public int getLayoutID() {
		return R.layout.fragment_history_today;
	}

	@Override
	public void initView() {
		presenter = new HistoryTodayPresenter(this);
		presenter.start();
	}


	@Override
	public void onSucceess(List<HistoryTodayListBean> listBeen) {

	}

	@Override
	public void onFail(String msg) {

	}

	@Override
	public String getDate() {
		return "6/10";
	}

	@Override
	public void setPresenter(HistoryTodayContract.Presenter presenter) {
		this.presenter = presenter;
	}
}
