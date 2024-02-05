<<<<<<< HEAD:src/main/java/com/example/demo/entity/DBUser.java
package com.example.demo.entity;
=======
package com.youcode.evalux.entities;
>>>>>>> main:src/main/java/com/youcode/evalux/entities/DBUser.java

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
<<<<<<< HEAD:src/main/java/com/example/demo/entity/DBUser.java

@Entity
@Data
public class DBUser {
=======
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Data
public class DBUser implements UserDetails {
>>>>>>> main:src/main/java/com/youcode/evalux/entities/DBUser.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String role;
<<<<<<< HEAD:src/main/java/com/example/demo/entity/DBUser.java
=======

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
>>>>>>> main:src/main/java/com/youcode/evalux/entities/DBUser.java
}