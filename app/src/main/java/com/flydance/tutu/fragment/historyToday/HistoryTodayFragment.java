package com.flydance.tutu.fragment.historyToday;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flydance.basemodule.utils.TDateUtils;
import com.flydance.basemodule.widget.loadingLayout.LoadingLayout;
import com.flydance.basemodule.widget.xRecyclerView.XRecyclerView;
import com.flydance.tutu.R;
import com.flydance.tutu.base.BaseFragment;
import com.flydance.tutu.bean.HistoryTodayListBean;
import com.flydance.tutu.widget.LinearLayoutColorDivider;
import com.flydance.tutu.widget.Toast;

import java.util.List;

import butterknife.Bind;

public class HistoryTodayFragment extends BaseFragment implements HistoryTodayContract.View {
	HistoryTodayContract.Presenter presenter;

	@Bind(R.id.rv)
	XRecyclerView rv;
	@Bind(R.id.loadingLayout)
	LoadingLayout loadingLayout;

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
		rv.setLoadingMoreEnabled(false);


		rv.setLoadingListener(new XRecyclerView.LoadingListener() {
			@Override
			public void onRefresh() {
				presenter.requestList(getDate(),false);
			}

			@Override
			public void onLoadMore() {

			}
		});


		loadingLayout.setOnReloadListener(new LoadingLayout.OnReloadListener() {
			@Override
			public void onReload(View v) {
				presenter.requestList(getDate(),false);
			}
		});

	}

	@Override
	public void initTitle(TextView titleName, View ivBack, View ivMenu, View titleRoot) {

		titleName.setText("历史的今天");
		ivBack.setVisibility(View.GONE);
		((ImageView) ivMenu).setImageResource(R.mipmap.time);
		ivMenu.setVisibility(View.VISIBLE);
	}


	@Override
	public void onLoadData(List<HistoryTodayListBean> listBeen) {
		adapter.setData(listBeen);
		rv.refreshComplete();
		onSucceess();
	}


	@Override
	public void onFail(String msg) {
		Toast.showErrorToast(msg);
		rv.refreshComplete();
	}

	@Override
	public void onEmptyData() {
		loadingLayout.setStatus(LoadingLayout.Empty);
	}

	@Override
	public void onError(String msg) {
		loadingLayout.setErrorText(msg);
		loadingLayout.setStatus(LoadingLayout.Error);
	}

	@Override
	public void onNetError() {
		loadingLayout.setStatus(LoadingLayout.No_Network);
	}

	@Override
	public void onSucceess() {
		loadingLayout.setStatus(LoadingLayout.Success);
	}

	@Override
	public void onLoading() {
		loadingLayout.setStatus(LoadingLayout.Loading);
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
