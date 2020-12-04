/***
 * 
 * Project Name :StudentData
 * 
 */
package com.ust.training.studentdata.controller;

import javax.ws.rs.HttpMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
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
import lombok.extern.slf4j.Slf4j;

/**
 * StudentController is a controller class which contains post delete and get methods mapping
 * methods
 * 
 * @author Akhila
 *
 */
@RestController

@Slf4j
public class StudentController {

  @Autowired
  StudentService studentService;
  public static final Logger log = LoggerFactory.getLogger(StudentDataApplication.class);

  /***
   * PostMapping adds a new student and save the detail
   * 
   * @param studentDTO
   * @return
   */

  @PostMapping("/student")
  @SwaggerToken
  @ApiOperation(value = "Adding new student and save student detail",
      notes = "Returns 200 OK/204 NO_CONTENT", httpMethod = HttpMethod.POST)
  public ResponseEntity<Student> addStudentDetails(@RequestBody StudentDTO studentDTO) {

    Student student = new Student();

    BeanUtils.copyProperties(studentDTO, student);
    String detail = studentService.saveStudentDetails(studentDTO);
    if (null != detail) {
      log.info("Status:200  Response:", detail);
      return new ResponseEntity<Student>(HttpStatus.CREATED);
    } else {
      log.error("Status:204");
      return ResponseEntity.noContent().build();
    }
  }

  /***
   * DeleteMapping deleting an existing student
   * 
   * @param id
   * @return
   */

  @DeleteMapping("/student/{id}")
  @SwaggerToken
  @ApiOperation(value = "Deleting student by id", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.DELETE)
  public ResponseEntity<Student> deleteStudent(@PathVariable("id") String id) {
    Student details = studentService.getStudentDetails(id);
    if (null != details) {
      studentService.deleteStudentDetails(id);
      log.info("Status:200 deleted id:" + id + " Response:", details);
      return ResponseEntity.ok(details);
    } else {
      log.error("Status:204 id:", id);
      return ResponseEntity.noContent().build();
    }
  }

  /***
   * GetMapping for getting a student with a particular id
   * 
   * @param id
   * @return
   */

  @GetMapping("/student/{id}")

  @SwaggerToken
  @ApiOperation(value = "Getting student by id", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.GET)

  public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {
    Student details = studentService.getStudentDetails(id);
    if (null != details) {
      log.info("Status:200 id:" + id + " Response:", details);
      return ResponseEntity.ok(details);
    } else {
      log.error("Status:204 id:", id);
      return ResponseEntity.noContent().build();
    }
  }

}
