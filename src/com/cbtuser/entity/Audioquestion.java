package com.cbtuser.entity;
// Generated Nov 2, 2019 11:33:03 PM by Hibernate Tools 4.3.1


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
     private byte[] audio;
     private String content;
     private Set<Audansquestion> audansquestions = new HashSet<Audansquestion>(0);

    public Audioquestion() {
    }

	
    public Audioquestion(AudioquestionId id, Questiondb questiondb, Subtest subtest, byte[] audio, String content) {
        this.id = id;
        this.questiondb = questiondb;
        this.subtest = subtest;
        this.audio = audio;
        this.content = content;
    }
    public Audioquestion(AudioquestionId id, Questiondb questiondb, Subtest subtest, byte[] audio, String content, Set<Audansquestion> audansquestions) {
       this.id = id;
       this.questiondb = questiondb;
       this.subtest = subtest;
       this.audio = audio;
       this.content = content;
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

    
    @Column(name="audio", nullable=false)
    public byte[] getAudio() {
        return this.audio;
    }
    
    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    
    @Column(name="content", nullable=false, length=500)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="audioquestion")
    public Set<Audansquestion> getAudansquestions() {
        return this.audansquestions;
    }
    
    public void setAudansquestions(Set<Audansquestion> audansquestions) {
        this.audansquestions = audansquestions;
    }




}


