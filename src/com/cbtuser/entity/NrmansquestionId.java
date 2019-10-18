package com.cbtuser.entity;
// Generated Oct 18, 2019 8:58:09 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NrmansquestionId generated by hbm2java
 */
@Embeddable
public class NrmansquestionId  implements java.io.Serializable {


     private int id;
     private int normalQuestionId;
     private String normalQuestionQuestionDbId;
     private String normalQuestionSubTestId;

    public NrmansquestionId() {
    }

    public NrmansquestionId(int id, int normalQuestionId, String normalQuestionQuestionDbId, String normalQuestionSubTestId) {
       this.id = id;
       this.normalQuestionId = normalQuestionId;
       this.normalQuestionQuestionDbId = normalQuestionQuestionDbId;
       this.normalQuestionSubTestId = normalQuestionSubTestId;
    }
   


    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="NormalQuestion_id", nullable=false)
    public int getNormalQuestionId() {
        return this.normalQuestionId;
    }
    
    public void setNormalQuestionId(int normalQuestionId) {
        this.normalQuestionId = normalQuestionId;
    }


    @Column(name="NormalQuestion_QuestionDB_id", nullable=false, length=10)
    public String getNormalQuestionQuestionDbId() {
        return this.normalQuestionQuestionDbId;
    }
    
    public void setNormalQuestionQuestionDbId(String normalQuestionQuestionDbId) {
        this.normalQuestionQuestionDbId = normalQuestionQuestionDbId;
    }


    @Column(name="NormalQuestion_SubTest_id", nullable=false, length=10)
    public String getNormalQuestionSubTestId() {
        return this.normalQuestionSubTestId;
    }
    
    public void setNormalQuestionSubTestId(String normalQuestionSubTestId) {
        this.normalQuestionSubTestId = normalQuestionSubTestId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NrmansquestionId) ) return false;
		 NrmansquestionId castOther = ( NrmansquestionId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getNormalQuestionId()==castOther.getNormalQuestionId())
 && ( (this.getNormalQuestionQuestionDbId()==castOther.getNormalQuestionQuestionDbId()) || ( this.getNormalQuestionQuestionDbId()!=null && castOther.getNormalQuestionQuestionDbId()!=null && this.getNormalQuestionQuestionDbId().equals(castOther.getNormalQuestionQuestionDbId()) ) )
 && ( (this.getNormalQuestionSubTestId()==castOther.getNormalQuestionSubTestId()) || ( this.getNormalQuestionSubTestId()!=null && castOther.getNormalQuestionSubTestId()!=null && this.getNormalQuestionSubTestId().equals(castOther.getNormalQuestionSubTestId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getNormalQuestionId();
         result = 37 * result + ( getNormalQuestionQuestionDbId() == null ? 0 : this.getNormalQuestionQuestionDbId().hashCode() );
         result = 37 * result + ( getNormalQuestionSubTestId() == null ? 0 : this.getNormalQuestionSubTestId().hashCode() );
         return result;
   }   


}


