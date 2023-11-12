package com.example.email.data;

import com.example.email.data.enums.UserRight;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Email(message = "Invalid e-mail")
    @NotEmpty(message = "Cannot be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "Please enter first name")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Please enter surname")
    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_right", joinColumns = @JoinColumn(name = "user_id"))
    private Set<UserRight> rights;

    public User() {

    }

    public User(int id, String email, String firstName, String surname, String password, boolean enabled, String confirmationToken, Set<UserRight> rights) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.password = password;
        this.enabled = enabled;
        this.confirmationToken = confirmationToken;
        this.rights = rights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRight> getRights() {
        return rights;
    }

    public void setRights(Set<UserRight> rights) {
        this.rights = rights;
    }
}
