package com.kami.blog.service;
import java.util.List;
import com.kami.blog.model.Userrole;
import com.kami.blog.common.Assist;
public interface UserroleService extends BaseService<Userrole>{
	/**
	 * 获得Userrole数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getUserroleRowCount(Assist assist);
	/**
	 * 获得Userrole数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Userrole> selectUserrole(Assist assist);
	/**
	 * 获得一个Userrole对象,以参数Userrole对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Userrole selectUserroleByObj(Userrole obj);
	/**
	 * 通过Userrole的id获得Userrole对象
	 * @param id
	 * @return
	 */
    Userrole selectUserroleById(Integer id);
	/**
	 * 插入Userrole到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUserrole(Userrole value);
	/**
	 * 插入Userrole中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyUserrole(Userrole value);
	/**
	 * 批量插入Userrole到数据库
	 * @param value
	 * @return
	 */
    int insertUserroleByBatch(List<Userrole> value);
	/**
	 * 通过Userrole的id删除Userrole
	 * @param id
	 * @return
	 */
    int deleteUserroleById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Userrole
	 * @param assist
	 * @return
	 */
    int deleteUserrole(Assist assist);
	/**
	 * 通过Userrole的id更新Userrole中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateUserroleById(Userrole enti);
 	/**
	 * 通过辅助工具Assist的条件更新Userrole中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateUserrole(Userrole value,  Assist assist);
	/**
	 * 通过Userrole的id更新Userrole中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUserroleById(Userrole enti);
 	/**
	 * 通过辅助工具Assist的条件更新Userrole中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyUserrole(Userrole value, Assist assist);
}