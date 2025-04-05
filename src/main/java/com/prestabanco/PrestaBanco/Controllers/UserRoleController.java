package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Entities.UserRoleEntity;
import com.prestabanco.PrestaBanco.Services.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-role")
@CrossOrigin("*")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserRoleEntity>> getAll() {
        List<UserRoleEntity> userRoleEntities = userRoleService.getAll();
        return ResponseEntity.ok(userRoleEntities);
    }

}
