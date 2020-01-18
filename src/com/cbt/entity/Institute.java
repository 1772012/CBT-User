package com.cbt.entity;
// Generated Jan 18, 2020 5:56:25 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Institute generated by hbm2java
 */
@Entity
@Table(name="institute"
    ,catalog="computerbasedtest"
)
public class Institute  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<User> users = new HashSet<User>(0);
     private Set<Participant> participants = new HashSet<Participant>(0);

    public Institute() {
    }

	
    public Institute(String name) {
        this.name = name;
    }
    public Institute(String name, Set<User> users, Set<Participant> participants) {
       this.name = name;
       this.users = users;
       this.participants = participants;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="institute")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="institute")
    public Set<Participant> getParticipants() {
        return this.participants;
    }
    
    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }




}


