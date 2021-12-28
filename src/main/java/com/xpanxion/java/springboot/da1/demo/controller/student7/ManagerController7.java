package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import com.xpanxion.java.springboot.da1.demo.model.student7.Manager;
import com.xpanxion.java.springboot.da1.demo.service.student7.DataService7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController7 {

    @Autowired
    DataService7 dataService;

    @GetMapping("student7/api/v1/managers")
    public List<Manager> getManagers() {
      return dataService.getManagers();
    }

    @PostMapping("student7/api/v1/managers")
    public Manager insertManager(@RequestBody Manager manager) {
     return dataService.insertManager(manager);
    }

    @PutMapping("student7/api/v1/managers")
    public Manager updateManager(@RequestBody Manager manager) {
        return dataService.updateManager(manager);
    }



}