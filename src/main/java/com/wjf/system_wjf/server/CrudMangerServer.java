package com.wjf.system_wjf.server;

import com.wjf.system_wjf.entity.Manger;

public interface CrudMangerServer {
    public Manger selectManger(Manger user);
    public Manger insertManger(Manger user);
}
