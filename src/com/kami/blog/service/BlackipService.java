package com.kami.blog.service;
import java.util.List;
import com.kami.blog.model.Blackip;
import com.kami.blog.common.Assist;
public interface BlackipService{
	/**
	 * 获得Blackip数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getBlackipRowCount(Assist assist);
	/**
	 * 获得Blackip数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Blackip> selectBlackip(Assist assist);
	/**
	 * 获得一个Blackip对象,以参数Blackip对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Blackip selectBlackipByObj(Blackip obj);
	/**
	 * 通过Blackip的id获得Blackip对象
	 * @param id
	 * @return
	 */
    Blackip selectBlackipById(Integer id);
	/**
	 * 插入Blackip到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertBlackip(Blackip value);
	/**
	 * 插入Blackip中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyBlackip(Blackip value);
	/**
	 * 批量插入Blackip到数据库
	 * @param value
	 * @return
	 */
    int insertBlackipByBatch(List<Blackip> value);
	/**
	 * 通过Blackip的id删除Blackip
	 * @param id
	 * @return
	 */
    int deleteBlackipById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Blackip
	 * @param assist
	 * @return
	 */
    int deleteBlackip(Assist assist);
	/**
	 * 通过Blackip的id更新Blackip中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateBlackipById(Blackip enti);
 	/**
	 * 通过辅助工具Assist的条件更新Blackip中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateBlackip(Blackip value,  Assist assist);
	/**
	 * 通过Blackip的id更新Blackip中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyBlackipById(Blackip enti);
 	/**
	 * 通过辅助工具Assist的条件更新Blackip中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyBlackip(Blackip value, Assist assist);
}