/***
 * Project Name : StudentData
 */

package com.ust.training.studentdata.model;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import lombok.Data;

/**
 * Model class is an Object Class that represent database entities
 * 
 * @author Akhila
 *
 */
@Document(collection = "studentDB")
@Data

public class Student {
  @Id
  private String id;
  private String firstName;

  @PartitionKey
  private String lastName;
  private String address;

}
