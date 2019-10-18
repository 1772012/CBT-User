package com.cbtuser.entity;
// Generated Oct 18, 2019 8:58:09 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ScoreId generated by hbm2java
 */
@Embeddable
public class ScoreId  implements java.io.Serializable {


     private String participantId;
     private String subTestId;

    public ScoreId() {
    }

    public ScoreId(String participantId, String subTestId) {
       this.participantId = participantId;
       this.subTestId = subTestId;
    }
   


    @Column(name="Participant_id", nullable=false, length=7)
    public String getParticipantId() {
        return this.participantId;
    }
    
    public void setParticipantId(String participantId) {
        this.participantId = participantId;
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
		 if ( !(other instanceof ScoreId) ) return false;
		 ScoreId castOther = ( ScoreId ) other; 
         
		 return ( (this.getParticipantId()==castOther.getParticipantId()) || ( this.getParticipantId()!=null && castOther.getParticipantId()!=null && this.getParticipantId().equals(castOther.getParticipantId()) ) )
 && ( (this.getSubTestId()==castOther.getSubTestId()) || ( this.getSubTestId()!=null && castOther.getSubTestId()!=null && this.getSubTestId().equals(castOther.getSubTestId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getParticipantId() == null ? 0 : this.getParticipantId().hashCode() );
         result = 37 * result + ( getSubTestId() == null ? 0 : this.getSubTestId().hashCode() );
         return result;
   }   


}


