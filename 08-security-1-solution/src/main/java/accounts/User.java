package accounts;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
    private String username;                    // required
    private String password;                    // required
    private String confirmPassword;
    private String passwordHint;
    private String firstName;                   // required
    private String lastName;                    // required
    private String email;                       // required; unique
    private String phoneNumber;
    private String website;
    private Integer version;
    private Set<Role> roles = new HashSet<Role>();
    private boolean enabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public User() {
    }

    /**
     * Create a new instance and set the username.
     *
     * @param username login name for user.
     */
    public User(final String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    /**
     * Returns the full name.
     *
     * @return firstName + ' ' + lastName
     */
    public String getFullName() {
        return firstName + ' ' + lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Adds a role for the user
     *
     * @param role the fully instantiated role
     */
    public void addRole(Role role) {
        getRoles().add(role);
    }

    /**
     * @return GrantedAuthority[] an array of roles.
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        authorities.addAll(roles);
        return authorities;
    }

    public Integer getVersion() {
        return version;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    /**
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     * @return true if account is still active
     */
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    /**
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     * @return false if account is locked
     */
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    /**
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     * @return true if credentials haven't expired
     */
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        final User user = (User) o;

        return !(username != null ? !username.equals(user.getUsername()) : user.getUsername() != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (username != null ? username.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(username);
		sb.append("[");
		for (Role a : roles){
			sb.append(a.getName());
			sb.append(" ,");
		}
		sb.append("]");
		return sb.toString().replace(" ,]", "]");
	}
}
