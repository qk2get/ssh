package com.ssh.web.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.service.UserService;
import com.ssh.vo.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    @Resource(name = "userService")
    private UserService userService;
    private int id;
    private User user;

    public void load() throws Exception {
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(userService.queryAll());
        ServletActionContext.getResponse().getWriter().print(jsonString);
    }

    public void save() {
        userService.save(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
