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

    public boolean hasPrevilege(Authentication authentication, String Function) throws Exception {
        Integer idRuolo = AppUtility.getRoleByAutority(authentication.getAuthorities().toString());
        Role role = new Role();
        FunctionRolePK functionRolePK = new FunctionRolePK();
        if (idRuolo != 0) {
            role.setIdRuolo(idRuolo);
            functionRolePK.setUidrole(role);
        } else {
            String ErrMsg = "Nessun Id Ruolo trovato";
            throw new NotFoundException(ErrMsg);
        }
        Optional<Function> function = functionRepository.findByTypeFunction(Function);
        if (function.isEmpty()) {
            String ErrMsg = "Nessuna Function Trovata";
            throw new NotFoundException(ErrMsg);
        } else {
            functionRolePK.setUidfunction(function.get());
        }
        List<FunctionRoleResponse> f = service.searchFunctionRole(functionRolePK);

        boolean verify = f.stream().anyMatch(c -> c.getFunction().getTypeFunction().contains(Function) && c.getRole().getIdRuolo().equals(role.getIdRuolo())&& c.getAccess().contains(getPreAuthorizeControllerFunction()));

        return verify;
    }
}
