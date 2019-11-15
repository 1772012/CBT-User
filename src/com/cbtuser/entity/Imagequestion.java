package com.cbtuser.entity;
// Generated Nov 11, 2019 11:56:01 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Imagequestion generated by hbm2java
 */
@Entity
@Table(name="imagequestion"
    ,catalog="computerbasedtest"
    , uniqueConstraints = @UniqueConstraint(columnNames="id") 
)
public class Imagequestion  implements java.io.Serializable {


     private ImagequestionId id;
     private Subtestdatabase subtestdatabase;
     private byte[] image;
     private String content;
     private Set<Imgansquestion> imgansquestions = new HashSet<Imgansquestion>(0);

    public Imagequestion() {
    }

	
    public Imagequestion(ImagequestionId id, Subtestdatabase subtestdatabase, byte[] image, String content) {
        this.id = id;
        this.subtestdatabase = subtestdatabase;
        this.image = image;
        this.content = content;
    }
    public Imagequestion(ImagequestionId id, Subtestdatabase subtestdatabase, byte[] image, String content, Set<Imgansquestion> imgansquestions) {
       this.id = id;
       this.subtestdatabase = subtestdatabase;
       this.image = image;
       this.content = content;
       this.imgansquestions = imgansquestions;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", unique=true, nullable=false, length=10) ), 
        @AttributeOverride(name="subTestDatabaseId", column=@Column(name="SubTestDatabase_id", nullable=false, length=8) ) } )
    public ImagequestionId getId() {
        return this.id;
    }
    
    public void setId(ImagequestionId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SubTestDatabase_id", nullable=false, insertable=false, updatable=false)
    public Subtestdatabase getSubtestdatabase() {
        return this.subtestdatabase;
    }
    
    public void setSubtestdatabase(Subtestdatabase subtestdatabase) {
        this.subtestdatabase = subtestdatabase;
    }

    
    @Column(name="image", nullable=false)
    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }

    
    @Column(name="content", nullable=false, length=500)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="imagequestion")
    public Set<Imgansquestion> getImgansquestions() {
        return this.imgansquestions;
    }
    
    public void setImgansquestions(Set<Imgansquestion> imgansquestions) {
        this.imgansquestions = imgansquestions;
    }




}


