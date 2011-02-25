/*
 * EntityDao.java
 * @author kim
 * @version 1.1
 */
package com.framework.dao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.framework.common.PageProperty;

/**
 * 定义每个域对象的增删查改的基本操作及分页操作的数据
 *
 * @author kim
 * @version 1.2
 */
public interface EntityDao<T> {
    //得到数据对象
    public abstract T getModel(Map param);
    //创建数据对象
    public abstract int insert(T po);
    //修改数据对象
    public abstract int update(T po);
    //删除数据对象
    public abstract int delete(Serializable id);
//    //得到数据对象列表按分页条件 当pp.getNpageSize=0时返回所有
//    public abstract List<T> findPageList(PageProperty pp);
//    
//    //得到数据数量按分页条件
//    public abstract int findCount(PageProperty pp);
    public abstract List<T> list(Map param);
    // 删除多条数据对象
    public abstract int deleteList(String id);
    // 删除多条数据对象
    public abstract int deleteGroup(Map param);

}