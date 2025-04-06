package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Entities.MCTypesEntity;
import com.prestabanco.PrestaBanco.Entities.UserEntity;
import com.prestabanco.PrestaBanco.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity> userEntities = userService.getAll();
        return ResponseEntity.ok(userEntities);
    }

    @GetMapping("/getNameById/{id}")
    public ResponseEntity<UserEntity> getNameById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody Map<String, Object> requestData){
        String name = requestData.get("name").toString();
        String password1 = requestData.get("password1").toString();
        String password2 = requestData.get("password2").toString();
        String role = requestData.get("role").toString();

        if(password1.equals(password2)){
            UserEntity user = userService.register(name, password1, role);
            if(user!=null){
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ya existe un usuario con ese nombre");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Las contraseñas no son iguales");
        }



    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, Object> requestData){
        String name = requestData.get("name").toString();
        String password = requestData.get("password").toString();


        UserEntity user = userService.login(name, password);
        if(user!=null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o Contraseña incorrectas");
        }
    }

}
