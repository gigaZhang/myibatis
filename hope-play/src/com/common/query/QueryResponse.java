package com.common.query;

import java.io.Serializable;
import java.util.List;

/**
 *	查询出的结果对象
 * @author lph
 */
@SuppressWarnings("serial")
public class QueryResponse<T> implements Serializable {

	/**
	 * 搜索结果的总数
	 */
    private int totalSize;
    /**
     * 放置返回结果的List
     */
    private List<T> resultList;

    /**
     * @return  搜索结果的总数
     */
    public int getTotalSize() {
        return totalSize;
    }

    /**
     * @param totalSize the totalSize to set
     */
    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }


    /**
     * @return  放置返回结果的List
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * @param resultList the resultList to set
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
