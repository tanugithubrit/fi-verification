package ai.lentra.serviceImpl.personalDetails;

import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.personal_info.PersonalDetails;
import ai.lentra.repository.personalDetails.PersonalDetailsRepository;
import ai.lentra.service.personalDetails.PersonalDetailService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Random;

@Service
public class PersonalDetailServiceImpl implements PersonalDetailService {
    private static final String RESOURCE_NOT_FOUND = "Resource not found for the applicant id :";
    private static final String FUTURE_DATE_ERROR_MSG = "should not be greater than current date";
    @Autowired
    PersonalDetailsRepository personalDetailsRepository;

    @Override
    public ResponseEntity<?> addPersonalDetail(PersonalDetailsDTO personalDetailsDTO, Long applicantId) throws DuplicateResourceException, InvalidInputException, DateTimeParseException {
        Optional<PersonalDetails> duplicateCheck = personalDetailsRepository.findByApplicantId(applicantId);
        if (!duplicateCheck.isEmpty()) {
            throw new DuplicateResourceException("Personal Details for the applicant is already present " + applicantId);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String[] date = personalDetailsDTO.getDateInspected().split("/");
        LocalDate insDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
        LocalDate today = LocalDate.now();
        if (insDate.isAfter(today)) {
            throw new InvalidInputException("Inspected Date" +FUTURE_DATE_ERROR_MSG+ ":  "+ today);
        }
        personalDetailsDTO.setApplicantId(applicantId);
        String[] bdate = personalDetailsDTO.getBirthDate().split("/");
        LocalDate birthDate = LocalDate.of(Integer.parseInt(bdate[2]), Integer.parseInt(bdate[1]), Integer.parseInt(bdate[0]));
        if (birthDate.isAfter(today)) {
            throw new InvalidInputException("Birth Date "+FUTURE_DATE_ERROR_MSG+ ":  " + today);
        }
        LocalDate dob = LocalDate.of(Integer.parseInt(bdate[2]), Integer.parseInt(bdate[1]), Integer.parseInt(bdate[0]));
        personalDetailsDTO.setAge(Period.between(dob, LocalDate.now()).getYears());
        PersonalDetails personDetails = objectMapper.convertValue(personalDetailsDTO, PersonalDetails.class);
        personDetails.setDateTimeEndorsed(Instant.now().toString());
        int randomId = getRandom(900000,1000000);
        String formattedId = String.format("%06d", randomId);
        personDetails.setPersRefId(Integer.valueOf(formattedId));
        personalDetailsRepository.save(personDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201, "Personal Details added Successfully ", "CREATED"));
    }

