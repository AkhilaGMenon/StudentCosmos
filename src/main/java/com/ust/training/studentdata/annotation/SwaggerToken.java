/***
 * Project Name:StudentData
 */
package com.ust.training.studentdata.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * Swagger Token
 * 
 * @author Akhila
 *
 */
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
    @ApiImplicitParam(name = HttpHeaders.CONTENT_TYPE, value = "Content-Type", dataType = "String",
        paramType = "header"),
    @ApiImplicitParam(name = HttpHeaders.ACCEPT_LANGUAGE, value = "Accept-Language",
        dataType = "String", paramType = "header"),})
@ApiResponses(value = {
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Resource fetched successfully"),
    @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Resource created successfully"),
    @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Resource Not found"),
    @ApiResponse(code = HttpServletResponse.SC_CONFLICT, message = "Conflict"),
    @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
        message = "Server error ...check Logs")})
public @interface SwaggerToken {

}
