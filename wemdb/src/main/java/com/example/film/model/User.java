package com.example.film.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;
    @NotEmpty(message = "Email nem lehet üres!")
    @Column(name = "email", unique = true)
    @Email(message = "Email címnek kell lennie!")
    private String email;
    @Column(name = "user_name", unique = true)
    @NotEmpty(message = "Felhasználónév nem lehet üres!")
    @Size(min = 3, message = "Felhasználónév legalább 3 karaktert kell tartalmazzon!")
    private String userName;
    @NotEmpty(message = "Jelszó nem lehet üres!")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",message = "A jelszónak tartalmaznia kell kis, nagy betűt és számot, illetve legalább 8 karaktert!")
    @Column(name = "password")
    private String password;
    @Column(name = "kritikak_szama")
    private long kritikakSzama;

    @ManyToMany
    @JoinTable(name = "users_roles",
    joinColumns = {@JoinColumn(name ="user_id")},
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<Role>();


    public User() {}

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() { return userId; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
