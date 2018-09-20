package com.ssh.service;

import com.ssh.dao.SoulmateDao;
import com.ssh.vo.Soulmate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SoulmateService {
    @Resource(name = "soulmateDao")
    private SoulmateDao soulmateDao;

    public Soulmate findById(int id) {
        Soulmate soulmate = soulmateDao.load(id);
        soulmate.getUser().getName();
        return soulmate;
    }

    public List<Soulmate> queryAll() {
        return soulmateDao.loadAll();
    }

    public void save(Soulmate soulmate) {
        soulmateDao.save(soulmate);
    }

    public void delete(int id) {
        soulmateDao.delete(id);
    }
}
