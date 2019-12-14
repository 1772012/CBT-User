package com.cbtuser.entity;
// Generated Dec 14, 2019 11:23:33 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Answer generated by hbm2java
 */
@Entity
@Table(name="answer"
    ,catalog="computerbasedtest"
    , uniqueConstraints = @UniqueConstraint(columnNames="id") 
)
public class Answer  implements java.io.Serializable {


     private AnswerId id;
     private Question question;
     private byte trueAnswer;
     private String content;

    public Answer() {
    }

    public Answer(AnswerId id, Question question, byte trueAnswer, String content) {
       this.id = id;
       this.question = question;
       this.trueAnswer = trueAnswer;
       this.content = content;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", unique=true, nullable=false, length=12) ), 
        @AttributeOverride(name="questionId", column=@Column(name="Question_id", nullable=false, length=12) ) } )
    public AnswerId getId() {
        return this.id;
    }
    
    public void setId(AnswerId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Question_id", nullable=false, insertable=false, updatable=false)
    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    
    @Column(name="true_answer", nullable=false)
    public byte getTrueAnswer() {
        return this.trueAnswer;
    }
    
    public void setTrueAnswer(byte trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    
    @Column(name="content", nullable=false, length=200)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }




}


