package com.cbtuser.entity;
// Generated Oct 18, 2019 8:58:09 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ImagequestionId generated by hbm2java
 */
@Embeddable
public class ImagequestionId  implements java.io.Serializable {


     private int id;
     private String questionDbId;
     private String subTestId;

    public ImagequestionId() {
    }

    public ImagequestionId(int id, String questionDbId, String subTestId) {
       this.id = id;
       this.questionDbId = questionDbId;
       this.subTestId = subTestId;
    }
   


    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="QuestionDB_id", nullable=false, length=10)
    public String getQuestionDbId() {
        return this.questionDbId;
    }
    
    public void setQuestionDbId(String questionDbId) {
        this.questionDbId = questionDbId;
    }


    @Column(name="SubTest_id", nullable=false, length=10)
    public String getSubTestId() {
        return this.subTestId;
    }
    
    public void setSubTestId(String subTestId) {
        this.subTestId = subTestId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ImagequestionId) ) return false;
		 ImagequestionId castOther = ( ImagequestionId ) other; 
         
		 return (this.getId()==castOther.getId())
 && ( (this.getQuestionDbId()==castOther.getQuestionDbId()) || ( this.getQuestionDbId()!=null && castOther.getQuestionDbId()!=null && this.getQuestionDbId().equals(castOther.getQuestionDbId()) ) )
 && ( (this.getSubTestId()==castOther.getSubTestId()) || ( this.getSubTestId()!=null && castOther.getSubTestId()!=null && this.getSubTestId().equals(castOther.getSubTestId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + ( getQuestionDbId() == null ? 0 : this.getQuestionDbId().hashCode() );
         result = 37 * result + ( getSubTestId() == null ? 0 : this.getSubTestId().hashCode() );
         return result;
   }   


}


