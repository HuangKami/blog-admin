package com.kami.blog.service.Impl;
import java.util.List;
import java.util.Set;

import com.kami.blog.dao.RoleDao;
import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.Role;
import com.kami.blog.common.Assist;
import com.kami.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;
    @Override
    public long getRoleRowCount(Assist assist){
        return roleDao.getRoleRowCount(assist);
    }
    @Override
    public List<Role> selectRole(Assist assist){
        return roleDao.selectRole(assist);
    }
    @Override
    public Role selectRoleByObj(Role obj){
        return roleDao.selectRoleByObj(obj);
    }
    @Override
    public Role selectRoleById(Integer id){
        return roleDao.selectRoleById(id);
    }
    @Override
    public int insertRole(Role value){
        return roleDao.insertRole(value);
    }
    @Override
    public int insertNonEmptyRole(Role value){
        return roleDao.insertNonEmptyRole(value);
    }
    @Override
    public int insertRoleByBatch(List<Role> value){
        return roleDao.insertRoleByBatch(value);
    }
    @Override
    public int deleteRoleById(Integer id){
        return roleDao.deleteRoleById(id);
    }
    @Override
    public int deleteRole(Assist assist){
        return roleDao.deleteRole(assist);
    }
    @Override
    public int updateRoleById(Role enti){
        return roleDao.updateRoleById(enti);
    }
    @Override
    public int updateRole(Role value, Assist assist){
        return roleDao.updateRole(value,assist);
    }
    @Override
    public int updateNonEmptyRoleById(Role enti){
        return roleDao.updateNonEmptyRoleById(enti);
    }
    @Override
    public int updateNonEmptyRole(Role value, Assist assist){
        return roleDao.updateNonEmptyRole(value,assist);
    }

    public RoleDao getRoleDao() {
        return this.roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
	@Override
	public DatatablesView<Role> getData(QueryCondition queryCondition) {
		DatatablesView<Role> datatablesView = new DatatablesView<>();
		long recordsTotal = roleDao.getRoleRowCount(null);
		Assist assist = new Assist().setStartRow(queryCondition.getStart())
				.setRowSize(queryCondition.getLength()).setOrder(Assist.order("role.id", true));
		if(queryCondition.getKeyword() != null && !queryCondition.getKeyword().equals("")) {
			assist.setRequires(Assist.andLike("name", "%" + queryCondition.getKeyword() + "%"));
		}
		List<Role> data = roleDao.selectRole(assist);
		datatablesView.setRecordsTotal((int) recordsTotal);
		datatablesView.setData(data);
		return datatablesView;
	}
	@Override
	public Set<Role> selectRolesByUserName(String name) {
		return roleDao.selectRolesByUserName(name);
	}

}