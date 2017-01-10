package com.flydance.tutu.activity.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.flydance.tutu.R;
import com.flydance.tutu.fragment.historyToday.HistoryTodayFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

	@Bind(R.id.bottom_navigation_bar)
	BottomNavigationBar bottomNavigationBar;


	private HistoryTodayFragment fragmentOne;
	private HistoryTodayFragment fragmentTwo;
	private HistoryTodayFragment fragmentThree;
	private HistoryTodayFragment fragmentFore;
	private HistoryTodayFragment fragmentFive;


	BadgeItem numberBadgeItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		initView();
	}


	private void initView() {

		bottomNavigationBar.setTabSelectedListener(this);//设置监听
		bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
		bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);


		bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home, "今天")
				//非选中状态图标
				.setInactiveIconResource(R.mipmap.home_unckeak)
				.setActiveColorResource(R.color.colorPrimary).setBadgeItem(numberBadgeItem))

			.addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Books")
				.setInactiveIconResource(R.mipmap.menu)
				.setActiveColorResource(R.color.colorPrimary).setBadgeItem(numberBadgeItem))
			.addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Music")
				.setInactiveIconResource(R.mipmap.menu)
				.setActiveColorResource(R.color.colorPrimary).setBadgeItem(numberBadgeItem))
			.addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Movies & TV")
				.setInactiveIconResource(R.mipmap.menu)
				.setActiveColorResource(R.color.colorPrimary).setBadgeItem(numberBadgeItem))
			.initialise();


		setDefaultFragment();//设置默认选项
		numberBadgeItem = new BadgeItem()
			.setBorderWidth(4)
			.setBackgroundColorResource(R.color.colorPrimary)
			.setText("" + 1)
			.setHideOnSelect(true);
	}


	private void setDefaultFragment() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		hideFragments(fragmentTransaction);
		fragmentOne = new HistoryTodayFragment();
		fragmentTransaction.add(R.id.fl_contain, fragmentOne);
		fragmentTransaction.commit();
	}


	private void hideFragments(FragmentTransaction transaction) {
		if (fragmentOne != null) {
			transaction.hide(fragmentOne);
		}
		if (fragmentTwo != null) {
			transaction.hide(fragmentTwo);
		}
		if (fragmentThree != null) {
			transaction.hide(fragmentThree);
		}
		if (fragmentFore != null) {
			transaction.hide(fragmentFore);
		}
		if (fragmentFive != null) {
			transaction.hide(fragmentFive);
		}
	}

	@Override
	public void onTabSelected(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		hideFragments(fragmentTransaction);
		switch (position) {
			case 0:
				if (fragmentOne == null) {
					fragmentOne = new HistoryTodayFragment();
					fragmentTransaction.add(R.id.fl_contain, fragmentOne);

				} else {
					fragmentTransaction.show(fragmentOne);
				}
				break;
			case 1:
				if (fragmentTwo == null) {
					fragmentTwo = new HistoryTodayFragment();
					fragmentTransaction.add(R.id.fl_contain, fragmentTwo);

				} else {
					fragmentTransaction.show(fragmentTwo);
				}
				break;
			case 2:
				if (fragmentThree == null) {
					fragmentThree = new HistoryTodayFragment();
					fragmentTransaction.add(R.id.fl_contain, fragmentThree);

				} else {
					fragmentTransaction.show(fragmentThree);
				}
				break;
			case 3:
				if (fragmentFore == null) {
					fragmentFore = new HistoryTodayFragment();
					fragmentTransaction.add(R.id.fl_contain, fragmentFore);

				} else {
					fragmentTransaction.show(fragmentFore);
				}
				break;
			case 4:
				if (fragmentFive == null) {
					fragmentFive = new HistoryTodayFragment();
					fragmentTransaction.add(R.id.fl_contain, fragmentFive);

				} else {
					fragmentTransaction.show(fragmentFive);
				}
				break;
		}
		fragmentTransaction.commit();
	}

	@Override
	public void onTabUnselected(int position) {

	}

	@Override
	public void onTabReselected(int position) {

	}
}
