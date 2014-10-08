/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services;

import com.gamersrepublic.domain.Employee;

/**
 *
 * @author Luke
 */
public interface LoginService {
    public Employee validateCredentials(String username, String password);        
}
