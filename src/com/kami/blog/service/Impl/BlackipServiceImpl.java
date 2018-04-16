package com.kami.blog.service.Impl;
import java.util.List;
import com.kami.blog.dao.BlackipDao;
import com.kami.blog.model.Blackip;
import com.kami.blog.common.Assist;
import com.kami.blog.service.BlackipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BlackipServiceImpl implements BlackipService{
    @Autowired
    private BlackipDao blackipDao;
    @Override
    public long getBlackipRowCount(Assist assist){
        return blackipDao.getBlackipRowCount(assist);
    }
    @Override
    public List<Blackip> selectBlackip(Assist assist){
        return blackipDao.selectBlackip(assist);
    }
    @Override
    public Blackip selectBlackipByObj(Blackip obj){
        return blackipDao.selectBlackipByObj(obj);
    }
    @Override
    public Blackip selectBlackipById(Integer id){
        return blackipDao.selectBlackipById(id);
    }
    @Override
    public int insertBlackip(Blackip value){
        return blackipDao.insertBlackip(value);
    }
    @Override
    public int insertNonEmptyBlackip(Blackip value){
        return blackipDao.insertNonEmptyBlackip(value);
    }
    @Override
    public int insertBlackipByBatch(List<Blackip> value){
        return blackipDao.insertBlackipByBatch(value);
    }
    @Override
    public int deleteBlackipById(Integer id){
        return blackipDao.deleteBlackipById(id);
    }
    @Override
    public int deleteBlackip(Assist assist){
        return blackipDao.deleteBlackip(assist);
    }
    @Override
    public int updateBlackipById(Blackip enti){
        return blackipDao.updateBlackipById(enti);
    }
    @Override
    public int updateBlackip(Blackip value, Assist assist){
        return blackipDao.updateBlackip(value,assist);
    }
    @Override
    public int updateNonEmptyBlackipById(Blackip enti){
        return blackipDao.updateNonEmptyBlackipById(enti);
    }
    @Override
    public int updateNonEmptyBlackip(Blackip value, Assist assist){
        return blackipDao.updateNonEmptyBlackip(value,assist);
    }

    public BlackipDao getBlackipDao() {
        return this.blackipDao;
    }

    public void setBlackipDao(BlackipDao blackipDao) {
        this.blackipDao = blackipDao;
    }

}