package com.cappuccino.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by krime on 1/16/17.
 */
public class Authority implements GrantedAuthority {


    private final String authority;

    public Authority(String authority) {

        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return authority;
    }
}
