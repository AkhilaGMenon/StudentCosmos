/***
 * 
 * Project Name :StudentData
 * 
 */
package com.ust.training.studentdata.repo;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.ust.training.studentdata.model.Student;

/**
 * Interface for StudentRepo
 * 
 * @author Akhila
 *
 */

@Repository
public interface StudentRepo extends ReactiveCosmosRepository<Student, String> {

}
