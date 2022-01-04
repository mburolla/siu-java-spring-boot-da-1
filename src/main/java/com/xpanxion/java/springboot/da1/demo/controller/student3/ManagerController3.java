package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student3.DataService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController3 {

    @Autowired
    DataService3 dataService3;

    //
    //GetMap
    //

    @GetMapping("student3/api/v1/managers")
    public List<Manager> getManager(){
        return dataService3.getManager();
    }

    //
    //PostMap
    //

    @PostMapping("student3/api/v1/managers")
    public Manager addManager(@RequestBody Manager manager){
        return dataService3.addManager(manager);
    }

    //
    //PutMap
    //

    @PutMapping("student3/api/v1/managers")
    public Manager updateManagerName(@RequestBody Manager manager){
        return dataService3.updateManagerName(manager);
    }
}