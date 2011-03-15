package com.freemarker.dao;

import java.util.Map;

import com.framework.dao.EntityDao;
import com.freemarker.entity.ImageGroup;

public interface ImageGroupDao extends EntityDao<ImageGroup>{

	public ImageGroup getImageGroupId(Map map);
}
