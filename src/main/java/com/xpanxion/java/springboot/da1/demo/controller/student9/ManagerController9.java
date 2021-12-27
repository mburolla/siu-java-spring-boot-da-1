package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student9/api/v1/managers")
@RestController
public class ManagerController9 {

    @GetMapping()
    public List<Manager> getManagers(){
        var temp = dataAccessManager.getManagerList();
        return temp;
    }

    @Autowired
    private DataAccessManager dataAccessManager;


    @PostMapping
    public void insertManager(@RequestBody Manager manager){
       dataAccessManager.addManager(manager);
    }

    @PutMapping
    public void updateManager(@RequestBody Manager manager){
        dataAccessManager.updateManager(manager);
    }


}

@Service
class DataAccessManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_ALL_MANAGERS = "SELECT * FROM manager";

    private final String INSERT_MANAGER = "INSERT INTO manager (full_name) VALUES (?)";

    private final String UPDATE_MANAGER = "UPDATE manager SET full_name = ? WHERE manager_id = ?";




    public DataAccessManager() {}

    public void updateManager(Manager manager){
        jdbcTemplate.update(UPDATE_MANAGER,manager.getFull_name(),manager.getId());
    }

    public void addManager(Manager manager){
         jdbcTemplate.update(INSERT_MANAGER,manager.getFull_name());
    }

    public List<Manager> getManagerList() {
        List<Manager> managerList;
         managerList = jdbcTemplate.query(SELECT_ALL_MANAGERS, (row,rowNum) -> {
            var id = Integer.parseInt(row.getString("manager_id"));
            var full_name = row.getString("full_name");
            return new Manager(id,full_name);
        });
         return managerList;
    }

}
