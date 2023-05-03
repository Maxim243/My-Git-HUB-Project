package automation.services.dto.GitUserDTO.postDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserPostDTO {
    private String blog;
    private String twitterUsername;
    private String company;
    private String location;
    private boolean hireable;
    private String bio;
}
