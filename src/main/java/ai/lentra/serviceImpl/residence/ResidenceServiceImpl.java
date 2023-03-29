package ai.lentra.serviceImpl.residence;

import ai.lentra.controller.ValidationController;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.ResidenceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.residence.Residence;
import ai.lentra.repository.residence.ResidenceRepository;
import ai.lentra.service.residence.ResidenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static ai.lentra.commons.ErrorMessage.INVALID_CURRENCY;
import static ai.lentra.commons.ErrorMessage.RESIDENCE_NOT_FOUND;

@Service
@Transactional
public class ResidenceServiceImpl implements ResidenceService{

    @Autowired
    ValidationController validationController;
    @Autowired
    ResidenceRepository residenceRepository;
    @Override
    public List<Residence> findAll()  {
        return residenceRepository.findAll();
    }

    @Override
    public Residence findResidenceByAppId(Long residenceId) throws ResourceNotFoundException {

        return residenceRepository
                .findByAppId(residenceId)
                .orElseThrow(() -> new ResourceNotFoundException(RESIDENCE_NOT_FOUND + " for given Id " + residenceId));
    }

    @Override
    public Residence updateExpense(Residence newResidence, Residence residence) {

        residence.setAddressLine1(newResidence.getAddressLine1());
        residence.setAddressLine2(newResidence.getAddressLine2());
        residence.setAddressLine3(newResidence.getAddressLine3());
        residence.setAddressLine4(newResidence.getAddressLine4());
        residence.setAppliances(newResidence.getAppliances());
        residence.setCity(newResidence.getCity());
        residence.setResidenceType(newResidence.getResidenceType());
        residence.setClassification(newResidence.getClassification());
        residence.setResidenceCategory(newResidence.getResidenceCategory());
        residence.setResidenceLandmark(newResidence.getResidenceLandmark());
        residence.setResidenceType(newResidence.getResidenceType());
        residence.setAddressProofId(newResidence.getAddressProofId());
        residence.setAppliancesTotalValue(newResidence.getAppliancesTotalValue());
        residence.setCommunityDominated(newResidence.isCommunityDominated());
        residence.setCommuteOptions(newResidence.getCommuteOptions());
        residence.setYearsOfStay(newResidence.getYearsOfStay());
        residence.setCountry(newResidence.getCountry());
        residence.setCountry_code(newResidence.getCountry_code());
        residence.setDistanceFromAddressToActualLoaction(newResidence.getDistanceFromAddressToActualLoaction());
        residence.setHouseCondition(newResidence.getHouseCondition());
        residence.setLandlineNum(newResidence.getLandlineNum());
        residence.setLattitue(newResidence.getLattitue());
        residence.setLivingWIth(newResidence.getLivingWIth());
        residence.setLongitude(newResidence.getLongitude());
        residence.setMailDeliveryStatus(newResidence.isMailDeliveryStatus());
        residence.setMonthlyAmortization(newResidence.getMonthlyAmortization());
        residence.setMonthsOfStay(newResidence.getMonthsOfStay());
        residence.setMortagagorName(newResidence.getMortagagorName());
        residence.setNamePlateVisible(newResidence.isNamePlateVisible());
        residence.setNegativeLocation(newResidence.isNegativeLocation());
        residence.setNeighbourhoodType(newResidence.getNeighbourhoodType());
        residence.setNoOfStorey(newResidence.getNoOfStorey());
        residence.setOwnedBy(newResidence.getOwnedBy());
        residence.setOwnershipType(newResidence.getOwnershipType());
        residence.setPersMet(newResidence.getPersMet());
        residence.setPincode(newResidence.getPincode());
        residence.setPropertyInterior(newResidence.getPropertyInterior());
        residence.setPropertyMAkeType(newResidence.getPropertyMAkeType());
        residence.setRentedFrom(newResidence.getRentedFrom());
        residence.setRentPerMonth(newResidence.getRentPerMonth());
        residence.setResidency(newResidence.getResidency());
        residence.setState(newResidence.getState());
        residenceRepository.save(residence);
        return residence;
    }

