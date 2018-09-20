package com.ssh.service;

import com.ssh.dao.MateDao;
import com.ssh.vo.Mate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MateService {
    @Autowired
    private MateDao mateDao;

    public void save(Mate mate){
        mateDao.save(mate);
    }

    public Mate loadById(int id){
        Mate mate = mateDao.load(id);
        //加载User
        //mate.sendSQL2LoadUser();
        return mate;
    }
}
