package com.kami.blog.service.Impl;
import java.util.ArrayList;
import java.util.List;
import com.kami.blog.dao.UserroleDao;
import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.Userrole;
import com.kami.blog.common.Assist;
import com.kami.blog.service.UserroleService;
import com.kami.blog.util.StringHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserroleServiceImpl implements UserroleService{
    @Autowired
    private UserroleDao userroleDao;
    @Override
    public long getUserroleRowCount(Assist assist){
        return userroleDao.getUserroleRowCount(assist);
    }
    @Override
    public List<Userrole> selectUserrole(Assist assist){
        return userroleDao.selectUserrole(assist);
    }
    @Override
    public Userrole selectUserroleByObj(Userrole obj){
        return userroleDao.selectUserroleByObj(obj);
    }
    @Override
    public Userrole selectUserroleById(Integer id){
        return userroleDao.selectUserroleById(id);
    }
    @Override
    public int insertUserrole(Userrole value){
        return userroleDao.insertUserrole(value);
    }
    @Override
    public int insertNonEmptyUserrole(Userrole value){
        return userroleDao.insertNonEmptyUserrole(value);
    }
    @Override
    public int insertUserroleByBatch(List<Userrole> value){
        return userroleDao.insertUserroleByBatch(value);
    }
    @Override
    public int deleteUserroleById(Integer id){
        return userroleDao.deleteUserroleById(id);
    }
    @Override
    public int deleteUserrole(Assist assist){
        return userroleDao.deleteUserrole(assist);
    }
    @Override
    public int updateUserroleById(Userrole enti){
        return userroleDao.updateUserroleById(enti);
    }
    @Override
    public int updateUserrole(Userrole value, Assist assist){
        return userroleDao.updateUserrole(value,assist);
    }
    @Override
    public int updateNonEmptyUserroleById(Userrole enti){
        return userroleDao.updateNonEmptyUserroleById(enti);
    }
    @Override
    public int updateNonEmptyUserrole(Userrole value, Assist assist){
        return userroleDao.updateNonEmptyUserrole(value,assist);
    }

    public UserroleDao getUserroleDao() {
        return this.userroleDao;
    }

    public void setUserroleDao(UserroleDao userroleDao) {
        this.userroleDao = userroleDao;
    }
	@Override
	public DatatablesView<Userrole> getData(QueryCondition queryCondition) {
		DatatablesView<Userrole> datatablesView = new DatatablesView<>();
		if(StringHelper.isEmpty(queryCondition.getKeyword())) {
			datatablesView.setData(new ArrayList<>());
			return datatablesView;
		}
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("userId", queryCondition.getKeyword()));
		long recordsTotal = userroleDao.getUserroleRowCount(assist);
		assist.setStartRow(queryCondition.getStart())
				.setRowSize(queryCondition.getLength());
		List<Userrole> data = userroleDao.selectUserrole(assist);
		datatablesView.setRecordsTotal((int) recordsTotal);
		datatablesView.setData(data);
		return datatablesView;
	}

}