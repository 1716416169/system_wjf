package com.wjf.system_wjf.server;

import com.wjf.system_wjf.entity.Computer;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface CrudComputerServer {
    public Page<Computer> selectComputer(Integer page,Integer size);
    public Computer insertComputer(Computer computer);
    public Page<Computer> deleteComputer(Integer ... ids);
    public Page<Computer> deleteComputerById(Integer id);
    public Computer updateComputer(Computer computer);
    public Computer selectComputerById(Integer id);
    public Page<Computer> selectComputerByName(Integer page,Integer size,String name);
}
