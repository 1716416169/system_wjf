package com.wjf.system_wjf.server;

import com.wjf.system_wjf.entity.Computer;
import com.wjf.system_wjf.entity.Other;
import org.springframework.data.domain.Page;

public interface CrudOtherServer {
    public Page<Other> selectOther(Integer page, Integer size);
    public Other insertOther(Other other);
    public Page<Other> deleteOther(Integer ... ids);
    public Page<Other> deleteOtherById(Integer id);
    public Other updateOther(Other other);
    public Other selectOtherById(Integer id);
    public Page<Other> selectOtherByName(Integer page,Integer size,String name);
}
