package ai.lentra.service;

import ai.lentra.controller.ValidationController;
import ai.lentra.dto.ResponseDto;
import ai.lentra.exceptions.ResidenceException;
import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import ai.lentra.repository.OfficeSelfEmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.List;

import static ai.lentra.commons.ErrorMessage.OFFICE_NOT_FOUND;


@Service
@Transactional
public class OfficeSelfEmploymentServiceImpl implements OfficeSelfEmploymentService{
    @Autowired
    OfficeSelfEmploymentRepository officeSelfEmploymentRepository;

    @Autowired
    ValidationController validationController;

    @Override
    public List<OfficeSelfEmployment> findAll() {
        return officeSelfEmploymentRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addOffice(OfficeSelfEmployment offices) throws ResidenceException {

        Boolean checkValid =  checkValidations(offices);


    if (checkValid) {
            officeSelfEmploymentRepository.save(offices);
    }
        ResponseDto responseDTO=new ResponseDto();
        responseDTO.setCode(HttpStatus.CREATED);
        responseDTO.setMessage("Office/Self Employment Details Created Successfully");
        responseDTO.setStatus("Created");
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }



    private Boolean checkValidations(OfficeSelfEmployment offices) {

            if (offices.getOfficeArea()!=null && validationController.checkLength(offices.getOfficeArea()) < 2 || validationController.checkLength(offices.getOfficeArea()) > 5) {
                throw new ResidenceException("Office area should be in between 2 to 5 digits");


        }else
            if(offices.getNoOfEmplyees()!=null && !validationController.isNumber(offices.getNoOfEmplyees())){
                throw new ResidenceException("Please enter number of employees in numeric format");

            }else
            if (offices.getNoOfEmplyees()!=null && offices.getNoOfEmplyees().length() < 3 || offices.getNoOfEmplyees().length() > 10){

                    throw new ResidenceException("Number of employees should be in between 3 to 10 digits");

            }


       else
            if (offices.getLast_monthSalary()!=null && validationController.checkLengthLong(offices.getLast_monthSalary()) < 3 || validationController.checkLengthLong(offices.getLast_monthSalary()) > 13) {
                throw new ResidenceException("Last month salary should be in between 3 to 13 digits");

        }else
            if (validationController.checkDecimalLong(offices.getLast_monthSalary()) ) {
                throw new ResidenceException("Decimal not allowed in last month salary");

            }
        else if (validationController.checkLength(offices.getAvgMonthlyTurnOver())<3|| validationController.checkLength(offices.getAvgMonthlyTurnOver())>13)
        {
            throw new ResidenceException("Average monthly turnover shold be in between 3 to 13 digits");
        } else if (offices.getOfficeName().length()<3|| offices.getOfficeName().length()>10)
        {
            throw new ResidenceException("Office name shold be in between 3 to 10 characters");
        }
        else if (validationController.checkLength(offices.getExtensionNo())<2 || validationController.checkLength(offices.getExtensionNo())>10)
        {
            throw new ResidenceException("Extension number shold be in between 2 to 10 digits");
        }else if(!validationController.checkEmail(offices.getOfficeEmail())){
            throw new ResidenceException("Not a valid email");

        }
        else if (offices.getOfficeEmail().length()<25 || offices.getOfficeEmail().length()>100)
        {
            throw new ResidenceException("Email should be in between 25 to 100 characters");
        }

        else if (offices.getOfficeAddressLine1().length()<50 || offices.getOfficeAddressLine1().length()>255)
        {
            throw new ResidenceException("Address line1 should be in between 50 to 255 characters");
        }
        else if (offices.getOfficeAddressLine2().length()<50 || offices.getOfficeAddressLine2().length()>255)
        {
            throw new ResidenceException("Address line2 should be in between 50 to 255 characters");
        }

       else if (offices.getOfficeAddressLine4().length()<50 || offices.getOfficeAddressLine4().length()>255)
        {
            throw new ResidenceException("Address line4 should be in between 50 to 255 characters");
        }

       else if (offices.getOfficeAddressPincode().length()<6 || offices.getOfficeAddressPincode().length()>10)
        {
            throw new ResidenceException("Pincode should be in between 6 to 10 characters");
        }else if (offices.getOfficeAddressCity().length()<4 || offices.getOfficeAddressCity().length()>20)
        {
            throw new ResidenceException("City should be in between 4 to 20 characters");
        }
        else if (offices.getOffice_address_state().length()<3 || offices.getOffice_address_state().length()>20)
        {
            throw new ResidenceException("State should be in between 4 to 20 characters");
        }
        else
            if (offices.getOfficeCityCode()!=null && offices.getOfficeCityCode().length() < 6 || offices.getOfficeCityCode().length() > 10) {
                throw new ResidenceException("City code should be in between 6 to 10 characters");
            }

        else
            if (offices.getOfficeStateCode()!=null && offices.getOfficeStateCode().length() < 6 || offices.getOfficeStateCode().length() > 10) {
                throw new ResidenceException("State code should be in between 6 to 10 characters");
            }

        else if (offices.getEmployeeCode().length()<5 || offices.getEmployeeCode().length()>15)
        {
            throw new ResidenceException("Employee code should be in between 5 to 15 characters");
        }

        else if (offices.getBusinessActivitySighted().length()<3 || offices.getBusinessActivitySighted().length()>10)
        {
            throw new ResidenceException("Business activity sighted should be in between 3 to 10 characters");
        }

        else if (offices.getOfficeName()==null|| offices.getOfficeName().equals(""))
        {
            throw new ResidenceException("Value required for office name");
        }
        else if (offices.getOfficeTelephoneNo()==null)
        {
            throw new ResidenceException("Value required for office telephone number");
        }else if (offices.getOfficeEmail()==null|| offices.getOfficeEmail().equals(""))
        {
            throw new ResidenceException("Value required for office email");
        }else if (offices.getOfficeAddressLine1()==null|| offices.getOfficeAddressLine1().equals(""))
        {
            throw new ResidenceException("Value required for office address line1");
        }
        else if (offices.getOfficeAddressLine2()==null|| offices.getOfficeAddressLine2().equals(""))
        {
            throw new ResidenceException("Value required for office address line2");
        }
            else if (offices.getOfficeAddressLine3()==null|| offices.getOfficeAddressLine3().equals(""))
            {
                throw new ResidenceException("Value required for office address line3");
            }
        else if (offices.getOfficeAddressLine4()==null|| offices.getOfficeAddressLine4().equals(""))
        {
            throw new ResidenceException("Value required for office address line4");
        }else if (offices.getOfficeAddressPincode()==null|| offices.getOfficeAddressPincode().equals(""))
        {
            throw new ResidenceException("Value required for office address pincode");
        }
        else if (offices.getOfficeAddressCity()==null|| offices.getOfficeAddressCity().equals(""))
        {
            throw new ResidenceException("Value required for office address city");
        }else if (offices.getOffice_address_state()==null|| offices.getOffice_address_state().equals(""))
        {
            throw new ResidenceException("Value required for office address state");
        }
        else if (offices.getOfficeAddressCountry()==null)
        {
            throw new ResidenceException("Value required for office address country");
        }else if (offices.getEmployeeCode()==null || offices.getEmployeeCode().equals(""))
        {
            throw new ResidenceException("Value required for office employee code");
        }
        return true;
    }

    @Override
    public OfficeSelfEmployment findOfficeById(Integer applicantId) throws ResidenceException {
        return officeSelfEmploymentRepository
                .findByAppId(applicantId)
                .orElseThrow(() -> new ResidenceException(OFFICE_NOT_FOUND + " for given Id " + applicantId));
    }



    @Override
    public OfficeSelfEmployment updateOffice(OfficeSelfEmployment newOffice, OfficeSelfEmployment officeSelfEmployment) {
        officeSelfEmployment.setOutOfGeoLimit(newOffice.isOutOfGeoLimit());
        officeSelfEmployment.setMetroLocation(newOffice.isMetroLocation());
        officeSelfEmployment.setNegativeLocation(newOffice.isNegativeLocation());
        officeSelfEmployment.setBusinessBoardSighted(newOffice.isBusinessBoardSighted());
        officeSelfEmployment.setOfficeEmailVerified(newOffice.isOfficeEmailVerified());
        officeSelfEmployment.setEntryAllowedInOffice(newOffice.isEntryAllowedInOffice());
        officeSelfEmployment.setDomainCheck(newOffice.isDomainCheck());

        if(newOffice.getOfficeArea()!=null) {
            officeSelfEmployment.setOfficeArea(newOffice.getOfficeArea());
        }
        if(newOffice.getOfficeExterior()!=null)
            officeSelfEmployment.setOfficeExterior(newOffice.getOfficeExterior());
        if(newOffice.getOfficeInterior()!=null) {
            officeSelfEmployment.setOfficeInterior(newOffice.getOfficeInterior());
        }
        if(newOffice.getNoOfStorey()!=null) {
            officeSelfEmployment.setNoOfStorey(newOffice.getNoOfStorey());
        }
        if(newOffice.getEaseOfOfficeLocation()!=null) {
            officeSelfEmployment.setEaseOfOfficeLocation(newOffice.getEaseOfOfficeLocation());
        }
        if(newOffice.getItemsSightedInOffice()!=null) {
            officeSelfEmployment.setItemsSightedInOffice(newOffice.getItemsSightedInOffice());
        }
        if (newOffice.getNoOfEmplyees()!=null) {
            officeSelfEmployment.setNoOfEmplyees(newOffice.getNoOfEmplyees());
        }
        if(newOffice.getEmploymentType()!=null) {
            officeSelfEmployment.setEmploymentType(newOffice.getEmploymentType());
        }
        if (newOffice.getDesignation()!=null) {
            officeSelfEmployment.setDesignation(newOffice.getDesignation());
        }
        if(newOffice.getCompany_type()!=null) {
            officeSelfEmployment.setCompany_type(newOffice.getCompany_type());
        }
        if(newOffice.getJobDomain()!=null) {
            officeSelfEmployment.setJobDomain(newOffice.getJobDomain());
        }
        if (newOffice.getLast_monthSalary()!=null) {
            officeSelfEmployment.setLast_monthSalary(newOffice.getLast_monthSalary());
        }
        if(newOffice.getNatureOfBusiness()!=null) {
            officeSelfEmployment.setNatureOfBusiness(newOffice.getNatureOfBusiness());
        }
        if(newOffice.getAvgMonthlyTurnOver()!=null) {
            officeSelfEmployment.setAvgMonthlyTurnOver(newOffice.getAvgMonthlyTurnOver());
        }
        if (newOffice.getOfficeName()!=null) {
            officeSelfEmployment.setOfficeName(newOffice.getOfficeName());
        }
        if(newOffice.getOfficeTelephoneNo()!=null) {
            officeSelfEmployment.setOfficeTelephoneNo(newOffice.getOfficeTelephoneNo());
        }
        if(newOffice.getExtensionNo()!=null) {
            officeSelfEmployment.setExtensionNo(newOffice.getExtensionNo());
        }
        if(newOffice.getOfficeEmail()!= null) {
            officeSelfEmployment.setOfficeEmail(newOffice.getOfficeEmail());
        }
        if(newOffice.getOfficeAddressLine1()!=null) {
            officeSelfEmployment.setOfficeAddressLine1(newOffice.getOfficeAddressLine1());
        }
        if(newOffice.getOfficeAddressLine2()!=null) {
            officeSelfEmployment.setOfficeAddressLine2(newOffice.getOfficeAddressLine2());
        }
        if(newOffice.getOfficeAddressLine3()!=null) {
            officeSelfEmployment.setOfficeAddressLine2(newOffice.getOfficeAddressLine3());
        }

        if (newOffice.getOfficeAddressLine4()!=null) {
            officeSelfEmployment.setOfficeAddressLine4(newOffice.getOfficeAddressLine4());
        }
        if (newOffice.getOfficeAddressPincode()!=null) {
            officeSelfEmployment.setOfficeAddressPincode(newOffice.getOfficeAddressPincode());
        }
        if (newOffice.getOfficeAddressCity()!=null) {
            officeSelfEmployment.setOfficeAddressCity(newOffice.getOfficeAddressCity());
        }
        if (newOffice.getOffice_address_state()!=null) {
            officeSelfEmployment.setOffice_address_state(newOffice.getOffice_address_state());
        }
        if(newOffice.getOfficeAddressCountry()!=null) {
            officeSelfEmployment.setOfficeAddressCountry(newOffice.getOfficeAddressCountry());
        }
        if (newOffice.getOfficeCityCode()!=null) {
            officeSelfEmployment.setOfficeCityCode(newOffice.getOfficeCityCode());
        }
        if(newOffice.getOfficeStateCode()!=null) {
            officeSelfEmployment.setOfficeStateCode(newOffice.getOfficeStateCode());
        }
        if (newOffice.getEmployeeCode()!=null) {
            officeSelfEmployment.setEmployeeCode(newOffice.getEmployeeCode());
        }
        if (newOffice.getBusinessActivitySighted()!=null) {
            officeSelfEmployment.setBusinessActivitySighted(newOffice.getBusinessActivitySighted());
        }
        if(newOffice.getOfficeLocality()!=null) {
            officeSelfEmployment.setOfficeLocality(newOffice.getOfficeLocality());
        }
        if (newOffice.getApplicantId()!=null) {
            officeSelfEmployment.setApplicantId(newOffice.getApplicantId());
        }
        checkValidations(officeSelfEmployment);
        return officeSelfEmploymentRepository.save(officeSelfEmployment);
    }
}
