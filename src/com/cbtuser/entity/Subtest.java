package com.cbtuser.entity;
// Generated Nov 15, 2019 8:43:31 AM by Hibernate Tools 4.3.1


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

/**
 * Subtest generated by hbm2java
 */
@Entity
@Table(name="subtest"
    ,catalog="computerbasedtest"
)
public class Subtest  implements java.io.Serializable {


     private String id;
     private Subtestdatabase subtestdatabase;
     private Test test;
     private String name;
     private int amount;
     private Set<Score> scores = new HashSet<Score>(0);

    public Subtest() {
    }

	
    public Subtest(String id, Subtestdatabase subtestdatabase, Test test, String name, int amount) {
        this.id = id;
        this.subtestdatabase = subtestdatabase;
        this.test = test;
        this.name = name;
        this.amount = amount;
    }
    public Subtest(String id, Subtestdatabase subtestdatabase, Test test, String name, int amount, Set<Score> scores) {
       this.id = id;
       this.subtestdatabase = subtestdatabase;
       this.test = test;
       this.name = name;
       this.amount = amount;
       this.scores = scores;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=8)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SubTestDatabase_id", nullable=false)
    public Subtestdatabase getSubtestdatabase() {
        return this.subtestdatabase;
    }
    
    public void setSubtestdatabase(Subtestdatabase subtestdatabase) {
        this.subtestdatabase = subtestdatabase;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Test_id", nullable=false)
    public Test getTest() {
        return this.test;
    }
    
    public void setTest(Test test) {
        this.test = test;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="amount", nullable=false)
    public int getAmount() {
        return this.amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="subtest")
    public Set<Score> getScores() {
        return this.scores;
    }
    
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }




}


