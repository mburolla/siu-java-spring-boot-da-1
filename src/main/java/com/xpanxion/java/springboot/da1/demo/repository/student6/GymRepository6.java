package com.xpanxion.java.springboot.da1.demo.repository.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Gym6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository6 extends JpaRepository<Gym6, Integer> {

   //org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'gymController6':
   // Unsatisfied dependency expressed through field 'gymService6'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException:
   // Error creating bean with name 'gymService6': Unsatisfied dependency expressed through field 'gymRepository6';
   // nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'gymRepository6'
   // defined in com.xpanxion.java.springboot.da1.demo.repository.student6.GymRepository6 defined in @EnableJpaRepositories declared on
   // JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Invocation of init method failed; nested exception
   // is org.springframework.data.repository.query.QueryCreationException: Could not create query for
   // public abstract com.xpanxion.java.springboot.da1.demo.model.student6.Gym6 com.xpanxion.java.springboot.da1.demo.repository.student6.GymRepository6.findByName(java.lang.String)!
   // Reason: JDBC style parameters (?) are not supported for JPA queries.; nested exception is java.lang.IllegalArgumentException:
   // JDBC style parameters (?) are not supported for JPA queries.

   //@Query("select g from Gym6 where g.name = ?")
   //Gym6 findByName(String name);
}
