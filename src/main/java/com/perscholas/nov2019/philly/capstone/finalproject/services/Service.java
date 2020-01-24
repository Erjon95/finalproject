package com.perscholas.nov2019.philly.capstone.finalproject.services;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Collection;

public class Service {
    public boolean isThere (Collection<?> c){return false;}

    public String hashPassword(String password)
    {
        String hashedPwd = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPwd;
    }
}
