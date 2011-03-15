package com.freemarker.dao.impl;

import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.ImageTypeDao;
import com.freemarker.entity.ImageType;

public class ImageTypeDaoImpl extends EntityDaoImpl<ImageType> implements ImageTypeDao{

	public ImageType getImageTypePath(Map map) {
		return (ImageType)getSqlMapClientTemplate().queryForObject("getImageTypePath",map);
	}

	public ImageType getImageTypeId(Map map) {
		return (ImageType)getSqlMapClientTemplate().queryForObject("getImageTypeId",map);
	}

}
