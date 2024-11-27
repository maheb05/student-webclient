package com.studentapiv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapiv1.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
