package com.way.chat.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.way.chat.bean.DaoMaster;
import com.way.chat.bean.DaoSession;


/**
 * Created by tutu on 2017/2/21.
 */

public class Manager {

	private static DaoSession daoSession;

	public static void setupDatabase(Context context) {
		//创建数据库shop.db"
		DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), "app.db", null);
		//获取可写数据库
		SQLiteDatabase db = helper.getWritableDatabase();
		//获取数据库对象
		DaoMaster daoMaster = new DaoMaster(db);
		//获取Dao对象管理者
		daoSession = daoMaster.newSession();
	}

	public static DaoSession getDaoInstant() {
		return daoSession;
	}
}
