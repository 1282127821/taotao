package com.taotao.admin.service.impl.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.taotao.admin.service.base.BaseService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

public  class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private Mapper<T> mapper;
	private T k;
	//由于是泛型所以我们必须确定下来具体是什么泛型,而我们知道 这里的this表示的是具体调用这个基类的那个对象
	//理解为谁调用就是谁 一般是BaseServiceImpl的子类，这时候肯定有具体的泛型
   public BaseServiceImpl(){
	   //获取父类
	   ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
	   //获取父类泛型类型
	   Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
	   k=(T) actualTypeArguments[0];
   }
	
	@Override
	public void saveSelective(T entity) {
		mapper.insertSelective(entity);

	}

	@Override
	public void updateSelective(T entity) {
		mapper.updateByPrimaryKeySelective(entity);

	}

	@Override
	public void delete(Serializable id) {
		mapper.deleteByPrimaryKey(id);

	}

	@Override
	public void deleteAll(String idField, Serializable[] ids) {
		//其实简单点的就是使用 for循环调用 上面的删除
		/** 创建示范对象 */
		Example example = new Example(null);
		/** 创建条件对象 */
		Criteria criteria = example.createCriteria();
		/** 添加条件 */
		criteria.andIn(idField, Arrays.asList(ids));
		/** 根据条件删除 */
		mapper.deleteByExample(example);

	}

	@Override
	public T findOne(Serializable id) {
		return mapper.selectByPrimaryKey(id);
	}
//这种条件查询就必须自己写，通用mapper无法完成
	@Override
	public List<T> findAll() {
		return mapper.selectAll();
	}

	/** 多条件统计查询 */
	public int countByWhere(T entity){
		return mapper.selectCount(entity);
	}
	
	/** 多条件查询 */
	public List<T> findAllByWhere(T entity){
		return mapper.select(entity);
	}
	
	/** 分页查询 */
	@Override
	public List<T> findByPage(int pageNum, int pageSize) {
		/** 设置分页查询条件 */
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectAll();
	}


}
