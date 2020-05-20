package com.cloud.petstore.service;

import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.Pet;

import java.util.Optional;

public interface PetService {

    Pet savePet(Pet pet);

    Optional<Pet> findPetByPetId(Long petId);

    ResponseData deleteOrderByOrderId(Long petId);

    //Object updatePetDetails(Pet pet);
}
