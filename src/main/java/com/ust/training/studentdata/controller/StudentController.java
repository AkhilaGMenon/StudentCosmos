/***
 * 
 * Project Name :StudentData
 * 
 */

package com.ust.training.studentdata.controller;

import javax.ws.rs.HttpMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.training.studentdata.StudentDataApplication;
import com.ust.training.studentdata.annotation.SwaggerToken;
import com.ust.training.studentdata.common.StudentDTO;
import com.ust.training.studentdata.model.Student;
import com.ust.training.studentdata.service.StudentService;

import io.swagger.annotations.ApiOperation;

/**
 * StudentController is a controller class which contains post delete and get methods mapping
 * methods
 * 
 * @author Akhila
 *
 */
@RestController
public class StudentController {

  @Autowired
  StudentService studentService;
  public static final Logger log = LoggerFactory.getLogger(StudentDataApplication.class);

  /***
   * PostMapping adds a new student and save the detail
   * 
   * @param studentDTO
   * @return ResponseEntity of student
   */

  @PostMapping
  @SwaggerToken
  @ApiOperation(value = "Adding new student and save student detail",
      notes = "Returns 200 OK/204 NO_CONTENT", httpMethod = HttpMethod.POST)

  public ResponseEntity<Student> addStudentDetails(@RequestBody StudentDTO studentDTO) {

    log.debug("Begining the Post operation");
    Student detail = studentService.saveStudentDetails(studentDTO);
    if (null != detail) {
      log.info("Status:200  Response:", detail);
      return new ResponseEntity<Student>(HttpStatus.CREATED);
    } else {
      log.info("Status:204");
      log.debug("Ending of post operation");
      return ResponseEntity.noContent().build();
    }

  }

  /***
   * DeleteMapping deleting an existing student
   * 
   * @param id
   * @return ResponseEntity of student
   */

  @DeleteMapping("/{id}")
  @SwaggerToken
  @ApiOperation(value = "Deleting student by id", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.DELETE)

  public ResponseEntity<String> deleteStudent(@PathVariable("id") String id) {

    log.debug("Begining the Delete operation");
    log.debug("Ending the Delete operation");
    String details = studentService.deleteStudentDetails(id);
    return ResponseEntity.ok(details);
  }

  /***
   * GetMapping for getting a student with a particular id
   * 
   * @param id
   * @return ResponseEntity of studentDTO
   */

  @GetMapping("/{id}")

  @SwaggerToken
  @ApiOperation(value = "Getting student by id", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.GET)

  public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") String id) {

    log.debug("Begining the Get operation");
    StudentDTO details = studentService.getStudentDetails(id);
    if (null != details) {
      log.debug("Status:200 id:" + id + " Response:", details);
      return ResponseEntity.ok(details);
    } else {
      log.debug("Ending of get operation");
      log.info("Status:204 id:", id);
      return ResponseEntity.noContent().build();
    }

  }

}
