package com.kami.blog.service.Impl;
import java.util.ArrayList;
import java.util.List;
import com.kami.blog.dao.RoleprivilegeDao;
import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.Roleprivilege;
import com.kami.blog.common.Assist;
import com.kami.blog.service.RoleprivilegeService;
import com.kami.blog.util.StringHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleprivilegeServiceImpl implements RoleprivilegeService{
    @Autowired
    private RoleprivilegeDao roleprivilegeDao;
    @Override
    public long getRoleprivilegeRowCount(Assist assist){
        return roleprivilegeDao.getRoleprivilegeRowCount(assist);
    }
    @Override
    public List<Roleprivilege> selectRoleprivilege(Assist assist){
        return roleprivilegeDao.selectRoleprivilege(assist);
    }
    @Override
    public Roleprivilege selectRoleprivilegeByObj(Roleprivilege obj){
        return roleprivilegeDao.selectRoleprivilegeByObj(obj);
    }
    @Override
    public Roleprivilege selectRoleprivilegeById(Integer id){
        return roleprivilegeDao.selectRoleprivilegeById(id);
    }
    @Override
    public int insertRoleprivilege(Roleprivilege value){
        return roleprivilegeDao.insertRoleprivilege(value);
    }
    @Override
    public int insertNonEmptyRoleprivilege(Roleprivilege value){
        return roleprivilegeDao.insertNonEmptyRoleprivilege(value);
    }
    @Override
    public int insertRoleprivilegeByBatch(List<Roleprivilege> value){
        return roleprivilegeDao.insertRoleprivilegeByBatch(value);
    }
    @Override
    public int deleteRoleprivilegeById(Integer id){
        return roleprivilegeDao.deleteRoleprivilegeById(id);
    }
    @Override
    public int deleteRoleprivilege(Assist assist){
        return roleprivilegeDao.deleteRoleprivilege(assist);
    }
    @Override
    public int updateRoleprivilegeById(Roleprivilege enti){
        return roleprivilegeDao.updateRoleprivilegeById(enti);
    }
    @Override
    public int updateRoleprivilege(Roleprivilege value, Assist assist){
        return roleprivilegeDao.updateRoleprivilege(value,assist);
    }
    @Override
    public int updateNonEmptyRoleprivilegeById(Roleprivilege enti){
        return roleprivilegeDao.updateNonEmptyRoleprivilegeById(enti);
    }
    @Override
    public int updateNonEmptyRoleprivilege(Roleprivilege value, Assist assist){
        return roleprivilegeDao.updateNonEmptyRoleprivilege(value,assist);
    }

    public RoleprivilegeDao getRoleprivilegeDao() {
        return this.roleprivilegeDao;
    }

    public void setRoleprivilegeDao(RoleprivilegeDao roleprivilegeDao) {
        this.roleprivilegeDao = roleprivilegeDao;
    }
	@Override
	public DatatablesView<Roleprivilege> getData(QueryCondition queryCondition) {
		DatatablesView<Roleprivilege> datatablesView = new DatatablesView<>();
		if(StringHelper.isEmpty(queryCondition.getKeyword())) {
			datatablesView.setData(new ArrayList<>());
			return datatablesView;
		}
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("roleId", queryCondition.getKeyword()));
		long recordsTotal = roleprivilegeDao.getRoleprivilegeRowCount(assist);
		assist.setStartRow(queryCondition.getStart())
				.setRowSize(queryCondition.getLength());
		List<Roleprivilege> data = roleprivilegeDao.selectRoleprivilege(assist);
		datatablesView.setRecordsTotal((int) recordsTotal);
		datatablesView.setData(data);
		return datatablesView;
	}

}