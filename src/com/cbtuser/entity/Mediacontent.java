package com.cbtuser.entity;
// Generated Dec 12, 2019 10:33:59 AM by Hibernate Tools 4.3.1


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
 * Mediacontent generated by hbm2java
 */
@Entity
@Table(name="mediacontent"
    ,catalog="computerbasedtest"
)
public class Mediacontent  implements java.io.Serializable {


     private String id;
     private Media media;
     private String mediaAddress;
     private String caption;
     private Set<Question> questions = new HashSet<Question>(0);

    public Mediacontent() {
    }

	
    public Mediacontent(String id, Media media) {
        this.id = id;
        this.media = media;
    }
    public Mediacontent(String id, Media media, String mediaAddress, String caption, Set<Question> questions) {
       this.id = id;
       this.media = media;
       this.mediaAddress = mediaAddress;
       this.caption = caption;
       this.questions = questions;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=12)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Media_id", nullable=false)
    public Media getMedia() {
        return this.media;
    }
    
    public void setMedia(Media media) {
        this.media = media;
    }

    
    @Column(name="media_address", length=200)
    public String getMediaAddress() {
        return this.mediaAddress;
    }
    
    public void setMediaAddress(String mediaAddress) {
        this.mediaAddress = mediaAddress;
    }

    
    @Column(name="caption", length=16777215)
    public String getCaption() {
        return this.caption;
    }
    
    public void setCaption(String caption) {
        this.caption = caption;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mediacontent")
    public Set<Question> getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }




}