    @Override
    public ResponseEntity<PersonalDetailsDTO> getPersonalDetailByApplicantId(Long applicantId) throws ResourceNotFoundException {
        PersonalDetails personalDetails = personalDetailsRepository.findByApplicantId(applicantId).orElseThrow(()->new ResourceNotFoundException(RESOURCE_NOT_FOUND + applicantId));
        if (personalDetails==null){
            new ResourceNotFoundException(RESOURCE_NOT_FOUND + applicantId);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        PersonalDetailsDTO personalDetailsDTO = objectMapper.convertValue(personalDetails, PersonalDetailsDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(personalDetailsDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> updatePersonalDetail(PersonalDetailsDTO details, Long applicantId) throws ResourceNotFoundException, InvalidInputException {
        PersonalDetails personalDetails = personalDetailsRepository.findByApplicantId(applicantId).orElseThrow(()-> new ResourceNotFoundException(RESOURCE_NOT_FOUND + applicantId));
        ObjectMapper objectMapper = new ObjectMapper();
        PersonalDetails personalDetailsDTO = objectMapper.convertValue(details, PersonalDetails.class);
            if (personalDetailsDTO.getFirstName() != null) {
                personalDetails.setFirstName(personalDetailsDTO.getFirstName());
            }
            if (personalDetailsDTO.getLastName() != null) {
                personalDetails.setLastName(personalDetailsDTO.getLastName());
            }
            if (personalDetailsDTO.getAge() != 0) {
                personalDetails.setAge(personalDetailsDTO.getAge());
            }
            if (personalDetailsDTO.getAlias() != null) {
                personalDetails.setAlias(personalDetailsDTO.getAlias());
            }
            if (personalDetailsDTO.getCitizenship() != null) {
                personalDetails.setCitizenship(personalDetailsDTO.getCitizenship());
            }
            if (personalDetailsDTO.getDateInspected()!= null) {
                String[] date = personalDetailsDTO.getDateInspected().split("/");
                LocalDate insDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
                LocalDate today = LocalDate.now();
                if (insDate.isAfter(today)) {
                    throw new InvalidInputException("Inspected Date" +FUTURE_DATE_ERROR_MSG+ ":  "+ today);
                }
                personalDetails.setDateInspected(personalDetailsDTO.getDateInspected());
            }
            if (personalDetailsDTO.getIncome()!=null) {
                personalDetails.setIncome(personalDetailsDTO.getIncome());
            }
            if (personalDetailsDTO.getLastName() != null) {
                personalDetails.setLastName(personalDetailsDTO.getLastName());
            }
            if (personalDetailsDTO.getApplicantId() != 0) {
                personalDetails.setApplicantId(personalDetailsDTO.getApplicantId());
            }
            if (personalDetailsDTO.getBirthDate() != null) {
                LocalDate today = LocalDate.now();
                String[] bdate = personalDetailsDTO.getBirthDate().split("/");
                LocalDate birthDate = LocalDate.of(Integer.parseInt(bdate[2]), Integer.parseInt(bdate[1]), Integer.parseInt(bdate[0]));
                if (birthDate.isAfter(today)) {
                    throw new InvalidInputException("Birth Date "+FUTURE_DATE_ERROR_MSG+ ":  " + today);
                }
                personalDetails.setBirthDate(personalDetailsDTO.getBirthDate());
            }
            if (personalDetailsDTO.getCivilStatus() != null) {
                personalDetails.setCivilStatus(personalDetailsDTO.getCivilStatus());
            }
            if (personalDetailsDTO.getEducationLevel() != null) {
                personalDetails.setEducationLevel(personalDetailsDTO.getEducationLevel());
            }
            if (personalDetailsDTO.getIncomePeriod()!= null) {
                personalDetails.setIncomePeriod(personalDetailsDTO.getIncomePeriod());
            }
        if (!personalDetailsDTO.isLoanTakenEarlier()) {
            if (personalDetails.isLoanTakenEarlier())
            {
                personalDetails.setLoanTakenEarlier(personalDetailsDTO.isLoanTakenEarlier());
            }
        }else
        {
            personalDetails.setLoanTakenEarlier(personalDetailsDTO.isLoanTakenEarlier());
        }
            if (personalDetailsDTO.getMiddleName() != null) {
                personalDetails.setMiddleName(personalDetailsDTO.getMiddleName());
            }
            if (personalDetailsDTO.getReligion() != null) {
                personalDetails.setReligion(personalDetailsDTO.getReligion());
            }
            if (personalDetailsDTO.getSuffix() != null) {
                personalDetails.setSuffix(personalDetailsDTO.getSuffix());
            }
            if (!personalDetailsDTO.isPoliticallyExposed()) {
                if (personalDetails.isPoliticallyExposed())
                {
                    personalDetails.setPoliticallyExposed(personalDetailsDTO.isPoliticallyExposed());
                }
            }else
            {
                personalDetails.setPoliticallyExposed(personalDetailsDTO.isPoliticallyExposed());
            }

            personalDetailsRepository.save(personalDetails);
            return ResponseEntity.status(HttpStatus.OK).body(getResponse(200, "PersonalDetails updated Successfully", "Success"));

    }




    public ResponseDTO getResponse(int code, String message, String status) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.valueOf(code));
        ResponseDTO.setMessage(message);
        ResponseDTO.setStatus(status);
        return ResponseDTO;
    }
    Random random = new Random();
    public int getRandom(int min, int max){
        return random.nextInt(min) + max;
    }


}
