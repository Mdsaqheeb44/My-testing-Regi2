package com.api.service;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.repositry.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;
    private ModelMapper modelMapper;


    public  RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }
    public List<Registration> getRegistration(){
        List<Registration> registrations=  registrationRepository.findAll();
        return registrations;
    }

//    public Registration createRegistration(Registration registration) {
//
//        Registration saveEntity = registrationRepository.save(registration);
//        return saveEntity;
//    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
    }


    public Registration updateRegistration(long id, Registration registration){
        Registration r= registrationRepository.findById(id).get();
        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration saveEntity = registrationRepository.save(r);
        return saveEntity;
    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

        Registration registration = mapToEntity(registrationDto);
        Registration saveEntity = registrationRepository.save(registration);

        RegistrationDto dto = mapToRegistrationDto(saveEntity);
        return dto;

    }
      Registration mapToEntity(RegistrationDto registrationDto) {
          Registration registration = modelMapper.map(registrationDto, Registration.class);
//        Registration registration = new Registration();
//        registration.setName(registrationDto.getName());
//        registration.setEmail(registrationDto.getEmail());
//        registration.setMobile(registrationDto.getMobile());
       return registration;
       }
       RegistrationDto mapToRegistrationDto(Registration registration){
           RegistrationDto regDto = modelMapper.map(registration, RegistrationDto.class);
//        RegistrationDto regDto = new RegistrationDto();
//        regDto.setName(registration.getName());
//        regDto.setEmail(registration.getEmail());
//        regDto.setMobile(registration.getMobile());
        return regDto;

       }
}
