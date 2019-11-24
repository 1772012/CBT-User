package com.cbtuser.entity;
// Generated Nov 24, 2019 3:56:55 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Media generated by hbm2java
 */
@Entity
@Table(name="media"
    ,catalog="computerbasedtest"
)
public class Media  implements java.io.Serializable {


     private Integer id;
     private String mediaType;
     private Set<Mediacontent> mediacontents = new HashSet<Mediacontent>(0);

    public Media() {
    }

	
    public Media(String mediaType) {
        this.mediaType = mediaType;
    }
    public Media(String mediaType, Set<Mediacontent> mediacontents) {
       this.mediaType = mediaType;
       this.mediacontents = mediacontents;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="media_type", nullable=false, length=30)
    public String getMediaType() {
        return this.mediaType;
    }
    
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="media")
    public Set<Mediacontent> getMediacontents() {
        return this.mediacontents;
    }
    
    public void setMediacontents(Set<Mediacontent> mediacontents) {
        this.mediacontents = mediacontents;
    }




}

