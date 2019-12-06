package com.wjf.system_wjf.server.impl;

import com.wjf.system_wjf.entity.Computer;
import com.wjf.system_wjf.repository.ComputerRepository;
import com.wjf.system_wjf.server.CrudComputerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CrudComputerServerImpl implements CrudComputerServer {

    @Autowired
     ComputerRepository computerRepository;

    static Sort sort;

    @Override
    public Page<Computer> selectComputer(Integer page,Integer size) {
        page-=1;
        Sort id = sort.by(Sort.Direction.ASC, "id");
        Pageable of = PageRequest.of(page, size,id);
        Page<Computer> all = computerRepository.findAll(of);
        return all;
    }

    @Override
    public Computer insertComputer(Computer computer) {
        Computer save = computerRepository.save(computer);
        return save;
    }

    @Override
    public Page<Computer> deleteComputer(Integer... ids) {
        for (Integer id:ids) {
            computerRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public Page<Computer> deleteComputerById(Integer id) {
        computerRepository.deleteById(id);
        return null;
    }

    @Override
    public Computer updateComputer(Computer computer) {
        Computer save = computerRepository.save(computer);
        return save;
    }

    @Override
    public Computer selectComputerById(Integer id) {
        Optional<Computer> byId = computerRepository.findById(id);
        return byId.get();
    }

    @Override
    public Page<Computer> selectComputerByName(Integer page,Integer size,String name) {
        page-=1;
        Sort id = sort.by(Sort.Direction.ASC, "id");
        PageRequest of = PageRequest.of(page, size, id);
        Page<Computer> byNameLike = computerRepository.findByNameLike("%"+name+"%", of);
        return byNameLike;
    }


}
