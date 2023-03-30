package ai.lentra.modal.scoreconfig;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VerificationMasterFormFieldId implements Serializable {

    @Column(name = "field_id")
    private Long fieldId;

    @Column(name = "sc_name")
    private String scoreName;

    @Column(name = "s_id")
    private Long scId;

}
