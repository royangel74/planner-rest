package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.model.helper.Access;
import com.iagica.training.plannerrest.domain.model.helper.Function;
import com.iagica.training.plannerrest.repository.helper.AccessRepository;
import com.iagica.training.plannerrest.repository.helper.FunctionRepository;
import com.iagica.training.plannerrest.utils.ApplicationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Optional;

public abstract class RestrictedController {

    @Autowired
    private FunctionRepository functionRepository;

    @Autowired
    private AccessRepository accessRepository;

    public abstract String getPreauthorizeIdFunction();

    public boolean hasPrivilege(Authentication authentication, String idAccess) {
        Optional<? extends GrantedAuthority> authority = authentication.getAuthorities().stream().findFirst();
        if (authority.isPresent()) {
            Integer weightRole = ApplicationUtility.getWeightFromRoleString(authority.get().getAuthority());
            Optional<Function> function = functionRepository.findByIdfunction(this.getPreauthorizeIdFunction());
            Optional<Access> access = accessRepository.findByIdaccess(idAccess);
            if (function.isPresent() && access.isPresent()) {
                return function.get().getAccesslevel() * access.get().getWeight() <= weightRole;
            }
        }
        return false;
    }
}
