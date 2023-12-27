package com.itbank.components;

public class Paging {
	private int reqPage;
	private int offset, perCount = 10;
	private int totalBoard, totalPage;
	private int perPage = 10;
	private int section;
	private int begin, end; 
	private boolean prev, next;
	private Integer type;
	private String order;
	private String keyword;
	private String search;

	public Paging(int reqPage, int totalBoard, Integer type, String order, String keyword, String search) {
		this.reqPage = reqPage;
		this.totalBoard = totalBoard;
		this.type = type;
		this.order = order;
		this.keyword = keyword;
		this.search = search;
		
		offset = (reqPage - 1) * perCount;
		
		totalPage = totalBoard / perPage;
		totalPage += (totalBoard % perPage == 0) ? 0 : 1;
		
		section = (reqPage - 1) / perPage;
		begin = (section * perPage) + 1;
		end = (section + 1) * 10;

		end = (end > totalPage) ? totalPage : end;
		
		prev = section != 0;
		next = end != totalPage;
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPerCount() {
		return perCount;
	}

	public void setPerCount(int perCount) {
		this.perCount = perCount;
	}

	public int getTotalBoard() {
		return totalBoard;
	}

	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
