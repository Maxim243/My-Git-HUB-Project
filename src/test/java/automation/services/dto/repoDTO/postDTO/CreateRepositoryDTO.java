package automation.services.dto.repoDTO.postDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRepositoryDTO {
    private String name;
    private String description;
    private String homepage;
    @JsonProperty("private")
    private boolean isPrivate;
    private boolean has_issues;
    private boolean has_projects;
    private boolean has_wiki;
}
