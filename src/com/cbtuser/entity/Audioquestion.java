package com.cbtuser.entity;
// Generated Oct 19, 2019 10:48:39 AM by Hibernate Tools 4.3.1


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
 * Audioquestion generated by hbm2java
 */
@Entity
@Table(name="audioquestion"
    ,catalog="computerbasedtest"
    , uniqueConstraints = @UniqueConstraint(columnNames="id") 
)
public class Audioquestion  implements java.io.Serializable {


     private AudioquestionId id;
     private Questiondb questiondb;
     private Subtest subtest;
     private String audio;
     private String content;
     private String trueAnswer;
     private Set<Audansquestion> audansquestions = new HashSet<Audansquestion>(0);

    public Audioquestion() {
    }

	
    public Audioquestion(AudioquestionId id, Questiondb questiondb, Subtest subtest, String audio, String content, String trueAnswer) {
        this.id = id;
        this.questiondb = questiondb;
        this.subtest = subtest;
        this.audio = audio;
        this.content = content;
        this.trueAnswer = trueAnswer;
    }
    public Audioquestion(AudioquestionId id, Questiondb questiondb, Subtest subtest, String audio, String content, String trueAnswer, Set<Audansquestion> audansquestions) {
       this.id = id;
       this.questiondb = questiondb;
       this.subtest = subtest;
       this.audio = audio;
       this.content = content;
       this.trueAnswer = trueAnswer;
       this.audansquestions = audansquestions;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", unique=true, nullable=false) ), 
        @AttributeOverride(name="questionDbId", column=@Column(name="QuestionDB_id", nullable=false, length=10) ), 
        @AttributeOverride(name="subTestId", column=@Column(name="SubTest_id", nullable=false, length=10) ) } )
    public AudioquestionId getId() {
        return this.id;
    }
    
    public void setId(AudioquestionId id) {
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

    
    @Column(name="audio", nullable=false, length=16777215)
    public String getAudio() {
        return this.audio;
    }
    
    public void setAudio(String audio) {
        this.audio = audio;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="audioquestion")
    public Set<Audansquestion> getAudansquestions() {
        return this.audansquestions;
    }
    
    public void setAudansquestions(Set<Audansquestion> audansquestions) {
        this.audansquestions = audansquestions;
    }




}


