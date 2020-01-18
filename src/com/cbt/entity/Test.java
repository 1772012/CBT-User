package com.cbt.entity;
// Generated Jan 18, 2020 5:56:25 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Test generated by hbm2java
 */
@Entity
@Table(name="test"
    ,catalog="computerbasedtest"
)
public class Test  implements java.io.Serializable {


     private String id;
     private User user;
     private String name;
     private String token;
     private Date date;
     private Date startTime;
     private Date finishTime;
     private int time;
     private Set<Subtest> subtests = new HashSet<Subtest>(0);
     private Set<Score> scores = new HashSet<Score>(0);

    public Test() {
    }

	
    public Test(String id, User user, String name, String token, Date date, Date startTime, Date finishTime, int time) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.token = token;
        this.date = date;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.time = time;
    }
    public Test(String id, User user, String name, String token, Date date, Date startTime, Date finishTime, int time, Set<Subtest> subtests, Set<Score> scores) {
       this.id = id;
       this.user = user;
       this.name = name;
       this.token = token;
       this.date = date;
       this.startTime = startTime;
       this.finishTime = finishTime;
       this.time = time;
       this.subtests = subtests;
       this.scores = scores;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=9)
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

    
    @Column(name="name", nullable=false, length=30)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="token", nullable=false, length=12)
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date", nullable=false, length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_time", nullable=false, length=19)
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="finish_time", nullable=false, length=19)
    public Date getFinishTime() {
        return this.finishTime;
    }
    
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    
    @Column(name="time", nullable=false)
    public int getTime() {
        return this.time;
    }
    
    public void setTime(int time) {
        this.time = time;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="test")
    public Set<Subtest> getSubtests() {
        return this.subtests;
    }
    
    public void setSubtests(Set<Subtest> subtests) {
        this.subtests = subtests;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="test")
    public Set<Score> getScores() {
        return this.scores;
    }
    
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }




}

