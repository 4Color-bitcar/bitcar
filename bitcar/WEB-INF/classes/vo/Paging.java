package vo;

public class Paging {
	private int currentPage=1; // 현재 페이지
	private int totalcount; // 전체 카 등록 수
	private int beginPage; // 시작 페이지
	private int endPage; // 마지막 페이지
	private int displayRow=10;// 한 페이지에 등록 된 갯수
	private int displayPage=10;// 한 페이지에 몇개의 페이지
	private boolean prev; // 다음 버튼
	private boolean next;// 이전 버튼
	private int startNum;
	private int endNum;
	
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		startNum = (currentPage -1)* displayRow +1;
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		endNum =  currentPage*displayRow;
		this.endNum = endNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		//setTotalcount()를 꼭 호출해야 paging 이 되기 때문에. 
		//paging()함수를 setTotalCount()를 호출했을 때 자동으로 호출되게 한다.
		this.totalcount = totalcount;
		paging();
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void paging() {
		
		// 마지막 페이지 
		endPage = ((int)Math.ceil(currentPage/(double)displayPage))*displayPage;
		System.out.println("endPage "+ endPage);
		
		//시작 페이지 
	    beginPage = endPage - (displayPage-1);
	    System.out.println("beginPage" +beginPage);
	    
	    // 예를 들어서 글이 32개라고 했을 때 
	    // 32 / 10 = 3.2 (올림) 4페이지 
	    int totalPage = (int)Math.ceil(totalcount /(double)displayRow);
	    
	    if(totalPage > endPage) {
	    	endPage = totalPage;
	    	next = false;
	    }else {
	    	next = true;
	    }
	    
	    prev = (beginPage == 1) ? false : true; 
	    System.out.println("endPage "+ endPage);
	    System.out.println("totalPage" +totalPage);
	    
		
		
		
	}
	

}





































