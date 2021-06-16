package demo.springboot.dubbo.entity.vo;

import java.io.Serializable;

import com.gugusong.sqlmapper.springboot.PageData;

public class PageDataVo<T> extends PageData<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public PageDataVo() {
		// TODO Auto-generated constructor stub
	}

	public PageDataVo(PageData<T> pageData) {
		this.setPageIndex(pageData.getPageIndex());
		this.setPageSize(pageData.getPageSize());
		this.setTotalPage(pageData.getTotalPage());
		this.setTotalRows(pageData.getTotalRows());
		this.setList(pageData.getList());
	}
	
}
