package com.way.chat.dao;

import com.way.chat.bean.Shop;
import com.way.chat.bean.ShopDao;
import com.way.chat.manager.Manager;

import java.util.List;

/**
 * Created by tutu on 2017/2/21.
 */

public class ShopDaoUtils {
	/**
	 * 添加数据，如果有重复则覆盖
	 *
	 * @param shop
	 */
	public static void insertLove(Shop shop) {
		Manager.getDaoInstant().getShopDao().insertOrReplace(shop);
	}

	/**
	 * 删除数据
	 *
	 * @param id
	 */
	public static void deleteLove(long id) {
		Manager.getDaoInstant().getShopDao().deleteByKey(id);
	}

	/**
	 * 更新数据
	 *
	 * @param shop
	 */
	public static void updateLove(Shop shop) {
		Manager.getDaoInstant().getShopDao().update(shop);
	}

	/**
	 * 查询条件为Type=TYPE_LOVE的数据
	 *
	 * @return
	 */
	public static List<Shop> queryLove() {
		return Manager.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE))
			.list();
	}

	/**
	 * 查询全部数据
	 */
	public static List<Shop> queryAll() {
		return Manager.getDaoInstant().getShopDao().loadAll();
	}

}
}
