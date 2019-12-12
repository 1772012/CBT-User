package com.cbtuser.entity;
// Generated Dec 12, 2019 9:49:07 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Userlog generated by hbm2java
 */
@Entity
@Table(name="userlog"
    ,catalog="computerbasedtest"
)
public class Userlog  implements java.io.Serializable {


     private String id;
     private User user;
     private String log;

    public Userlog() {
    }

    public Userlog(String id, User user, String log) {
       this.id = id;
       this.user = user;
       this.log = log;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=15)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="User_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="log", nullable=false, length=200)
    public String getLog() {
        return this.log;
    }
    
    public void setLog(String log) {
        this.log = log;
    }




}


