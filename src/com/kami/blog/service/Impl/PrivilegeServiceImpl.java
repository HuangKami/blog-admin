package com.kami.blog.service.Impl;
import java.util.List;
import java.util.Set;

import com.kami.blog.dao.PrivilegeDao;
import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.Privilege;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.common.Assist;
import com.kami.blog.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PrivilegeServiceImpl implements PrivilegeService{
    @Autowired
    private PrivilegeDao privilegeDao;
    @Override
    public long getPrivilegeRowCount(Assist assist){
        return privilegeDao.getPrivilegeRowCount(assist);
    }
    @Override
    public List<Privilege> selectPrivilege(Assist assist){
        return privilegeDao.selectPrivilege(assist);
    }
    @Override
    public Privilege selectPrivilegeByObj(Privilege obj){
        return privilegeDao.selectPrivilegeByObj(obj);
    }
    @Override
    public Privilege selectPrivilegeById(Integer id){
        return privilegeDao.selectPrivilegeById(id);
    }
    @Override
    public int insertPrivilege(Privilege value){
        return privilegeDao.insertPrivilege(value);
    }
    @Override
    public int insertNonEmptyPrivilege(Privilege value){
        return privilegeDao.insertNonEmptyPrivilege(value);
    }
    @Override
    public int insertPrivilegeByBatch(List<Privilege> value){
        return privilegeDao.insertPrivilegeByBatch(value);
    }
    @Override
    public int deletePrivilegeById(Integer id){
        return privilegeDao.deletePrivilegeById(id);
    }
    @Override
    public int deletePrivilege(Assist assist){
        return privilegeDao.deletePrivilege(assist);
    }
    @Override
    public int updatePrivilegeById(Privilege enti){
        return privilegeDao.updatePrivilegeById(enti);
    }
    @Override
    public int updatePrivilege(Privilege value, Assist assist){
        return privilegeDao.updatePrivilege(value,assist);
    }
    @Override
    public int updateNonEmptyPrivilegeById(Privilege enti){
        return privilegeDao.updateNonEmptyPrivilegeById(enti);
    }
    @Override
    public int updateNonEmptyPrivilege(Privilege value, Assist assist){
        return privilegeDao.updateNonEmptyPrivilege(value,assist);
    }

    public PrivilegeDao getPrivilegeDao() {
        return this.privilegeDao;
    }

    public void setPrivilegeDao(PrivilegeDao privilegeDao) {
        this.privilegeDao = privilegeDao;
    }
	@Override
	public DatatablesView<Privilege> getData(QueryCondition queryCondition) {
		DatatablesView<Privilege> datatablesView = new DatatablesView<>();
		long recordsTotal = privilegeDao.getPrivilegeRowCount(null);
		Assist assist = new Assist().setStartRow(queryCondition.getStart())
				.setRowSize(queryCondition.getLength()).setOrder(Assist.order("privilege.id", true));
		if(queryCondition.getKeyword() != null && !queryCondition.getKeyword().equals("")) {
			assist.setRequires(Assist.andLike("name", "%" + queryCondition.getKeyword() + "%"));
		}
		List<Privilege> data = privilegeDao.selectPrivilege(assist);
		datatablesView.setRecordsTotal((int) recordsTotal);
		datatablesView.setData(data);
		return datatablesView;
	}
	@Override
	public Set<Privilege> selectPrivilegesByRoleId(int roleId) {
		return privilegeDao.selectPrivilegesByRoleId(roleId);
	}

}