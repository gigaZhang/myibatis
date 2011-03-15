package com.freemarker.tool.file;

public class PageData {
	   /** 每页的记录数*/
    private int perPageRecords = 20;    
    /** 当前的页数 */
    private int currentPage;
    /** 总共的记录数 */
    private int totalItems;
    
    private int nearlySize = 5;//附近页数 1 2 3 4 5 6 7 8 9 
	/**
     * 
     */
    public PageData() {
        setCurrentPage(1);
    }
    
    
    /**
     * @param currentPage 当前页
     */
    public PageData(int currentPage) {
        setCurrentPage(currentPage);
    }

    
    /**
     * @param currentPage 当前页,每页的数量
     * @param perPageSize
     */
    public PageData(int currentPage, int perPageSize) {
        setCurrentPage(currentPage);
        setPerPageRecords(perPageSize);

    }
    public PageData(int currentPage, int perPageSize,int totalRecord) {
        setCurrentPage(currentPage);
        setPerPageRecords(perPageSize);
    }
    
    
    /**
     * @返回每页的记录数
     */
    public int getPerPageRecords() {
        return perPageRecords;
    }

    /**
     * @todo 检查是否设置负数
     * @param perPageRecords The perPageRecords to set.
     */
    public void setPerPageRecords(int perPageRecords) {
        this.perPageRecords = perPageRecords;
    }
    
    
    /**
     * Author: Administrator
     * @完成的功能: 返回当前页数
     * @todo 
     * @return
     */
    public int getCurrentPage() {
        return currentPage;
    }
    
    
    

    /**
     * Author: Administrator
     * @完成的功能: 设置当前页数
     * @todo 
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;

    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
        currentPage = Math.min(currentPage, getTotalPages());
    }
    
    
    public int getTotalPages() {
        if (totalItems == 0 || perPageRecords == 0)
            return 1;
        else{
        	return (totalItems + perPageRecords - 1) / perPageRecords;
        }
    }

    public int getNextPage() {
        int next = currentPage + 1;
        if (next >= getTotalPages())
            next = getTotalPages();
        return next;
    }

    public int getPreviousPage() {
        int previous = currentPage - 1;
        if (previous <= 1)
            previous = 1;
        return previous;
    }
    
    
    /**
     * 功能描述: 返回默认的对象,缺省为每页显示10条记录,且显示第1页
     * TODO
     * IBM 
     * @return
     */
    public static PageData DefaultPage(){
    	return new PageData(1,10);
    }

    public boolean getHasPrePage(){
    	return this.getCurrentPage()!=1;
    }
    
    public boolean getHasNextPage(){
    	return getCurrentPage()<getTotalPages();
    }
    
    /**
     * 
     * 方法说明: 判断是否具体下10页 
     * TODO
     * Administrator
     * @return
     * boolean
     * 2008-6-6
     */
    public boolean getHasNext10Page(){
    	int more = getCurrentPage()%10;
    	if(more == 0 ){
    		more = 10;
    	}
    	int leftBorder = (getCurrentPage() - more);
    	if(leftBorder+10 <getTotalPages())
    		return true;
    	return false;
    }

    public boolean getHasPre10Page(){

    	return getCurrentPage()>10;
    }
    
    //得到前10页的最后一页
    public int getPre10PageLast(){
    	//每次显示10页
    	int pageRange = 10;
    	//当前页
    	int curr = this.getCurrentPage();
    	//左边界
    	int more = curr%pageRange;
    	if(more == 0 ){
    		more = 10;
    	}
    	return (curr - more);
    }
    
    //得到后10页的第一页
    public int getNext10PageFirst(){
    	int leftBorder = getPre10PageLast();
    	
    	return leftBorder + 1 + 10;
    }
    
    
    
	public int getTotalItems() {
		return totalItems;
	}

    public int getFirstRecord() {
        return (currentPage - 1) * perPageRecords;
    }
    
