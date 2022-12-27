package com.azra.student.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByEmail(String email) {
     return studentRepository.findStudentByEmail(email).get();
    }

    public Student getStudentById(String id) {
        return studentRepository.findStudentById(id).get();
    }

    public void addStudent(Student student) {
        studentRepository.insert(student);
    }

    public void updateStudent(Student student, String id) {
        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.delete(studentRepository.findById(id).get());
    }
}
