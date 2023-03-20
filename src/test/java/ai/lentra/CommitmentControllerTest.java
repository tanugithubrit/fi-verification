package ai.lentra;

import ai.lentra.controller.CommitmentController;
import ai.lentra.dto.CommitmentDTO;
import ai.lentra.modal.Commitment;
import ai.lentra.service.CommitmentService;
import ai.lentra.service.CommitmentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CommitmentControllerTest {
    @MockBean
    CommitmentServiceImpl commitmentServiceImpl;
    @Autowired
    CommitmentService commitmentService;
    @Autowired
    CommitmentController commitmentController;
    CommitmentDTO commitmentDTO = new CommitmentDTO();
   Commitment commitment = new Commitment();

    @Test
    void test_insertCommitment(){
        CommitmentDTO commitmentDTO = dummyCommitmentDTO();
       Commitment commitment=dummyCommitment();
        when(commitmentServiceImpl.insertCommitment(commitmentDTO)).thenReturn(commitment.getCommitmentId());
       ResponseEntity<Object> response = commitmentController.insertCommitment(commitmentDTO);
        assertNotNull(response);
    }

    public CommitmentDTO dummyCommitmentDTO() {
        commitmentDTO.setCommitmentId(1);
        commitmentDTO.setInsurance_type("car");
        commitmentDTO.setLife_insurance_amt(String.valueOf(113));
        commitmentDTO.setLife_insurance_duration(String.valueOf(2));
        commitmentDTO.setCar_insurance_amt(String.valueOf(113));
        commitmentDTO.setCar_insurance_duration(String.valueOf(2));
        commitmentDTO.setHealth_insurance_amt(String.valueOf(113));
        commitmentDTO.setHealth_insurance_duration(String.valueOf(2));
        commitmentDTO.setTwoWheeler_insurance_amt(String.valueOf(113));
        commitmentDTO.setTwoWheeler_insurance_duration(String.valueOf(2));
        commitmentDTO.setHome_insurance_amt(String.valueOf(113));
        commitmentDTO.setHome_insurance_duration(String.valueOf(2));
        commitmentDTO.setTerm_insurance_amt(String.valueOf(113));
        commitmentDTO.setTerm_insurance_duration(String.valueOf(2));
        commitmentDTO.setLoc_amt(String.valueOf(113));
        commitmentDTO.setLoc_expiry_date("13/10/2012");
        commitmentDTO.setNps_applicant_name("jagruti");
        commitmentDTO.setNps_amt(String.valueOf(113));
        commitmentDTO.setNps_duration(String.valueOf(2));
        commitmentDTO.setBank_name_loc("abcd");
        return commitmentDTO;

    }

    public Commitment dummyCommitment() {
        CommitmentDTO commitmentDTO = dummyCommitmentDTO();
        commitment.setCommitmentId(commitmentDTO.getCommitmentId());
        commitment.setInsurance_type(commitmentDTO.getInsurance_type());
        commitment.setLife_insurance_amt(commitmentDTO.getLife_insurance_amt());
        commitment.setLife_insurance_duration(commitmentDTO.getLife_insurance_duration());
        commitment.setCar_insurance_amt(commitmentDTO.getCar_insurance_amt());
        commitment.setCar_insurance_duration(commitmentDTO.getCar_insurance_duration());
        commitment.setHealth_insurance_amt(commitmentDTO.getHealth_insurance_amt());
        commitment.setHealth_insurance_duration(commitmentDTO.getHealth_insurance_duration());
        commitment.setTwoWheeler_insurance_amt(commitmentDTO.getTwoWheeler_insurance_amt());
        commitment.setTwoWheeler_insurance_duration(commitmentDTO.getTwoWheeler_insurance_duration());
        commitment.setHome_insurance_amt(commitmentDTO.getHome_insurance_amt());
        commitment.setHome_insurance_duration(commitmentDTO.getHome_insurance_duration());
        commitment.setTerm_insurance_amt(commitmentDTO.getTerm_insurance_amt());
        commitment.setTerm_insurance_duration(commitmentDTO.getTerm_insurance_duration());
        commitment.setLoc_amt(commitmentDTO.getLoc_amt());
        commitment.setLoc_expiry_date(commitmentDTO.getLoc_expiry_date());
        commitment.setNps_applicant_name(commitmentDTO.getNps_applicant_name());
        commitment.setNps_amt(commitmentDTO.getNps_amt());
        commitment.setNps_duration(commitmentDTO.getNps_duration());
        commitment.setBank_name_loc(commitmentDTO.getBank_name_loc());
        return commitment;

    }
    @Test
    void test_getCommitmentById() throws IOException {
        Commitment commitment=dummyCommitment();
        Integer id=1;
        when(commitmentServiceImpl.getcommitmentById(id)).thenReturn(Optional.ofNullable(commitment));
        Optional<Commitment> response =commitmentController.getCommitmentById(1);
        assertNotNull(response);

    }
    @Test
    void test_updateCommitment() throws IOException {
        Commitment commitment=dummyCommitment();
        CommitmentDTO commitmentDTO=dummyCommitmentDTO();
        when(commitmentService.updateCommitment(commitmentDTO)).thenReturn(commitment);
        Commitment response=commitmentController.updateCommitment(commitmentDTO);
        Assertions.assertNotNull(response);


    }
    @Test
    public void test_getCommitmentList() throws IOException {
        List<Commitment>commitmentList=new ArrayList<>();
        Commitment commitment=dummyCommitment();
        commitmentList.add(commitment);
        when(commitmentService.findAll()).thenReturn(commitmentList);
        List<Commitment>response= commitmentController.getCommitmentList();
        Assertions.assertNotNull(response);}

}


