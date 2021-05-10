package com.example.mySpringProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// @Repository This tells Spring to bootstrap the repository during component scan.
// we will now be able to use JpaRepository’s methods like save(), findOne(), findAll(), count(), delete() etc.
// We don’t need to implement these methods.
// They will be already implemented by Spring Data JPA’s SimpleJpaRepository.
// This implementation is plugged in by Spring automatically at runtime.
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
}
