package com.cbtuser.entity;
// Generated Oct 18, 2019 8:58:09 AM by Hibernate Tools 4.3.1


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
 * Test generated by hbm2java
 */
@Entity
@Table(name="test"
    ,catalog="computerbasedtest"
)
public class Test  implements java.io.Serializable {


     private String id;
     private Questionmaker questionmaker;
     private String name;
     private Set<Subtest> subtests = new HashSet<Subtest>(0);

    public Test() {
    }

	
    public Test(String id, Questionmaker questionmaker, String name) {
        this.id = id;
        this.questionmaker = questionmaker;
        this.name = name;
    }
    public Test(String id, Questionmaker questionmaker, String name, Set<Subtest> subtests) {
       this.id = id;
       this.questionmaker = questionmaker;
       this.name = name;
       this.subtests = subtests;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=10)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="QuestionMaker_id", nullable=false)
    public Questionmaker getQuestionmaker() {
        return this.questionmaker;
    }
    
    public void setQuestionmaker(Questionmaker questionmaker) {
        this.questionmaker = questionmaker;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="test")
    public Set<Subtest> getSubtests() {
        return this.subtests;
    }
    
    public void setSubtests(Set<Subtest> subtests) {
        this.subtests = subtests;
    }




}


