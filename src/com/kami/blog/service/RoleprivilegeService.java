package com.kami.blog.service;
import java.util.List;
import com.kami.blog.model.Roleprivilege;
import com.kami.blog.common.Assist;
public interface RoleprivilegeService extends BaseService<Roleprivilege>{
	/**
	 * 获得Roleprivilege数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getRoleprivilegeRowCount(Assist assist);
	/**
	 * 获得Roleprivilege数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Roleprivilege> selectRoleprivilege(Assist assist);
	/**
	 * 获得一个Roleprivilege对象,以参数Roleprivilege对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Roleprivilege selectRoleprivilegeByObj(Roleprivilege obj);
	/**
	 * 通过Roleprivilege的id获得Roleprivilege对象
	 * @param id
	 * @return
	 */
    Roleprivilege selectRoleprivilegeById(Integer id);
	/**
	 * 插入Roleprivilege到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertRoleprivilege(Roleprivilege value);
	/**
	 * 插入Roleprivilege中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyRoleprivilege(Roleprivilege value);
	/**
	 * 批量插入Roleprivilege到数据库
	 * @param value
	 * @return
	 */
    int insertRoleprivilegeByBatch(List<Roleprivilege> value);
	/**
	 * 通过Roleprivilege的id删除Roleprivilege
	 * @param id
	 * @return
	 */
    int deleteRoleprivilegeById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Roleprivilege
	 * @param assist
	 * @return
	 */
    int deleteRoleprivilege(Assist assist);
	/**
	 * 通过Roleprivilege的id更新Roleprivilege中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateRoleprivilegeById(Roleprivilege enti);
 	/**
	 * 通过辅助工具Assist的条件更新Roleprivilege中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateRoleprivilege(Roleprivilege value,  Assist assist);
	/**
	 * 通过Roleprivilege的id更新Roleprivilege中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyRoleprivilegeById(Roleprivilege enti);
 	/**
	 * 通过辅助工具Assist的条件更新Roleprivilege中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyRoleprivilege(Roleprivilege value, Assist assist);
}