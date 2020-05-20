package com.cloud.petstore.controller;

import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.Pet;
import com.cloud.petstore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {


    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createNewPet(@RequestBody Pet pet) {
        Pet petData = petService.savePet(pet);
        return new ResponseEntity(petData, HttpStatus.CREATED);

    }

    @GetMapping("{petId}")
    public ResponseEntity<Pet> findPetById(@PathVariable Long petId) {
        if (petId != null) {
            Optional<Pet> pet = petService.findPetByPetId(petId);
            if (pet.isPresent()) {
                return new ResponseEntity(pet, HttpStatus.FOUND);
            }
        } else {
            return new ResponseEntity("Invalid pet ID ", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Pet not found\n", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{petId}")
    public ResponseEntity<Pet> deletePetByPetId(@PathVariable Long petId) {
        ResponseData responseData = petService.deleteOrderByOrderId(petId);
        return new ResponseEntity(responseData, HttpStatus.valueOf(responseData.getCode()));

    }

  /*  @PutMapping()
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {
        Pet petDetails = petService.updatePetDetails(pet);
        return new ResponseEntity(petDetails, HttpStatus.ACCEPTED);
    }*/


}
