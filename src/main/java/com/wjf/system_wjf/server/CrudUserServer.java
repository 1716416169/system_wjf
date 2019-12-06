package com.wjf.system_wjf.server;

import com.wjf.system_wjf.entity.User;

public interface CrudUserServer {
    public User selectUser(User user);
    public User insertUser(User user);
}
