package com.cloud.petstore.repository;

import org.apache.catalina.Store;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface StoreRepository extends CrudRepository<Store, Id> {

}
