package edu.gatech.buzzmovieselector.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "profile")
public class Profile {

    public static final String[] USER_DEGREES = {"", "Architecture",
            "Building Construction",
            "Industrial Design", "Computer Science", "Computational Media",
            "Aerospace Engineering",
            "Biomedical Engineering", "Chemical Engineering", "Civil " +
            "Engineering",
            "Computer Engineering", "Electrical Engineering", "Environmental " +
            "Engineering",
            "Industrial Engineering", "Materials Science and Engineering",
            "Mechanical Engineering",
            "Nuclear Engineering", "Business Administration",
            "Applied Language and Intercultural Studies", "Economics",
            "Economics and International Affairs", "Global Economics and " +
            "Modern Languages",
            "History, Technology, and Society", "International Affairs",
            "International Affairs and Modern Languages", "Literature, Media," +
            " and Communication",
            "Public Policy", "Applied Mathematics", "Applied Physics",
            "Biochemistry", "Biology",
            "Chemistry", "Discrete Mathematics", "Earth and Atmospheric " +
            "Sciences", "Physics",
            "Psychology", "Computational Science and Engineering"};

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "major")
    private String major;
    @Column(name = "email")
    private String email;

    /**
     * Default constructor for OrmLite
     */
    public Profile() {
    }

    public Profile(String firstName, String lastName, String major, String
            email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.email = email;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Profile: " + firstName + " " + lastName;
    }
}