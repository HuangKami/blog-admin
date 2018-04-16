package com.kami.blog.service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kami.blog.common.Assist;
import com.kami.blog.dao.UserDao;
import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.User;
import com.kami.blog.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public long getUserRowCount(Assist assist){
        return userDao.getUserRowCount(assist);
    }
    @Override
    public List<User> selectUser(Assist assist){
        return userDao.selectUser(assist);
    }
    @Override
    public User selectUserByObj(User obj){
        return userDao.selectUserByObj(obj);
    }
    @Override
    public User selectUserById(String id){
        return userDao.selectUserById(id);
    }
    @Override
    public int insertUser(User value){
        return userDao.insertUser(value);
    }
    @Override
    public int insertNonEmptyUser(User value){
        return userDao.insertNonEmptyUser(value);
    }
    @Override
    public int insertUserByBatch(List<User> value){
        return userDao.insertUserByBatch(value);
    }
    @Override
    public int deleteUserById(String id){
        return userDao.deleteUserById(id);
    }
    @Override
    public int deleteUser(Assist assist){
        return userDao.deleteUser(assist);
    }
    @Override
    public int updateUserById(User enti){
        return userDao.updateUserById(enti);
    }
    @Override
    public int updateUser(User value, Assist assist){
        return userDao.updateUser(value,assist);
    }
    @Override
    public int updateNonEmptyUserById(User enti){
        return userDao.updateNonEmptyUserById(enti);
    }
    @Override
    public int updateNonEmptyUser(User value, Assist assist){
        return userDao.updateNonEmptyUser(value,assist);
    }

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
	@Override
	public DatatablesView<User> getData(QueryCondition queryCondition) {
		DatatablesView<User> datatablesView = new DatatablesView<>();
		long recordsTotal = this.userDao.getUserRowCount(null);
		Assist assist = new Assist().setStartRow(queryCondition.getStart())
				.setRowSize(queryCondition.getLength()).setOrder(Assist.order("user.createTime", true));
		if(queryCondition.getKeyword() != null && !queryCondition.getKeyword().equals("")) {
			assist.setRequires(Assist.andLike("name", "%" + queryCondition.getKeyword() + "%"));
		}
		List<User> data = this.userDao.selectUser(assist);
		datatablesView.setRecordsTotal((int) recordsTotal);
		datatablesView.setData(data);
		return datatablesView;
	}
}