/***
 * 
 * Project Name :StudentData
 * 
 */
package com.ust.training.studentdata.service;

import com.ust.training.studentdata.model.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ust.training.studentdata.StudentDataApplication;
import com.ust.training.studentdata.Exception.StudentServiceException;
import com.ust.training.studentdata.common.StudentDTO;
import com.ust.training.studentdata.repo.StudentRepo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;



/**
 * 
 * @author Akhila
 *
 */
@Service

@Slf4j
public class StudentService {
  @Autowired
  private StudentRepo repository;
  private static final Logger log = LoggerFactory.getLogger(StudentDataApplication.class);

  /***
   * 
   * Save student details
   * 
   * @param studentDTO
   * @return
   */
  public String saveStudentDetails(StudentDTO studentDTO) {

    Student details = new Student();
    details.setId(studentDTO.getId());
    details.setFirstName(studentDTO.getFirstName());
    details.setLastName(studentDTO.getLastName());
    details.setAddress(studentDTO.getAddress());

    log.debug("Saving studentDetails: {}", details);

    // Save the User class to Azure CosmosDB database.
    Mono<Student> saveStudent = repository.save(details);

    // Nothing happens until we subscribe to these Monos.
    Student savedStudent = saveStudent.block();
    log.debug("Saved StudentDetails");

    return "Save Success";
  }

  /***
   * 
   * 
   * @param id
   * @return student obj
   */

  public Student getStudentDetails(String id) {
    log.debug("inside get method");
    try {
      Mono<Student> findByIdStudent = repository.findById(id);
      Student findStudentById = findByIdStudent.block();

      return findStudentById;

    } catch (Exception e) {
      log.error("Exception:", e);
      throw new StudentServiceException("Exception in getStudentDetails", e);
    }

  }

  /***
   *
   * Delete a particular student based on id
   * 
   * @param id
   * @return String
   */
  public String deleteStudentDetails(String id) {
    log.debug("inside delete method");
    try {
      Mono<Student> findByIdStudent = repository.findById(id);
      Student findStudentById = findByIdStudent.block();
      repository.delete(findStudentById).block();

    } catch (Exception e) {
      log.error("Exception:", e);
      throw new StudentServiceException("Exception in DeleteStudentDetails", e);
    }
    return "Deleted";
  }

  /***
   * updating the details of student
   * 
   * @param student
   * @return student object
   */

  public Student updateStudent(StudentDTO studentDTO) {
    Student savedStudent = null;
    try {
      log.debug("inside update student");
      Student studentDetails = new Student();
      Mono<Student> findByIdStudent = repository.findById(studentDTO.getId());
      Student student = findByIdStudent.block();

      repository.delete(student).block();

      studentDetails.setId(studentDTO.getId());

      studentDetails.setFirstName(studentDTO.getFirstName());

      studentDetails.setLastName(studentDTO.getLastName());

      studentDetails.setAddress(studentDTO.getAddress());

      Mono<Student> saveStudent = repository.save(student);

      savedStudent = saveStudent.block();

      return savedStudent;
      
    } catch (Exception exception) {
      log.error("Exception:", exception);
      throw new StudentServiceException("Exception in Saving a Student", exception);
    }

  }
}


