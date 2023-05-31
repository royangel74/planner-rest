package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.dto.response.UserRoleFunctionResponse;
import com.iagica.training.plannerrest.domain.model.helper.User;
import com.iagica.training.plannerrest.repository.helper.UserRepository;
import com.iagica.training.plannerrest.utility.AppUtility;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

@Log
public abstract class  RestrictedController {
 private AppUtility appUtility;
 @Autowired
     UserRepository userRepository;



    public boolean hasPrevilege(Authentication authentication){
     Integer idRuolo = AppUtility.getRoleByAutority(authentication.getAuthorities().toString());
     log.info("ID RUOLOOOOO"+idRuolo);
    //    List<User> user = userRepository.searchRoleAndFunctionWhithIdRoleAndIdUser(1,16);
        return true;

    }
}
