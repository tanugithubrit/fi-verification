package ai.lentra.modal.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "role_config")
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class RolesEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private long roleId;

    private String roleName;

    private String VmsRoleName;

    private Boolean status;
}
