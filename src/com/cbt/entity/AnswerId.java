package com.cbt.entity;
// Generated Jan 18, 2020 5:56:25 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AnswerId generated by hbm2java
 */
@Embeddable
public class AnswerId  implements java.io.Serializable {


     private String id;
     private String questionId;

    public AnswerId() {
    }

    public AnswerId(String id, String questionId) {
       this.id = id;
       this.questionId = questionId;
    }
   


    @Column(name="id", unique=true, nullable=false, length=12)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }


    @Column(name="Question_id", nullable=false, length=12)
    public String getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AnswerId) ) return false;
		 AnswerId castOther = ( AnswerId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getQuestionId()==castOther.getQuestionId()) || ( this.getQuestionId()!=null && castOther.getQuestionId()!=null && this.getQuestionId().equals(castOther.getQuestionId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getQuestionId() == null ? 0 : this.getQuestionId().hashCode() );
         return result;
   }   


}


