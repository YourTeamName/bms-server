package edu.gatech.buzzmovieselector.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {

    /**
     * enum containing possible UserStatus values
     */
    public enum UserStatus {
        USER,
        ADMIN,
        BANNED,
        LOCKED;

        @Override
        public String toString() {
            switch (this) {
                case USER:
                    return "USER";
                case ADMIN:
                    return "ADMIN";
                case BANNED:
                    return "BANNED";
                case LOCKED:
                    return "LOCKED";
                default:
                    throw new IllegalArgumentException("Invalid UserStatus " +
                            "enum value");
            }
        }
    }

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "userstatus")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Default constructor for OrmLite
     */
    public User() {
    }

    public User(String username, String password, UserStatus userStatus) {
        this.username = username;
        this.password = password;
        this.userStatus = userStatus;
    }

    public User(String username, String password) {
        this(username, password, UserStatus.USER);
    }

    public User(String username, String password, String userStatus) {
        this.username = username;
        this.password = password;
        UserStatus ul;
        if (userStatus.equalsIgnoreCase("admin")) {
            ul = UserStatus.ADMIN;
        } else if (userStatus.equalsIgnoreCase("user")) {
            ul = UserStatus.USER;
        } else if (userStatus.equalsIgnoreCase("banned")) {
            ul = UserStatus.BANNED;
        } else if (userStatus.equalsIgnoreCase("locked")) {
            ul = UserStatus.LOCKED;
        } else {
            throw new IllegalArgumentException("String cannot be converted to" +
                    " UserStatus");
        }
        this.userStatus = ul;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!User.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final User u = (User) o;
        if (!username.equals(u.username)) {
            return false;
        } else if (!password.equals(u.password)) {
            return false;
        } else if (!userStatus.equals(u.userStatus)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks to see if pass matches the stored user password
     *
     * @param pass Given password to validate
     * @return pass equals the stored password
     */
    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    @Override
    public String toString() {
        return "User: " + username;
    }
}