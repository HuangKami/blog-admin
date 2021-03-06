package com.kami.blog.dao;
import com.kami.blog.model.User;
import java.util.List;
import com.kami.blog.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface UserDao{
	/**
	 * 获得User数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getUserRowCount(Assist assist);
	/**
	 * 获得User数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<User> selectUser(Assist assist);
	/**
	 * 获得一个User对象,以参数User对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    User selectUserByObj(User obj);
	/**
	 * 通过User的id获得User对象
	 * @param id
	 * @return
	 */
    User selectUserById(String id);
	/**
	 * 插入User到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUser(User value);
	/**
	 * 插入User中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyUser(User value);
	/**
	 * 批量插入User到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUserByBatch(List<User> value);
	/**
	 * 通过User的id删除User
	 * @param id
	 * @return
	 */
    int deleteUserById(String id);
	/**
	 * 通过辅助工具Assist的条件删除User
	 * @param assist
	 * @return
	 */
    int deleteUser(Assist assist);
	/**
	 * 通过User的id更新User中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateUserById(User enti);
 	/**
	 * 通过辅助工具Assist的条件更新User中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateUser(@Param("enti") User value, @Param("assist") Assist assist);
	/**
	 * 通过User的id更新User中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUserById(User enti);
 	/**
	 * 通过辅助工具Assist的条件更新User中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyUser(@Param("enti") User value, @Param("assist") Assist assist);
}