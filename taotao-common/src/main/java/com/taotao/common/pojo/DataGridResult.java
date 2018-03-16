package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * DataGridResult实体类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2018年3月14日 下午4:20:15
 * @version 1.0
 */
public class DataGridResult implements Serializable {

	private static final long serialVersionUID = 520206808068630281L;
	/** {total: 100, rows :[{},{}]} */
	/** 定义总记录数 */
	private long total;
	/** 定义DataGrid组件需要行中的数据 */
	private List<?> rows;
	public DataGridResult(){}
	public DataGridResult(long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}