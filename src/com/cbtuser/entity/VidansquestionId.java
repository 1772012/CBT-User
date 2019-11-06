package com.cbtuser.entity;
// Generated Nov 6, 2019 10:33:04 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VidansquestionId generated by hbm2java
 */
@Embeddable
public class VidansquestionId  implements java.io.Serializable {


     private int id;
     private String videoQuestionId;
     private String videoQuestionSubTestDatabaseId;

    public VidansquestionId() {
    }

    public VidansquestionId(int id, String videoQuestionId, String videoQuestionSubTestDatabaseId) {
       this.id = id;
       this.videoQuestionId = videoQuestionId;
       this.videoQuestionSubTestDatabaseId = videoQuestionSubTestDatabaseId;
    }
   


    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="VideoQuestion_id", nullable=false, length=10)
    public String getVideoQuestionId() {
        return this.videoQuestionId;
    }
    
    public void setVideoQuestionId(String videoQuestionId) {
        this.videoQuestionId = videoQuestionId;
    }


    @Column(name="VideoQuestion_SubTestDatabase_id", nullable=false, length=10)
    public String getVideoQuestionSubTestDatabaseId() {
        return this.videoQuestionSubTestDatabaseId;
    }
    
    public void setVideoQuestionSubTestDatabaseId(String videoQuestionSubTestDatabaseId) {
        this.videoQuestionSubTestDatabaseId = videoQuestionSubTestDatabaseId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VidansquestionId) ) return false;
		 VidansquestionId castOther = ( VidansquestionId ) other; 
         
		 return (this.getId()==castOther.getId())
 && ( (this.getVideoQuestionId()==castOther.getVideoQuestionId()) || ( this.getVideoQuestionId()!=null && castOther.getVideoQuestionId()!=null && this.getVideoQuestionId().equals(castOther.getVideoQuestionId()) ) )
 && ( (this.getVideoQuestionSubTestDatabaseId()==castOther.getVideoQuestionSubTestDatabaseId()) || ( this.getVideoQuestionSubTestDatabaseId()!=null && castOther.getVideoQuestionSubTestDatabaseId()!=null && this.getVideoQuestionSubTestDatabaseId().equals(castOther.getVideoQuestionSubTestDatabaseId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + ( getVideoQuestionId() == null ? 0 : this.getVideoQuestionId().hashCode() );
         result = 37 * result + ( getVideoQuestionSubTestDatabaseId() == null ? 0 : this.getVideoQuestionSubTestDatabaseId().hashCode() );
         return result;
   }   


}


