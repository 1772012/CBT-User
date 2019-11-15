package com.cbtuser.entity;
// Generated Nov 11, 2019 11:56:01 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Testmakerlog generated by hbm2java
 */
@Entity
@Table(name="testmakerlog"
    ,catalog="computerbasedtest"
)
public class Testmakerlog  implements java.io.Serializable {


     private String id;
     private Testmaker testmaker;
     private String logname;

    public Testmakerlog() {
    }

    public Testmakerlog(String id, Testmaker testmaker, String logname) {
       this.id = id;
       this.testmaker = testmaker;
       this.logname = logname;
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
    @JoinColumn(name="TestMaker_id", nullable=false)
    public Testmaker getTestmaker() {
        return this.testmaker;
    }
    
    public void setTestmaker(Testmaker testmaker) {
        this.testmaker = testmaker;
    }

    
    @Column(name="logname", nullable=false, length=100)
    public String getLogname() {
        return this.logname;
    }
    
    public void setLogname(String logname) {
        this.logname = logname;
    }




}


