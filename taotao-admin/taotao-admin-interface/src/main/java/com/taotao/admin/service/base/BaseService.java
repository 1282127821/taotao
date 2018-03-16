package com.taotao.admin.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * 基础服务接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2018年3月13日 上午10:50:01
 * @version 1.0
 */
public interface BaseService<T> {
	
	/** 选择性添加 */
	void saveSelective(T entity);
	
	/** 选择性修改 */
	void updateSelective(T entity);
	
	/** 根据主键id删除 */
	void delete(Serializable id);
	
	/** 批量删除 */
	void deleteAll(String idField, Serializable[] ids);
	
	/** 根据主键id查询 */
	T findOne(Serializable id);
	
	/** 查询全部 */
	List<T> findAll();
	
	/** 根据查询条件(等于号)查询全部 */
	List<T> findAllByWhere(T entity);
	
	/** 根据查询条件(等于号)统计查询 */
	int countByWhere(T entity);
	
	/** 分页查询 */
	List<T> findByPage(int pageNum, int pageSize);
}