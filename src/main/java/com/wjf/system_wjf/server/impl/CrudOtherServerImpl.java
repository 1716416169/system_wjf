package com.wjf.system_wjf.server.impl;

import com.wjf.system_wjf.entity.Computer;
import com.wjf.system_wjf.entity.Other;
import com.wjf.system_wjf.repository.OtherRepository;
import com.wjf.system_wjf.server.CrudOtherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrudOtherServerImpl implements CrudOtherServer {

    @Autowired
    OtherRepository otherRepository;
    static Sort sort;
    @Override
    public Page<Other> selectOther(Integer page, Integer size) {
        page-=1;
        Sort id = sort.by(Sort.Direction.ASC, "id");
        Pageable of = PageRequest.of(page, size,id);
        Page<Other> all =otherRepository.findAll(of);
        return all;
    }

    @Override
    public Other insertOther(Other other) {
        Other save = otherRepository.save(other);
        return save;
    }

    @Override
    public Page<Other> deleteOther(Integer... ids) {
        for (Integer id:ids) {
            otherRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public Page<Other> deleteOtherById(Integer id) {
        otherRepository.deleteById(id);
        return null;
    }

    @Override
    public Other updateOther(Other other) {
        Other save = otherRepository.save(other);
        return save;
    }

    @Override
    public Other selectOtherById(Integer id) {
        Optional<Other> byId = otherRepository.findById(id);
        return byId.get();
    }

    @Override
    public Page<Other> selectOtherByName(Integer page,Integer size,String name) {
        page-=1;
        Sort id = sort.by(Sort.Direction.ASC, "id");
        PageRequest of = PageRequest.of(page, size, id);
        Page<Other> byNameLike = otherRepository.findByNameLike("%"+name+"%", of);
        return byNameLike;
    }
}
