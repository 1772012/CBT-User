package com.cbtuser.entity;
// Generated Nov 15, 2019 8:43:31 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AnswerId generated by hbm2java
 */
@Embeddable
public class AnswerId  implements java.io.Serializable {


     private String id;
     private String questionId;
     private String questionSubTestDatabaseId;

    public AnswerId() {
    }

    public AnswerId(String id, String questionId, String questionSubTestDatabaseId) {
       this.id = id;
       this.questionId = questionId;
       this.questionSubTestDatabaseId = questionSubTestDatabaseId;
    }
   


    @Column(name="id", unique=true, nullable=false, length=10)
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


    @Column(name="Question_SubTestDatabase_id", nullable=false, length=8)
    public String getQuestionSubTestDatabaseId() {
        return this.questionSubTestDatabaseId;
    }
    
    public void setQuestionSubTestDatabaseId(String questionSubTestDatabaseId) {
        this.questionSubTestDatabaseId = questionSubTestDatabaseId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AnswerId) ) return false;
		 AnswerId castOther = ( AnswerId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getQuestionId()==castOther.getQuestionId()) || ( this.getQuestionId()!=null && castOther.getQuestionId()!=null && this.getQuestionId().equals(castOther.getQuestionId()) ) )
 && ( (this.getQuestionSubTestDatabaseId()==castOther.getQuestionSubTestDatabaseId()) || ( this.getQuestionSubTestDatabaseId()!=null && castOther.getQuestionSubTestDatabaseId()!=null && this.getQuestionSubTestDatabaseId().equals(castOther.getQuestionSubTestDatabaseId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getQuestionId() == null ? 0 : this.getQuestionId().hashCode() );
         result = 37 * result + ( getQuestionSubTestDatabaseId() == null ? 0 : this.getQuestionSubTestDatabaseId().hashCode() );
         return result;
   }   


}


