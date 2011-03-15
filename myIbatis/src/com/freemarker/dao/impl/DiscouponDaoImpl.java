package com.freemarker.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.DiscouponDao;
import com.freemarker.entity.BChannel;

public class DiscouponDaoImpl extends EntityDaoImpl<BChannel> implements DiscouponDao{
	
	public BChannel getDiscntInfo(String disid) {
		Map keyMap = new HashMap();
		keyMap.put("disid",disid);
		return (BChannel)getSqlMapClientTemplate().queryForObject("getdiscntinfo",keyMap);
	}

}
