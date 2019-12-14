package com.cbtuser.entity;
// Generated Dec 14, 2019 11:23:33 PM by Hibernate Tools 4.3.1


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
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,catalog="computerbasedtest"
)
public class Role  implements java.io.Serializable {


     private Integer id;
     private String className;
     private Set<User> users = new HashSet<User>(0);

    public Role() {
    }

	
    public Role(String className) {
        this.className = className;
    }
    public Role(String className, Set<User> users) {
       this.className = className;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="class_name", nullable=false, length=30)
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}


