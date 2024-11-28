package com.studentapiv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapiv2.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
