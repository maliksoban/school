package com.tss.domain;

/**
 * Created by MalikSoban on 25/08/2017.
 */

public enum RoleEnum {

    USER(3,"ROLE_USER");

    private Integer id;
    private String roleType;

    private RoleEnum(final Integer id, final String roleType){
        this.id = id;
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
    public Integer getId()
    {
        return this.id;
    }

}
