package com.studentapiv3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapiv3.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
