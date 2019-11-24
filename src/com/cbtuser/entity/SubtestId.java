package com.cbtuser.entity;
// Generated Nov 24, 2019 3:56:55 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SubtestId generated by hbm2java
 */
@Embeddable
public class SubtestId  implements java.io.Serializable {


     private String id;
     private String testId;

    public SubtestId() {
    }

    public SubtestId(String id, String testId) {
       this.id = id;
       this.testId = testId;
    }
   


    @Column(name="id", unique=true, nullable=false, length=10)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }


    @Column(name="Test_id", nullable=false, length=9)
    public String getTestId() {
        return this.testId;
    }
    
    public void setTestId(String testId) {
        this.testId = testId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SubtestId) ) return false;
		 SubtestId castOther = ( SubtestId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getTestId()==castOther.getTestId()) || ( this.getTestId()!=null && castOther.getTestId()!=null && this.getTestId().equals(castOther.getTestId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getTestId() == null ? 0 : this.getTestId().hashCode() );
         return result;
   }   


}

