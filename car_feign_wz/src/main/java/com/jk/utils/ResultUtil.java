/** 
 * <pre>项目名称:bootstrap 
 * 文件名称:ResultUtil.java 
 * 包名:com.jk.yeb.utils 
 * 创建日期:2019年3月19日上午11:33:29 
 * Copyright (c) 2019, All Rights Reserved.</pre> 
 */  
package com.jk.utils;

/** 
 * <pre>项目名称：bootstrap    
 * 类名称：ResultUtil    
 * 类描述：    
 * 创建人：杨恩博   
 * 创建时间：2019年3月19日 上午11:33:29    
 * 修改人：杨恩博      
 * 修改时间：2019年3月19日 上午11:33:29    
 * 修改备注：       
 * @version </pre>    
 */
public class ResultUtil {
	
	private Integer total;
	
	private Object rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "ResultUtil [total=" + total + ", rows=" + rows + "]";
	}
	
	

}
