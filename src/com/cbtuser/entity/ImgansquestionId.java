package com.cbtuser.entity;
// Generated Oct 18, 2019 8:58:09 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ImgansquestionId generated by hbm2java
 */
@Embeddable
public class ImgansquestionId  implements java.io.Serializable {


     private int id;
     private int imageQuestionId;
     private String imageQuestionQuestionDbId;
     private String imageQuestionSubTestId;

    public ImgansquestionId() {
    }

    public ImgansquestionId(int id, int imageQuestionId, String imageQuestionQuestionDbId, String imageQuestionSubTestId) {
       this.id = id;
       this.imageQuestionId = imageQuestionId;
       this.imageQuestionQuestionDbId = imageQuestionQuestionDbId;
       this.imageQuestionSubTestId = imageQuestionSubTestId;
    }
   


    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="ImageQuestion_id", nullable=false)
    public int getImageQuestionId() {
        return this.imageQuestionId;
    }
    
    public void setImageQuestionId(int imageQuestionId) {
        this.imageQuestionId = imageQuestionId;
    }


    @Column(name="ImageQuestion_QuestionDB_id", nullable=false, length=10)
    public String getImageQuestionQuestionDbId() {
        return this.imageQuestionQuestionDbId;
    }
    
    public void setImageQuestionQuestionDbId(String imageQuestionQuestionDbId) {
        this.imageQuestionQuestionDbId = imageQuestionQuestionDbId;
    }


    @Column(name="ImageQuestion_SubTest_id", nullable=false, length=10)
    public String getImageQuestionSubTestId() {
        return this.imageQuestionSubTestId;
    }
    
    public void setImageQuestionSubTestId(String imageQuestionSubTestId) {
        this.imageQuestionSubTestId = imageQuestionSubTestId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ImgansquestionId) ) return false;
		 ImgansquestionId castOther = ( ImgansquestionId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getImageQuestionId()==castOther.getImageQuestionId())
 && ( (this.getImageQuestionQuestionDbId()==castOther.getImageQuestionQuestionDbId()) || ( this.getImageQuestionQuestionDbId()!=null && castOther.getImageQuestionQuestionDbId()!=null && this.getImageQuestionQuestionDbId().equals(castOther.getImageQuestionQuestionDbId()) ) )
 && ( (this.getImageQuestionSubTestId()==castOther.getImageQuestionSubTestId()) || ( this.getImageQuestionSubTestId()!=null && castOther.getImageQuestionSubTestId()!=null && this.getImageQuestionSubTestId().equals(castOther.getImageQuestionSubTestId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getImageQuestionId();
         result = 37 * result + ( getImageQuestionQuestionDbId() == null ? 0 : this.getImageQuestionQuestionDbId().hashCode() );
         result = 37 * result + ( getImageQuestionSubTestId() == null ? 0 : this.getImageQuestionSubTestId().hashCode() );
         return result;
   }   


}


