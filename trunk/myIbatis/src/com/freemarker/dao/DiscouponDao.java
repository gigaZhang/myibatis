package com.freemarker.dao;

import com.framework.dao.EntityDao;
import com.freemarker.entity.BChannel;

public interface DiscouponDao extends EntityDao<BChannel>{

	public BChannel getDiscntInfo(String disid);
}
