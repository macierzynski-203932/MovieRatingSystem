package dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public class User implements Serializable, UserDetails {


    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserDetails_ details;
    private Boolean isAdmin;


    public User() {
        details = new UserDetails_();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails_ getDetails() {
        return details;
    }

    public void setDetails(UserDetails_ details) {
        this.details = details;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return details.getPassword();
    }

    public void setPassword(String password) {
        details.setPassword(password);
    }

    public boolean isAccountNonExpired() {
        return details.isAccountNonExpired();
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        details.setAccountNonExpired(accountNonExpired);
    }

    public boolean isAccountNonLocked() {
        return details.isAccountNonLocked();
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        details.setAccountNonLocked(accountNonLocked);
    }

    public boolean isCredentialsNonExpired() {
        return details.isCredentialsNonExpired();
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        details.setCredentialsNonExpired(credentialsNonExpired);
    }

    public boolean isEnabled() {
        return details.isEnabled();
    }

    public void setEnabled(boolean enabled) {
        details.setEnabled(enabled);
    }

    public String getUsername() {
        return details.getUsername();
    }

    public void setUsername(String username) {
        details.setUsername(username);
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + '}';
    }
}
