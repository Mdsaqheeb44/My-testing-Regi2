package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        List<Registration> registration = registrationService.getRegistration();
        return registration;
    }

    //    @PostMapping
//    public ResponseEntity<Registration> createRegistration(
//           @RequestBody Registration registration){
//       Registration reg= registrationService.createRegistration(registration);
//       return new ResponseEntity<>(reg, HttpStatus.CREATED);
//    }
    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long id) {
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Delete", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable long id,
            @RequestBody Registration registration) {
        Registration updateReg = registrationService.updateRegistration(id, registration);
        return new ResponseEntity<>(updateReg, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<RegistrationDto> createRegistration( @RequestBody RegistrationDto registrationDto) {
        RegistrationDto reg = registrationService.createRegistration(registrationDto);
               return new ResponseEntity<>(reg,HttpStatus.CREATED);
    }
}