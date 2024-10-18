package com.entjava.furryfriends.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.entjava.furryfriends.service.CatService;
import com.entjava.furryfriends.service.DogService;
import com.entjava.furryfriends.service.HamsterService;
import com.entjava.furryfriends.service.BirdService;
import com.entjava.furryfriends.service.PetService;

// import com.entjava.furryfriends.model.Cat;
// import com.entjava.furryfriends.model.Dog;
// import com.entjava.furryfriends.model.Hamster;
// import com.entjava.furryfriends.model.Bird;
// import com.entjava.furryfriends.model.Pet;

@RestController
public class BaseController {
    
    @Autowired
    private CatService catsService;

    @Autowired
    private DogService dogsService;

    @Autowired
    private HamsterService hamstersService;

    @Autowired
    private BirdService birdsService;

    @Autowired
    private PetService petsService;

    @GetMapping("/api/{petType}")
    public ResponseEntity<?> getPetWithAdditionalInfo(@PathVariable String petType) {
        
        List<?> res = null;
        Map<String, Object> response = new HashMap<>();

        // Get the username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Get the username
        response.put("username", username);

        petType = petType.toLowerCase();

        if ("cats".equals(petType)) {
            res = catsService.findAllCats(); 
            response.put("cats", res);
        } else if ("dogs".equals(petType)) {
            res = dogsService.findAllDogs(); 
            response.put("dogs", res);
        } else if ("hamsters".equals(petType)) {
            res = hamstersService.findAllHamsters(); 
            response.put("hamsters", res);
        } else if ("birds".equals(petType)) {
            res = birdsService.findAllBirds(); 
            response.put("birds", res);
        } else if ("pets".equals(petType)) {
            res = petsService.findAllPets(); 
            response.put("pets", res);
        } else {
            return ResponseEntity.badRequest().body("Invalid pet type");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/pets/{id}")
    public ResponseEntity<?> getPetById(@PathVariable Long id) {
        
        Object res = null;
        Map<String, Object> response = new HashMap<>();

        // Get the username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        response.put("username", username);

        res = petsService.findPetById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
        response.put("pet", res);

        return ResponseEntity.ok(response);
    }

    // Commented other requests other than GET since it returns unauthorized error
    // I don't know how to fix

    // @PostMapping("/api/{petType}")
    // public ResponseEntity<?> createPet(@PathVariable String petType, @RequestBody Object pet) {
        
    //     Map<String, Object> response = new HashMap<>();

    //     // Get the username
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     String username = authentication.getName();
    //     response.put("username", username);

    //     petType = petType.toLowerCase();

    //     if ("cats".equals(petType)) {
    //         Cat cat = (Cat) pet;
    //         catsService.saveCat(cat);
    //         response.put("cat", cat);
    //     } else if ("dogs".equals(petType)) {
    //         Dog dog = (Dog) pet;
    //         dogsService.saveDog(dog);
    //         response.put("dog", dog);
    //     } else if ("hamsters".equals(petType)) {
    //         Hamster hamster = (Hamster) pet;
    //         hamstersService.saveHamster(hamster);
    //         response.put("hamster", hamster);
    //     } else if ("birds".equals(petType)) {
    //         Bird bird = (Bird) pet;
    //         birdsService.saveBird(bird);
    //         response.put("bird", bird);
    //     } else if ("pets".equals(petType)) {
    //         Pet _pet = (Pet) pet;
    //         petsService.savePet(_pet);
    //         response.put("pet", _pet);
    //     } else {
    //         return ResponseEntity.badRequest().body("Invalid pet type");
    //     }

    //     return ResponseEntity.ok(response);
    // }

    // @DeleteMapping("/api/pets/{id}")
    // public ResponseEntity<?> deletePet(@PathVariable Long id) {
        
    //     Map<String, Object> response = new HashMap<>();

    //     // Get the username
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     String username = authentication.getName();
    //     response.put("username", username);

    //     petsService.deletePet(id);

    //     return ResponseEntity.ok(response);
    // }

    // @PatchMapping("/api/{petType}/{id}")
    // public ResponseEntity<?> updatePet(@PathVariable String petType, @PathVariable Long id, @RequestBody Object pet) {
        
    //     Map<String, Object> response = new HashMap<>();

    //     // Get the username
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     String username = authentication.getName();
    //     response.put("username", username);

    //     petType = petType.toLowerCase();

    //     if ("cats".equals(petType)) {
    //         Cat cat = (Cat) pet;
    //         catsService.updateCat(id, cat);
    //         response.put("cat", cat);
    //     } else if ("dogs".equals(petType)) {
    //         Dog dog = (Dog) pet;
    //         dogsService.updateDog(id, dog);
    //         response.put("dog", dog);
    //     } else if ("hamsters".equals(petType)) {
    //         Hamster hamster = (Hamster) pet;
    //         hamstersService.updateHamster(id, hamster);
    //         response.put("hamster", hamster);
    //     } else if ("birds".equals(petType)) {
    //         Bird bird = (Bird) pet;
    //         birdsService.updateBird(id, bird);
    //         response.put("bird", bird);
    //     } else if ("pets".equals(petType)) {
    //         Pet _pet = (Pet) pet;
    //         petsService.updatePet(id, _pet);
    //         response.put("pet", _pet);
    //     } else {
    //         return ResponseEntity.badRequest().body("Invalid pet type");
    //     }

    //     return ResponseEntity.ok(response);
    // }
}
