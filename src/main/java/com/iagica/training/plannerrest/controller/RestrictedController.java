package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.dto.response.FunctionRoleResponse;
import com.iagica.training.plannerrest.domain.exception.NotFoundException;
import com.iagica.training.plannerrest.domain.model.helper.*;
import com.iagica.training.plannerrest.repository.helper.FunctionRepository;
import com.iagica.training.plannerrest.repository.helper.FunctionRoleRepository;
import com.iagica.training.plannerrest.repository.helper.UserRepository;
import com.iagica.training.plannerrest.services.helper.HelperService;
import com.iagica.training.plannerrest.utility.AppUtility;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
public abstract class RestrictedController {


    public abstract String getPreAuthorizeControllerFunction();

    @Autowired
    HelperService service;
    @Autowired
    FunctionRepository functionRepository;
    @Autowired
    UserRepository userRepository;

    public boolean hasPrevilege(Authentication authentication, String Function) throws Exception {
        FunctionRolePK functionRolePK = new FunctionRolePK();
        Integer idRuolo = AppUtility.getRoleByAutority(authentication.toString());
        String username = AppUtility.getUsername(authentication.getPrincipal().toString());
        Optional<User> user = userRepository.searchUserWithRole(username);
        if (!user.isEmpty()) {

            if (user.get().getRole().getIdRuolo() == idRuolo) {
                 functionRolePK.setUidrole(user.get().getRole());
            }
            Optional<Function> function = functionRepository.findByTypeFunction(Function);

            if (function.isEmpty()) {
                String ErrMsg = "Nessuna Function Trovata";
                throw new NotFoundException(ErrMsg);
            } else {
                functionRolePK.setUidfunction(function.get());
            }
            List<FunctionRoleResponse> f = service.searchFunctionRole(functionRolePK);

            boolean verify = f.stream().anyMatch(c -> c.getFunction().getTypeFunction().contains(Function) && c.getRole().getIdRuolo().equals(user.get().getRole().getIdRuolo()) && c.getAccess().contains(getPreAuthorizeControllerFunction()));

            return verify;
        }
      return false;
    }


}
