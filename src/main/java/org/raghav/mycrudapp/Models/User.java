package org.raghav.mycrudapp.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID Id;
    @Column(unique = false, nullable = false, length = 45, name = "first_name")
    private String FirstName;
    @Column(unique = false, nullable = false, length = 45, name = "last_name")
    private String LastName;
    @Column(unique = false, nullable = false, length = 15, name = "password")
    private String Password;
    @Column(unique = true, nullable = false, length = 45, name = "email_id")
    private String EmailId;
    @Column(unique = true, nullable = false, length = 10, name = "phone_number")
    private long PhoneNumber;
    @Column(name = "is_enabled", nullable = false)
    private boolean IsEnabled;


    public boolean getIsEnabled() {
        return IsEnabled;
    }

    public void setIsEnabled(boolean enabled) {
        IsEnabled = enabled;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Password='" + Password + '\'' +
                ", EmailId='" + EmailId + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}
