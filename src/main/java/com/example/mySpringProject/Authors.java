package com.example.mySpringProject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
//  To enable the fields annotated with @LastModifiedDate or @CreatedDate to be automatically populated whenever we create or update an entity.
// Also we need Enable JPA Auditing in the main application by annotating the class with @EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name, last_name, email;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    // @Temporal annotation is used with java.util.Date and java.util.Calendar classes.
    // It converts the date and time values from Java Object to compatible database type and vice versa.
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    //@LastModifiedDate
    private Date added;
}
