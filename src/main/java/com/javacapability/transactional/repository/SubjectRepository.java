package com.javacapability.transactional.repository;

import com.javacapability.transactional.entity.Student;
import com.javacapability.transactional.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects, Long> {
}
