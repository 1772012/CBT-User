package com.cbtuser.entity;
// Generated Nov 11, 2019 11:56:01 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Questionmaker generated by hbm2java
 */
@Entity
@Table(name="questionmaker"
    ,catalog="computerbasedtest"
)
public class Questionmaker  implements java.io.Serializable {


     private String id;
     private String username;
     private String password;
     private String firstName;
     private String lastName;
     private String phoneNumber;
     private String email;
     private Set<Subtestdatabase> subtestdatabases = new HashSet<Subtestdatabase>(0);
     private Set<Questionmakerlog> questionmakerlogs = new HashSet<Questionmakerlog>(0);

    public Questionmaker() {
    }

	
    public Questionmaker(String id, String username, String password, String firstName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }
    public Questionmaker(String id, String username, String password, String firstName, String lastName, String phoneNumber, String email, Set<Subtestdatabase> subtestdatabases, Set<Questionmakerlog> questionmakerlogs) {
       this.id = id;
       this.username = username;
       this.password = password;
       this.firstName = firstName;
       this.lastName = lastName;
       this.phoneNumber = phoneNumber;
       this.email = email;
       this.subtestdatabases = subtestdatabases;
       this.questionmakerlogs = questionmakerlogs;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=6)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="username", nullable=false, length=30)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=30)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="first_name", nullable=false, length=75)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", length=75)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="phone_number", length=13)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    @Column(name="email", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="questionmaker")
    public Set<Subtestdatabase> getSubtestdatabases() {
        return this.subtestdatabases;
    }
    
    public void setSubtestdatabases(Set<Subtestdatabase> subtestdatabases) {
        this.subtestdatabases = subtestdatabases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="questionmaker")
    public Set<Questionmakerlog> getQuestionmakerlogs() {
        return this.questionmakerlogs;
    }
    
    public void setQuestionmakerlogs(Set<Questionmakerlog> questionmakerlogs) {
        this.questionmakerlogs = questionmakerlogs;
    }




}


