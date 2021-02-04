package com.example.dbtest.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbtest.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
