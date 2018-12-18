package com.acsk.shop.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.acsk.shop.model.Authority;

@Entity
@Table(name = "shop_bmb_user")
public class BmbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bmb_user_id")
    Long id;
    String firstName;
    String lastName;
    @Column(name="username")
    String userName;
    String email;
    long phone;
    String city;
    private boolean enabled;
    private String confirmationToken;
    private String password;
    private String activationKey;
    private String resetPasswordKey;
    
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActivationKey() {
		return activationKey;
	}
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}
	public String getResetPasswordKey() {
		return resetPasswordKey;
	}
	public void setResetPasswordKey(String resetPasswordKey) {
		this.resetPasswordKey = resetPasswordKey;
	}
    
    @ManyToMany
    @JoinTable(
            name = "shop_oauth2_user_authority",
            joinColumns = @JoinColumn(name = "bmb_user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Authority> authorities;

	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BmbUser user = (BmbUser) o;

        if (!userName.equals(user.userName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
    	if(userName!=null) {
        return userName.hashCode();}
    	else {
    		return 0;
    	}
    }
    
}
