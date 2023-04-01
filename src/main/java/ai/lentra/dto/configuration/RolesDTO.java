package ai.lentra.dto.configuration;

import lombok.Data;


@Data
public class RolesDTO {

    private long roleId;

    private String roleName;

    private String VmsRoleName;

    private Boolean status;

}
