package com.cloud.petstore.repository;

import com.cloud.petstore.data.Pet;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface PetRepository extends CrudRepository<Pet, Id> {

}
