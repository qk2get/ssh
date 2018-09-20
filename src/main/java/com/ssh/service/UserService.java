package com.ssh.service;

import com.ssh.dao.UserDao;
import com.ssh.vo.Mate;
import com.ssh.vo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public User findById(int id) {
        User user = userDao.load(id);
        //加载mates-->由于懒加载的原因
        user.sendSQL2LoadMates();
        return user;
    }

    public List<User> queryAll() {
        return userDao.loadAll();
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

}
