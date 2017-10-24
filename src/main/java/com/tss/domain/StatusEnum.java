package com.tss.domain;

/**
 * Created by MalikSoban on 25/08/2017.
 */
public enum StatusEnum {

    ACTIVE(1,"Active"),
    PENDING(2,"Pending Approval"),
    DELETED(3,"Deleted"),
    BLOCKED(4,"Blocked");

    private Integer id;
    private String status;

    private StatusEnum(final Integer id, final String status){
        this.id = id;
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public Integer getId()
    {
        return this.id;
    }

    @Override
    public String toString() {
        return "StatusEnum{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
