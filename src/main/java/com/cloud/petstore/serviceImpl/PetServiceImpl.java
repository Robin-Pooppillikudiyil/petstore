package com.cloud.petstore.serviceImpl;

import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.Pet;
import com.cloud.petstore.repository.PetRepository;
import com.cloud.petstore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public Pet savePet(Pet pet) {
        pet.setId(null);
        return petRepository.save(pet);
    }

    @Override
    public Optional<Pet> findPetByPetId(Long petId) {
        return petRepository.findById(petId);
    }

    @Override
    public ResponseData deleteOrderByOrderId(Long petId) {
        Optional<Pet> dbPet = petRepository.findById(petId);
        if (!dbPet.isPresent()) {
            return new ResponseData(HttpStatus.BAD_REQUEST.value(), "unknown", "Invalid order Id supplied");
        }
        petRepository.delete(dbPet.get());
        return new ResponseData(HttpStatus.OK.value(), "unknown", dbPet.toString());
    }

   /* @Override
    public ResponseEntity<Pet> updatePetDetails(Pet pet) {
        if(pet!=null){
        return ResponseEntity<>(petRepository.save(pet));
        }
        return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
    }*/
}
