package com.cbtuser.entity;
// Generated Oct 18, 2019 8:58:09 AM by Hibernate Tools 4.3.1


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
     private Questiondb questiondb;
     private Subtest subtest;
     private String image;
     private String content;
     private String trueAnswer;
     private Set<Imgansquestion> imgansquestions = new HashSet<Imgansquestion>(0);

    public Imagequestion() {
    }

	
    public Imagequestion(ImagequestionId id, Questiondb questiondb, Subtest subtest, String image, String content, String trueAnswer) {
        this.id = id;
        this.questiondb = questiondb;
        this.subtest = subtest;
        this.image = image;
        this.content = content;
        this.trueAnswer = trueAnswer;
    }
    public Imagequestion(ImagequestionId id, Questiondb questiondb, Subtest subtest, String image, String content, String trueAnswer, Set<Imgansquestion> imgansquestions) {
       this.id = id;
       this.questiondb = questiondb;
       this.subtest = subtest;
       this.image = image;
       this.content = content;
       this.trueAnswer = trueAnswer;
       this.imgansquestions = imgansquestions;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", unique=true, nullable=false) ), 
        @AttributeOverride(name="questionDbId", column=@Column(name="QuestionDB_id", nullable=false, length=10) ), 
        @AttributeOverride(name="subTestId", column=@Column(name="SubTest_id", nullable=false, length=10) ) } )
    public ImagequestionId getId() {
        return this.id;
    }
    
    public void setId(ImagequestionId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="QuestionDB_id", nullable=false, insertable=false, updatable=false)
    public Questiondb getQuestiondb() {
        return this.questiondb;
    }
    
    public void setQuestiondb(Questiondb questiondb) {
        this.questiondb = questiondb;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SubTest_id", nullable=false, insertable=false, updatable=false)
    public Subtest getSubtest() {
        return this.subtest;
    }
    
    public void setSubtest(Subtest subtest) {
        this.subtest = subtest;
    }

    
    @Column(name="image", nullable=false, length=16777215)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    
    @Column(name="content", nullable=false, length=500)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    
    @Column(name="true_answer", nullable=false, length=500)
    public String getTrueAnswer() {
        return this.trueAnswer;
    }
    
    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="imagequestion")
    public Set<Imgansquestion> getImgansquestions() {
        return this.imgansquestions;
    }
    
    public void setImgansquestions(Set<Imgansquestion> imgansquestions) {
        this.imgansquestions = imgansquestions;
    }




}


