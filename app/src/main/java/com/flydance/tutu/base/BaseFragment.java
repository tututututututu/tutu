package com.flydance.tutu.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.flydance.tutu.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.internal.util.SubscriptionList;


/**
 * @author tuhui
 * @Title:BaseFragment
 * @Description: fragment基类 处理子类的公共事件 注解
 * @Company:iblue
 * @date 2016-2-23下午1:14:20
 */
public abstract class BaseFragment extends Fragment {


	public abstract int getLayoutID();

	public abstract void initView();

	public abstract void initTitle(TextView titleName, View ivBack, View ivMenu, View titleRoot);

	private InputMethodManager imm;
	protected Context mActivityContext;
	protected SubscriptionList subscriptions;


	private View rootView;
	TextView titleName;
	View ivBack;
	View ivMenu;
	View titleRoot;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		subscriptions = new SubscriptionList();
		mActivityContext = getContext();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(getLayoutID(), null);
		ButterKnife.bind(this, rootView);
//		ViewGroup parent = (ViewGroup) rootView.getParent();
//		if (parent != null) {
//			parent.removeView(rootView);
//		}
		titleName = (TextView) rootView.findViewById(R.id.tv_titel);
		ivBack = rootView.findViewById(R.id.iv_back);
		ivMenu = rootView.findViewById(R.id.iv_menu);
		titleRoot = rootView.findViewById(R.id.title_root);

		return rootView;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initView();
		initTitle(titleName, ivBack, ivMenu, titleRoot);
	}


	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.unbind(this);
		subscriptions.unsubscribe();
	}

	@Nullable
	@OnClick(R.id.base_layout)
	public void onBaseClick(View view) {
		hideKeyBoard();
	}


	/**
	 * 隐蔽软键盘
	 */
	protected final void hideKeyBoard() {
		if (mActivityContext != null && (mActivityContext instanceof Activity)) {
			if (null == imm) {
				imm = (InputMethodManager) mActivityContext
					.getApplicationContext().getSystemService(
						Context.INPUT_METHOD_SERVICE);
			}
			View currentFocus = ((Activity) mActivityContext).getCurrentFocus();
			if (null != currentFocus && imm.isActive()) {
				imm.hideSoftInputFromWindow(currentFocus.getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}

	/**
	 * 显示软键盘
	 */
	protected final void showKeyBoard(View focus) {
		if (mActivityContext != null && (mActivityContext instanceof Activity)) {
			if (null == imm) {
				imm = (InputMethodManager) mActivityContext
					.getApplicationContext().getSystemService(
						Context.INPUT_METHOD_SERVICE);
			}
			if (null == focus) {
				focus = ((Activity) mActivityContext).getCurrentFocus();
			}
			if (null != focus) {
				imm.showSoftInput(focus, InputMethodManager.SHOW_FORCED);
			}
		}
	}


	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
	}
}
