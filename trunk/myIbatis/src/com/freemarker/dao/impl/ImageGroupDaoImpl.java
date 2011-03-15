package com.freemarker.dao.impl;

import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.ImageGroupDao;
import com.freemarker.entity.ImageGroup;

public class ImageGroupDaoImpl extends EntityDaoImpl<ImageGroup> implements ImageGroupDao{
	
	public ImageGroup getImageGroupId(Map map){
		return (ImageGroup)getSqlMapClientTemplate().queryForObject("getImageGroupId", map);
	}

}
