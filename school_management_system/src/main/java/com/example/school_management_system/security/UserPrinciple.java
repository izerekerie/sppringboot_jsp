package  com.example.school_management_system.security;


import com.example.school_management_system.models.User;
import com.example.school_management_system.models.enums.ERole;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class UserPrinciple implements UserDetails {

    private Long id;

    private String names;
    private String email;
    private String password;

    private ERole role = ERole.USER;

    private Collection<? extends GrantedAuthority> authorities;


    public static UserPrinciple create(User user) {
        UserPrinciple userPrinciple = new UserPrinciple();

        userPrinciple = (new ModelMapper()).map(user, UserPrinciple.class);

        userPrinciple.authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));

        return userPrinciple;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
