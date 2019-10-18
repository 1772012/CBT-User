package com.cbtuser.entity;
// Generated Oct 18, 2019 8:58:09 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Questiondb generated by hbm2java
 */
@Entity
@Table(name="questiondb"
    ,catalog="computerbasedtest"
)
public class Questiondb  implements java.io.Serializable {


     private String id;
     private String name;
     private Set<Audioquestion> audioquestions = new HashSet<Audioquestion>(0);
     private Set<Videoquestion> videoquestions = new HashSet<Videoquestion>(0);
     private Set<Imagequestion> imagequestions = new HashSet<Imagequestion>(0);
     private Set<Normalquestion> normalquestions = new HashSet<Normalquestion>(0);

    public Questiondb() {
    }

	
    public Questiondb(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Questiondb(String id, String name, Set<Audioquestion> audioquestions, Set<Videoquestion> videoquestions, Set<Imagequestion> imagequestions, Set<Normalquestion> normalquestions) {
       this.id = id;
       this.name = name;
       this.audioquestions = audioquestions;
       this.videoquestions = videoquestions;
       this.imagequestions = imagequestions;
       this.normalquestions = normalquestions;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=10)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="questiondb")
    public Set<Audioquestion> getAudioquestions() {
        return this.audioquestions;
    }
    
    public void setAudioquestions(Set<Audioquestion> audioquestions) {
        this.audioquestions = audioquestions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="questiondb")
    public Set<Videoquestion> getVideoquestions() {
        return this.videoquestions;
    }
    
    public void setVideoquestions(Set<Videoquestion> videoquestions) {
        this.videoquestions = videoquestions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="questiondb")
    public Set<Imagequestion> getImagequestions() {
        return this.imagequestions;
    }
    
    public void setImagequestions(Set<Imagequestion> imagequestions) {
        this.imagequestions = imagequestions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="questiondb")
    public Set<Normalquestion> getNormalquestions() {
        return this.normalquestions;
    }
    
    public void setNormalquestions(Set<Normalquestion> normalquestions) {
        this.normalquestions = normalquestions;
    }




}

