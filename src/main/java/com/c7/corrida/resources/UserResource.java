package com.c7.corrida.resources;


import com.c7.corrida.entities.SocialNetwork;
import com.c7.corrida.entities.User;
import com.c7.corrida.entities.auxiliary.AuxiliaryLogin;
import com.c7.corrida.entities.auxiliary.AuxiliarySocialNetwork;
import com.c7.corrida.services.UserService;
import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Resource
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<User> findyByLogin(@PathVariable String email){
        User user = userService.findByLogin(email);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/top")
    public ResponseEntity<List<User>> findTop(){
        List<User> users = userService.findTop();
        return ResponseEntity.ok().body(users);
    }
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        user = userService.insert(user);
        return ResponseEntity.ok().body(user);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user ){
        user = userService.update(id,user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    // Social Network

    @GetMapping(value = "/social")
    public ResponseEntity<List<SocialNetwork>> findAllSocial(){
        List<SocialNetwork> socialNetworks = userService.findAllSocial();
        return ResponseEntity.ok().body(socialNetworks);
    }

    @GetMapping(value = "/social/{id}")
    public ResponseEntity<SocialNetwork> findByidSocial(@PathVariable Long id){
        SocialNetwork socialNetwork = userService.findByIdSocial(id);
        return ResponseEntity.ok().body(socialNetwork);
    }

    @GetMapping(value = "/social/userid/{id}")
    public ResponseEntity<List<SocialNetwork>> findByUserIdSocial(@PathVariable Long id){
        List<SocialNetwork> socialNetworks= userService.findByUserIdSocial(id);
        return ResponseEntity.ok().body(socialNetworks);
    }

    @PostMapping(value = "/social")
    public ResponseEntity<SocialNetwork> insertSocial(@RequestBody AuxiliarySocialNetwork auxiliarySocialNetworkSocialNetwork){
        SocialNetwork socialNetwork = userService.insertSocial(auxiliarySocialNetworkSocialNetwork);
        return ResponseEntity.ok().body(socialNetwork);
    }

    @PutMapping(value = "/social/{id}")
    public ResponseEntity<SocialNetwork> updateSocial(@PathVariable Long id, @RequestBody SocialNetwork socialNetwork){
        socialNetwork = userService.updateSocial(id, socialNetwork);
        return ResponseEntity.ok().body(socialNetwork);
    }
    @DeleteMapping(value = "/social/{id}")
    public void deleteSocial(@PathVariable Long id){
        userService.deleteSocial(id);
    }

    // Authentication

}
