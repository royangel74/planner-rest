package com.iagica.training.plannerrest.utils;

import java.util.Arrays;

public class ApplicationUtility {

    public static Integer getWeightFromRoleString(String roleString) {
        return Arrays.stream(roleString.split(",")).filter(s -> s.contains("weight")).findFirst().map(s -> {
            return Integer.parseInt(s.split(":")[1]);
        }).orElse(null);
    }
}
