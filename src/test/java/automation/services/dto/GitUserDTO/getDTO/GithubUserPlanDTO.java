package automation.services.dto.GitUserDTO.getDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GithubUserPlanDTO {

    private String name;
    private int space;
    private int private_repos;
    private int collaborators;
}