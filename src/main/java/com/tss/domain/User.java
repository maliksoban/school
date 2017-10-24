package com.tss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5887911144887254796L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Email
    @NotEmpty
    @Column(name = "email",unique = true)
    private String email;

    @NotEmpty
    @Column(name = "username",unique = true)
    private String userName;

    @NotEmpty
    @Column(name = "password",length = 65)
    private String userPassword;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private Integer country;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean enabled;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", updatable=false)
    private Date createdDate = new Date();

    @Column(name="status")
    private Integer status;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "profile_image")
    private String profileImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Role roles ;


    public boolean isEnabled(boolean enabled) {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
