/***
 * Project Name:StudentData
 */
package com.ust.training.studentdata.Exception;

/**
 * 
 * Exception handling class
 * 
 * @author Akhila
 *
 */
public class StudentServiceException extends RuntimeException {
  private static final long serialVersionUID = 2853146757927156650L;
/**
 * 
 *StudentServiceException  constructor takes one parameter message
 * @param message
 */
  public StudentServiceException(String message) {
    super(message);
  }
/**
 * StudentServiceException constructor  takes 2 parameters
 * 
 * @param message
 * @param throwable
 */
  public StudentServiceException(String message, Throwable throwable) {
    super(message, throwable);
  }
}