    @Override
    public ResponseEntity<?> addExpense(Residence residence) {

        checkValidations(residence);
        residence.setRentPerMonth( residence.getRentPerMonth().setScale(2, RoundingMode.HALF_UP));

        residence.setAppliancesTotalValue( residence.getAppliancesTotalValue().setScale(2, RoundingMode.HALF_UP));
        residenceRepository.save(residence);

        ResponseDTO ResponseDTO=new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.CREATED);
        ResponseDTO.setMessage("Residence Information Created Successfully");
        ResponseDTO.setStatus("Created");
        new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return  ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO);
    }

    private BigDecimal calculateScore(Residence residence){

        BigDecimal score = BigDecimal.valueOf(residence.getResidenceCategory()).add(BigDecimal.valueOf(residence.getOwnershipType())).add(BigDecimal.valueOf(residence.getResidenceType())).add(BigDecimal.valueOf(residence.getNoOfStorey())).add(
                BigDecimal.valueOf( residence.getClassification())).add(BigDecimal.valueOf(residence.getHouseCondition())).add(BigDecimal.valueOf(residence.getPropertyAge())).add(BigDecimal.valueOf(residence.getPropertyMAkeType())).add(
                BigDecimal.valueOf(residence.getPropertyInterior())).add(BigDecimal.valueOf(residence.getAppliances())).add(residence.getAppliancesTotalValue()).add(BigDecimal.valueOf(residence.getCommuteOptions())).add(
                BigDecimal.valueOf(residence.getNeighbourhoodType())).add(BigDecimal.valueOf(residence.getResidency())).add(BigDecimal.valueOf(residence.getCountry())).add(BigDecimal.valueOf(residence.getYearsOfStay())).add(
                BigDecimal.valueOf(residence.getMonthsOfStay())).add(BigDecimal.valueOf(residence.getDistanceFromAddressToActualLoaction())).add(residence.getMonthlyAmortization()).add(residence.getRentPerMonth());

score = score.setScale(2,RoundingMode.HALF_UP);

        return score;
    }

    private boolean checkValidations(Residence residence )throws ResidenceException {
        if (residence.getAddressLine1()==null || residence.getAddressLine1().equals("")) {

            throw new ResidenceException("Value required for address line 1");

        }else if (residence.getAddressLine1().length()<50|| residence.getAddressLine1().length()>255){
            throw new ResidenceException("Adrress line 1 should be in between 50 to 255 characters");

        }

        else if (residence.getAddressLine2()==null || residence.getAddressLine2().equals("")) {

            throw new ResidenceException("Value required for address line 2");

        }else if (residence.getAddressLine2().length()<50|| residence.getAddressLine2().length()>255){
            throw new ResidenceException("Adrress line 2 should be in between 50 to 255 characters");

        }
        else if (residence.getAddressLine3()==null || residence.getAddressLine3().equals("")) {

            throw new ResidenceException("Value required for address line 3");

        }else if (residence.getAddressLine3().length()<50|| residence.getAddressLine3().length()>255){
            throw new ResidenceException("Adrress line 3 should be in between 50 to 255 characters");

        }
        else
        if (residence.getAddressLine4()==null || residence.getAddressLine4().equals("")) {

            throw new ResidenceException("Value required for address line 4");
        }
        else if (residence.getAddressLine4().length()<50|| residence.getAddressLine4().length()>255){
            throw new ResidenceException("Adrress line 4 should be in between 50 to 255 characters");

        }
        else
        if (residence.getCity()==null || residence.getCity().equals("")) {

            throw new ResidenceException("Value required for city");
        }else if (residence.getCity().length()<4|| residence.getCity().length()>20){
            throw new ResidenceException("City should be in between 4 to 20 characters");

        }

        else
        if (residence.getState()==null || residence.getState().equals("")) {

            throw new ResidenceException("Value required for state");
        }else if (residence.getState().length()<3|| residence.getState().length()>20){
            throw new ResidenceException("State should be in between 3 to 20 characters");

        }

        else if (residence.getPincode()==null || residence.getPincode().equals("")) {

            throw new ResidenceException("Value required for pincode");
        }else if (residence.getPincode().length()<6|| residence.getPincode().length()>10){
            throw new ResidenceException("Pincode should be in between 6 to 10 characters");

        }
        else if (residence.getCountry_code()==null ) {

            throw new ResidenceException("Value required for country code");

        }else if(!validationController.checkCurrency(residence.getAppliancesTotalValue()))
        {
            throw new ResidenceException(INVALID_CURRENCY + " given appliances total value " + residence.getAppliancesTotalValue());

        }else if(!validationController.checkCurrency(residence.getMonthlyAmortization()))
        {
            throw new ResidenceException(INVALID_CURRENCY + "for given monthly amortization " + residence.getMonthlyAmortization());

        }else if (residence.getMortagagorName().length()<3|| residence.getMortagagorName().length()>50){
            throw new ResidenceException("Mortagor Name should be in between 3 to 50 characters");

        }else if (residence.getOwnedBy().length()<3|| residence.getOwnedBy().length()>50){
            throw new ResidenceException("Owned by Name should be in between 3 to 50 characters");

        }
        else if (residence.getPersMet().length()<3|| residence.getPersMet().length()>40){
            throw new ResidenceException("Pers met by Name should be in between 3 to 40 characters");

        }
        else if (residence.getResidenceLandmark().length()<2|| residence.getResidenceLandmark().length()>40){
            throw new ResidenceException("Residence Landmark met by Name should be in between 2 to 40 characters");

        }
        else {
             return true;
        }

        }
}
