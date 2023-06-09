package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.model.helper.Access;
import com.iagica.training.plannerrest.domain.model.helper.Function;
import com.iagica.training.plannerrest.domain.model.helper.User;
import com.iagica.training.plannerrest.repository.helper.AccessRepository;
import com.iagica.training.plannerrest.repository.helper.FunctionRepository;
import com.iagica.training.plannerrest.repository.helper.UserRepository;
import com.iagica.training.plannerrest.utils.ApplicationUtility;
import com.iagica.training.plannerrest.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Optional;

public abstract class RestrictedController {

    @Autowired
    private FunctionRepository functionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccessRepository accessRepository;

    public abstract String getPreauthorizeIdFunction();

    public boolean hasPrivilege(Authentication authentication, String idAccess) {
        Optional<? extends GrantedAuthority> authority = authentication.getAuthorities().stream().findFirst();
        if (authority.isPresent()) {
            Optional<User> user = userRepository.searchUserWithRole(authentication.getName());
            if (!user.isEmpty() && !user.get().getRole().toString().equals(authority.get().getAuthority())) {
                throw new AccessDeniedException(Constants.MSG_ACCESS_DENIED_ERROR_01);
            }
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
