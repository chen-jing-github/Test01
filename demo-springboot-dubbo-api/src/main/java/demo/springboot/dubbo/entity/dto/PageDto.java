package demo.springboot.dubbo.entity.dto;
import java.io.Serializable;
import java.util.List;

import com.gugusong.sqlmapper.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 分页参数
 * @author yousongshu
 *
 */
@Data
public class PageDto extends Page implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public PageDto() {
		this.setPageIndex(1);
		this.setPageSize(10);
	}
//	
//	public PageDto(Integer pageIndex, Integer pageSize) {
//		this.pageIndex = pageIndex;
//		this.pageSize = pageSize;
//	}
//	public PageDto(Integer pageIndex, Integer pageSize, List<String> propertyDesc, List<String> propertyAsc) {
//		this.pageIndex = pageIndex;
//		this.pageSize = pageSize;
//		this.propertyDesc = propertyDesc;
//		this.propertyAsc = propertyAsc;
//	}
//
//
//	/**
//	 * 第几页，从1开始，默认为1
//	 */
//	private Integer pageIndex;
//	/**
//	 * 每页返回数据量
//	 */
//	private Integer pageSize;
//	/**
//	 * 倒序属性
//	 */
//	private List<String> propertyDesc;
//	/**
//	 * 正序属性
//	 */
//	private List<String> propertyAsc;
}
