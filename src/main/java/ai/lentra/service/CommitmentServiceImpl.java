package ai.lentra.service;

import ai.lentra.dto.CommitmentDTO;
import ai.lentra.modal.Commitment;
import ai.lentra.repository.CommitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CommitmentServiceImpl implements CommitmentService {
    private final CommitmentRepository commitmentRepository;

    @Autowired
    public CommitmentServiceImpl(CommitmentRepository commitmentRepository) {
        this.commitmentRepository = commitmentRepository;
    }

    Commitment commitment = new Commitment();

    @Override
    public Integer insertCommitment(CommitmentDTO commitmentDTO)  {
        commitment.setCommitmentId(commitmentDTO.getCommitmentId());
        commitment.setInsurance_type(commitmentDTO.getInsurance_type());
        commitment.setLife_insurance_amt((commitmentDTO.getLife_insurance_amt()));
//        checkDuration(commitmentDTO.getLife_insurance_duration());
        commitment.setLife_insurance_duration(commitmentDTO.getLife_insurance_duration());
        commitment.setCar_insurance_amt((commitmentDTO.getCar_insurance_amt()));
        commitment.setCar_insurance_duration(commitmentDTO.getCar_insurance_duration());
        commitment.setHealth_insurance_amt((commitmentDTO.getHealth_insurance_amt()));
        commitment.setHealth_insurance_duration(commitmentDTO.getHealth_insurance_duration());
        commitment.setTwoWheeler_insurance_amt((commitmentDTO.getTwoWheeler_insurance_amt()));
        commitment.setTwoWheeler_insurance_duration(commitmentDTO.getTwoWheeler_insurance_duration());
        commitment.setHome_insurance_amt((commitmentDTO.getHome_insurance_amt()));
        commitment.setHome_insurance_duration(commitmentDTO.getHome_insurance_duration());
        commitment.setTerm_insurance_amt((commitmentDTO.getTerm_insurance_amt()));
        commitment.setTerm_insurance_duration(commitmentDTO.getTerm_insurance_duration());
        commitment.setLoc_amt((commitmentDTO.getLoc_amt()));
        commitment.setLoc_expiry_date(commitmentDTO.getLoc_expiry_date());
        commitment.setNps_applicant_name(commitmentDTO.getNps_applicant_name());
        commitment.setNps_amt((commitmentDTO.getNps_amt()));
        commitment.setNps_duration(commitmentDTO.getNps_duration());
        commitment.setBank_name_loc(commitmentDTO.getBank_name_loc());
        commitmentRepository.save(commitment);
        return commitment.getCommitmentId();

    }

//    private void checkDuration(Number lifeInsuranceDuration) {
//        if(lifeInsuranceDuration.toString().length()<1 || lifeInsuranceDuration.toString().length()>3)throw new CustomizedResponseEntityExceptionHandler("error message");


    @Override
    public Commitment updateCommitment(CommitmentDTO commitmentDTO) {
        Commitment commitment = new Commitment();
        commitment.setCommitmentId(commitmentDTO.getCommitmentId());
        commitment.setInsurance_type(commitmentDTO.getInsurance_type());
        commitment.setLife_insurance_amt( (commitmentDTO.getLife_insurance_amt()));
        commitment.setLife_insurance_duration(commitmentDTO.getLife_insurance_duration());
        commitment.setCar_insurance_amt((commitmentDTO.getCar_insurance_amt()));
        commitment.setCar_insurance_duration(commitmentDTO.getCar_insurance_duration());
        commitment.setHealth_insurance_amt((commitmentDTO.getHealth_insurance_amt()));
        commitment.setHealth_insurance_duration(commitmentDTO.getHealth_insurance_duration());
        commitment.setTwoWheeler_insurance_amt((commitmentDTO.getTwoWheeler_insurance_amt()));
        commitment.setTwoWheeler_insurance_duration(commitmentDTO.getTwoWheeler_insurance_duration());
        commitment.setHome_insurance_amt((commitmentDTO.getHome_insurance_amt()));
        commitment.setHome_insurance_duration(commitmentDTO.getHome_insurance_duration());
        commitment.setTerm_insurance_amt((commitmentDTO.getTerm_insurance_amt()));
        commitment.setTerm_insurance_duration(commitmentDTO.getTerm_insurance_duration());
        commitment.setLoc_amt((commitmentDTO.getLoc_amt()));
        commitment.setLoc_expiry_date(commitmentDTO.getLoc_expiry_date());
        commitment.setNps_applicant_name(commitmentDTO.getNps_applicant_name());
        commitment.setNps_amt((commitmentDTO.getNps_amt()));
        commitment.setNps_duration(commitmentDTO.getNps_duration());
        commitment.setBank_name_loc(commitmentDTO.getBank_name_loc());
        commitmentRepository.save(commitment);
        return commitment;

    }

    @Override
    public List<Commitment> findAll() {
        return commitmentRepository.findAll();
    }

    @Override
    public Optional<Commitment> getcommitmentById(Integer commitmentId) {
        Optional<Commitment> commitment = commitmentRepository.findById((commitmentId));
        return commitment;
    }

//   @Override
//    public Commitment updateCommitment(CommitmentDTO commitmentDTO, Integer commitmentId) {
//        commitment = commitmentRepository.findById(commitmentId).orElse(commitment);
//        if (commitmentDTO.getCommitmentId() != 0)
//            commitment.setCommitmentId(commitmentDTO.getCommitmentId());
//        if(commitmentDTO.getInsurance_type()!=null)
//        commitment.setInsurance_type(commitmentDTO.getInsurance_type());
//        if(commitmentDTO.getLife_insurance_amt()!=null)
//        commitment.setLife_insurance_amt(commitmentDTO.getLife_insurance_amt());
//        if(commitmentDTO.getLife_insurance_duration()!=null)
//        commitment.setLife_insurance_duration(commitmentDTO.getLife_insurance_duration());
//        if(commitmentDTO.getCar_insurance_amt()!=null)
//        commitment.setCar_insurance_amt(commitmentDTO.getCar_insurance_amt());
//        if(commitmentDTO.getCar_insurance_duration()!=null)
//        commitment.setCar_insurance_duration(commitmentDTO.getCar_insurance_duration());
//        if(commitmentDTO.getHealth_insurance_amt()!=null)
//        commitment.setHealth_insurance_amt(commitmentDTO.getHealth_insurance_amt());
//        if(commitmentDTO.getHealth_insurance_duration()!=null)
//        commitment.setHealth_insurance_duration(commitmentDTO.getHealth_insurance_duration());
//        if(commitmentDTO.getTwoWheeler_insurance_amt()!=null)
//        commitment.setTwoWheeler_insurance_amt(commitmentDTO.getTwoWheeler_insurance_amt());
//        if(commitmentDTO.getTwoWheeler_insurance_duration()!=null)
//        commitment.setTwoWheeler_insurance_duration(commitmentDTO.getTwoWheeler_insurance_duration());
//        if(commitmentDTO.getHome_insurance_amt()!=null)
//        commitment.setHome_insurance_amt(commitmentDTO.getHome_insurance_amt());
//        if(commitmentDTO.getHome_insurance_duration()!=null)
//        commitment.setHome_insurance_duration(commitmentDTO.getHome_insurance_duration());
//        if(commitmentDTO.getTerm_insurance_amt()!=null)
//        commitment.setTerm_insurance_amt(commitmentDTO.getTerm_insurance_amt());
//        if(commitmentDTO.getTerm_insurance_duration()!=null)
//        commitment.setTerm_insurance_duration(commitmentDTO.getTerm_insurance_duration());
//        if(commitmentDTO.getLoc_amt()!=null)
//        commitment.setLoc_amt(commitmentDTO.getLoc_amt());
//        if(commitmentDTO.getLoc_expiry_date()!=null)
//        commitment.setLoc_expiry_date(commitmentDTO.getLoc_expiry_date());
//        if(commitmentDTO.getNps_applicant_name()!=null)
//        commitment.setNps_applicant_name(commitmentDTO.getNps_applicant_name());
//        if(commitmentDTO.getNps_amt()!=null)
//        commitment.setNps_amt(commitmentDTO.getNps_amt());
//        if(commitmentDTO.getNps_duration()!=null)
//        commitment.setNps_duration(commitmentDTO.getNps_duration());
//        if(commitmentDTO.getBank_name_loc()!=null)
//        commitment.setBank_name_loc(commitmentDTO.getBank_name_loc());
//        commitmentRepository.save(commitment);
//        return commitment;

    }






