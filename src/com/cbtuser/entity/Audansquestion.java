package com.cbtuser.entity;
// Generated Nov 6, 2019 10:33:04 PM by Hibernate Tools 4.3.1


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
 * Audansquestion generated by hbm2java
 */
@Entity
@Table(name="audansquestion"
    ,catalog="computerbasedtest"
    , uniqueConstraints = @UniqueConstraint(columnNames="id") 
)
public class Audansquestion  implements java.io.Serializable {


     private AudansquestionId id;
     private Audioquestion audioquestion;
     private byte trueAnswer;
     private String content;

    public Audansquestion() {
    }

    public Audansquestion(AudansquestionId id, Audioquestion audioquestion, byte trueAnswer, String content) {
       this.id = id;
       this.audioquestion = audioquestion;
       this.trueAnswer = trueAnswer;
       this.content = content;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", unique=true, nullable=false) ), 
        @AttributeOverride(name="audioQuestionId", column=@Column(name="AudioQuestion_id", nullable=false, length=10) ), 
        @AttributeOverride(name="audioQuestionSubTestDatabaseId", column=@Column(name="AudioQuestion_SubTestDatabase_id", nullable=false, length=10) ) } )
    public AudansquestionId getId() {
        return this.id;
    }
    
    public void setId(AudansquestionId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="AudioQuestion_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="AudioQuestion_SubTestDatabase_id", referencedColumnName="SubTestDatabase_id", nullable=false, insertable=false, updatable=false) } )
    public Audioquestion getAudioquestion() {
        return this.audioquestion;
    }
    
    public void setAudioquestion(Audioquestion audioquestion) {
        this.audioquestion = audioquestion;
    }

    
    @Column(name="true_answer", nullable=false)
    public byte getTrueAnswer() {
        return this.trueAnswer;
    }
    
    public void setTrueAnswer(byte trueAnswer) {
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


