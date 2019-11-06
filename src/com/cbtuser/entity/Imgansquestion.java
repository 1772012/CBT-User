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
 * Imgansquestion generated by hbm2java
 */
@Entity
@Table(name="imgansquestion"
    ,catalog="computerbasedtest"
    , uniqueConstraints = @UniqueConstraint(columnNames="id") 
)
public class Imgansquestion  implements java.io.Serializable {


     private ImgansquestionId id;
     private Imagequestion imagequestion;
     private String trueAnswer;
     private String content;

    public Imgansquestion() {
    }

    public Imgansquestion(ImgansquestionId id, Imagequestion imagequestion, String trueAnswer, String content) {
       this.id = id;
       this.imagequestion = imagequestion;
       this.trueAnswer = trueAnswer;
       this.content = content;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", unique=true, nullable=false) ), 
        @AttributeOverride(name="imageQuestionId", column=@Column(name="ImageQuestion_id", nullable=false, length=10) ), 
        @AttributeOverride(name="imageQuestionSubTestDatabaseId", column=@Column(name="ImageQuestion_SubTestDatabase_id", nullable=false, length=8) ) } )
    public ImgansquestionId getId() {
        return this.id;
    }
    
    public void setId(ImgansquestionId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="ImageQuestion_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ImageQuestion_SubTestDatabase_id", referencedColumnName="SubTestDatabase_id", nullable=false, insertable=false, updatable=false) } )
    public Imagequestion getImagequestion() {
        return this.imagequestion;
    }
    
    public void setImagequestion(Imagequestion imagequestion) {
        this.imagequestion = imagequestion;
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


