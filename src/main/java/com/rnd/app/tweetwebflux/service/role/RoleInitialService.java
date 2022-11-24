package com.rnd.app.tweetwebflux.service.role;

import com.rnd.app.tweetwebflux.model.Role;
import com.rnd.app.tweetwebflux.repository.RoleRepository;
import com.rnd.app.tweetwebflux.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RoleInitialService {

    @Autowired
    private RoleRepository roleRepository;

    @Scheduled(fixedRate = 500)
    public void print(){
        this.roleData();
    }

    private List<Role> roleData(){
        if (roleRepository.findAll().toStream().collect(Collectors.toList()).isEmpty()){
            log.info("init role data");
            Role roleAdmin = new Role();
            roleAdmin.setId(UUID.randomUUID().toString());
            roleAdmin.setName(Constant.ROLE_ADMIN);
            roleAdmin.setDeleted(Constant.ACTIVE);
            this.roleRepository.save(roleAdmin).block();

            Role roleUser = new Role();
            roleUser.setId(UUID.randomUUID().toString());
            roleUser.setName(Constant.ROLE_USER);
            roleUser.setDeleted(Constant.ACTIVE);
            this.roleRepository.save(roleUser).block();

            Role roleMaker = new Role();
            roleMaker.setId(UUID.randomUUID().toString());
            roleMaker.setName(Constant.ROLE_MAKER);
            roleMaker.setDeleted(Constant.ACTIVE);
            this.roleRepository.save(roleMaker).block();

            Role roleApprover = new Role();
            roleApprover.setId(UUID.randomUUID().toString());
            roleApprover.setName(Constant.ROLE_APPROVER);
            roleApprover.setDeleted(Constant.ACTIVE);
            this.roleRepository.save(roleApprover).block();
            log.info("finish init data..");
            List<Role> roles = new ArrayList<>();
            roles.add(roleAdmin);
            roles.add(roleApprover);
            roles.add(roleMaker);
            roles.add(roleUser);
            return roles;
        }
        return new ArrayList<>();
    }
}
