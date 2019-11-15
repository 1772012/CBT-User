package com.cbtuser.entity;
// Generated Nov 11, 2019 11:56:01 AM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Vidansquestion generated by hbm2java
 */
@Entity
@Table(name="vidansquestion"
    ,catalog="computerbasedtest"
    , uniqueConstraints = @UniqueConstraint(columnNames="id") 
)
public class Vidansquestion  implements java.io.Serializable {


     private VidansquestionId id;
     private Videoquestion videoquestion;
     private String trueAnswer;
     private String content;

    public Vidansquestion() {
    }

    public Vidansquestion(VidansquestionId id, Videoquestion videoquestion, String trueAnswer, String content) {
       this.id = id;
       this.videoquestion = videoquestion;
       this.trueAnswer = trueAnswer;
       this.content = content;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", unique=true, nullable=false) ), 
        @AttributeOverride(name="videoQuestionId", column=@Column(name="VideoQuestion_id", nullable=false, length=10) ), 
        @AttributeOverride(name="videoQuestionSubTestDatabaseId", column=@Column(name="VideoQuestion_SubTestDatabase_id", nullable=false, length=8) ) } )
    public VidansquestionId getId() {
        return this.id;
    }
    
    public void setId(VidansquestionId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="VideoQuestion_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="VideoQuestion_SubTestDatabase_id", referencedColumnName="SubTestDatabase_id", nullable=false, insertable=false, updatable=false) } )
    public Videoquestion getVideoquestion() {
        return this.videoquestion;
    }
    
    public void setVideoquestion(Videoquestion videoquestion) {
        this.videoquestion = videoquestion;
    }

    
    @Column(name="true_answer", nullable=false, length=45)
    public String getTrueAnswer() {
        return this.trueAnswer;
    }
    
    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    
    @Column(name="content", nullable=false, length=500)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }




}


