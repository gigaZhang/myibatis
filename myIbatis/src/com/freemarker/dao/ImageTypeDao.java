package com.freemarker.dao;

import java.util.Map;

import com.framework.dao.EntityDao;
import com.freemarker.entity.ImageType;

public interface ImageTypeDao extends EntityDao<ImageType>{
	
	public ImageType getImageTypePath(Map map);
	public ImageType getImageTypeId(Map map);


}