    public int[] getNearlyPageNum(){
    	int leftBorder = this.getCurrentPage() - this.nearlySize>1? this.getCurrentPage() - this.nearlySize : 1;
    	int rightBorder = (this.getCurrentPage() + this.nearlySize >this.getTotalPages())? this.getTotalPages() : this.getCurrentPage()+this.nearlySize;
    	int[] nearlyPage = new int[rightBorder - leftBorder+1];
    	int startPos = 0;
    	for(int i=leftBorder;i<=rightBorder;i++){
    		nearlyPage[startPos] = i;
    		startPos++;
    	}
    	return nearlyPage;
    }
    

    
    public static int getStartPos(int totalItems,int currentPage,int perPageSize){
    	if(totalItems<=0){
    		return 0;
    	}
    	currentPage = currentPage-1;
    	if(currentPage*perPageSize>totalItems){
    		return (currentPage)*perPageSize;
    	}
    	return currentPage*perPageSize;
    }
    
    public static int getEndPos(int totalItems,int currentPage,int perPageSize){
    	if(totalItems<=0){
    		return 0;
    	}
    	currentPage = currentPage-1;
    	int endPos = (currentPage+1)*perPageSize;
    	return endPos>totalItems?totalItems:endPos;
    }
    
    public static int getRecordsNum(int totalItems,int currentPage,int perPageSize){
    	if(totalItems<=0){
    		return 0;
    	}
    	if(totalItems<perPageSize){
    		return totalItems;
    	}
    	int records = currentPage*perPageSize;
    	if(records>totalItems){
    		return totalItems - (currentPage-1)*perPageSize;
    	}else{
    		return perPageSize;
    	}

    }
    /**
     * 
     * 方法说明: 得到当前所在页的10页的信息 
     * TODO
     * Administrator
     * @return
     * int[]
     * 2008-6-23
     */
    public int[] getCurrent10PageRange(){
//    	System.out.println("开始-------分页");
    	//每次显示10页
    	int pageRange = 10;
    	//总页数
    	int totalPage =getTotalPages();
    	//当前页
    	int curr = this.getCurrentPage();
    	//左边界
    	int more = curr%10;
    	if(more == 0 ){
    		more = 10;
    	}
    	int leftBorder = (curr - more)+1;
    	
    	int rightBorder;
    	
    	if(getHasNext10Page()){
    		rightBorder = leftBorder + pageRange - 1;
    	}else{
    		rightBorder = totalPage;
    	}
    	
//    	System.out.println("当前:"+curr);
//    	System.out.println("左边:"+leftBorder);
//    	System.out.println("右边:"+rightBorder);

    	int[] pages = new int[rightBorder - leftBorder+1];
    	int currPage = leftBorder;
    	for(int i=0;i<=rightBorder - leftBorder;i++){
    		pages[i] = currPage++;
    	}
    	return pages;
    }
    
    
    public static void main(String[] args) {
//		PageData page = new PageData();
//		page.setTotalItems(309);
//		System.out.println(page.getTotalPages());
    	
    	
    	int totalItems = 4009;
    	int perPageSize = 200;
    	
    	int currentPage = 21;   	
    	
    	
    	System.out.println("当前第:"+currentPage);
    	System.out.println("每页:"+perPageSize);
    	
    	PageData page = new PageData();
    	
    	page.setTotalItems(totalItems);
    	page.setPerPageRecords(perPageSize);
    	page.setCurrentPage(currentPage);   	
    	
    	System.out.println("共:"+page.getTotalPages()+" 页");
    	
//    	System.out.println(PageData.getStartPos(totalItems,currentPage,perPageSize));
//    	System.out.println(PageData.getEndPos(totalItems,currentPage,perPageSize));
//    	System.out.println(PageData.getRecordsNum(totalItems,currentPage,perPageSize)); 	
    	
    	System.out.println(page.getHasNext10Page());
    	System.out.println(page.getHasPre10Page());   	
    	
    	System.out.println("curr ten page:");
    	int[] curr10Page = page.getCurrent10PageRange();
    	for(int i=0;i<curr10Page.length;i++){
    		System.out.print(curr10Page[i]+"\t");

    	}
    	System.out.println();
    	System.out.println("N:"+page.getNext10PageFirst());
    	System.out.println("P:"+page.getPre10PageLast());   	
    	System.out.println();
    	
    	
	}
}
