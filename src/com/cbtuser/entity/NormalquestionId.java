package com.cbtuser.entity;
// Generated Nov 8, 2019 8:58:55 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NormalquestionId generated by hbm2java
 */
@Embeddable
public class NormalquestionId  implements java.io.Serializable {


     private String id;
     private String subTestDatabaseId;

    public NormalquestionId() {
    }

    public NormalquestionId(String id, String subTestDatabaseId) {
       this.id = id;
       this.subTestDatabaseId = subTestDatabaseId;
    }
   


    @Column(name="id", unique=true, nullable=false, length=10)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }


    @Column(name="SubTestDatabase_id", nullable=false, length=8)
    public String getSubTestDatabaseId() {
        return this.subTestDatabaseId;
    }
    
    public void setSubTestDatabaseId(String subTestDatabaseId) {
        this.subTestDatabaseId = subTestDatabaseId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NormalquestionId) ) return false;
		 NormalquestionId castOther = ( NormalquestionId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getSubTestDatabaseId()==castOther.getSubTestDatabaseId()) || ( this.getSubTestDatabaseId()!=null && castOther.getSubTestDatabaseId()!=null && this.getSubTestDatabaseId().equals(castOther.getSubTestDatabaseId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getSubTestDatabaseId() == null ? 0 : this.getSubTestDatabaseId().hashCode() );
         return result;
   }   


}


