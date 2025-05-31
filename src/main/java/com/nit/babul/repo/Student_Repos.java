package com.nit.babul.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.babul.entity.Student;
import java.util.List;


public interface Student_Repos extends JpaRepository<Student, Integer>{
	public Student  findById(int id);

}
