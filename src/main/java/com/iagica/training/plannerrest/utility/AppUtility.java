package com.iagica.training.plannerrest.utility;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;

import java.util.Arrays;
@Log
public class AppUtility {

    public static Integer getRoleByAutority(String ruolo){
        return Arrays.stream(ruolo.split(",")).filter(r->r.contains("idRuolo")).findFirst().map(i->{
            return Integer.parseInt(i.split(":")[1]);
        }).orElse(null);

    }
}
