package automation.tests;

import automation.core.PropertyReader;
import automation.services.dto.GitUserDTO.getDTO.GitUserDTO;
import automation.services.dto.repoDTO.getDTO.GithubRepoDTO;
import automation.services.dto.repoDTO.patchDTO.UpdateGitHubDTO;
import automation.services.dto.repoDTO.postDTO.CreateRepositoryDTO;
import automation.services.dto.GitUserDTO.postDTO.UserPostDTO;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static automation.UtilsMethods.UtilsMethods.createRandomNameOfRepository;
import static automation.services.actions.AuthorizationPageActions.getUser;
import static automation.services.actions.AuthorizationPageActions.postUser;
import static automation.services.actions.RepositoryPageActions.*;
//import static automation.services.core.BaseAction.patch;

public class HomePageTests {
    private static final Logger logger = Logger.getLogger(HomePageTests.class);
    private static final Map<String, String> HEADERS = new HashMap<>();
    private static final Integer SUCCESS_STATUS_CODE = 200;
    private static final Integer UNAUTHORIZED_STATUS_CODE = 401;
    private static final String MY_USER_NAME = "Maxim243";
    private static final Integer CREATED_STATUS_CODE = 201;
    private static final Integer NO_CONTENT_STATUS_CODE = 204;
    private GitUserDTO gitUserDTO;
    private static String nameOfRepository;
    private static String url = PropertyReader.getProperty("baseUrl");

    @BeforeMethod
    public void addToken() {
        HEADERS.put("Authorization", "Bearer " + PropertyReader.getProperty("myToken"));
    }

    @Test
    public void getNotAuthenticatedAllUsers() {
//        HEADERS.put("Authorization", "Bearer " );
        url = url.concat("users");
        gitUserDTO = getUser(new HashMap<>(), null, url);
        Assert.assertFalse(gitUserDTO.getResponseHeaders().isEmpty());
        Assert.assertEquals(gitUserDTO.getResponseStatusCode(), SUCCESS_STATUS_CODE);
        logger.error("does not working without token");
    }

    @Test
    public void getNotAuthenticatedUser() {
        HEADERS.put("Authorization", "Bearer ");
        url = url.concat("users/Maxim243");
        gitUserDTO = getUser(HEADERS, null, url);
        Assert.assertFalse(gitUserDTO.getResponseHeaders().isEmpty());
        Assert.assertEquals(gitUserDTO.getResponseStatusCode(), SUCCESS_STATUS_CODE);
        logger.error("does not working without token");
    }


    @Test
    public void updateUserWithoutAuthentication() {
        UserPostDTO userPostDTO = new UserPostDTO("blog", MY_USER_NAME, null, null, true, null);
        HEADERS.put("Authorization", "Bearer ");
        url = url.concat("users/Maxim243");
        gitUserDTO = postUser(HEADERS, null, userPostDTO, url);
        Assert.assertEquals(gitUserDTO.getResponseStatusCode(), UNAUTHORIZED_STATUS_CODE);
        logger.info(gitUserDTO.getResponseHeaders());
//        Assert.assertEquals();
        // TODO: Validate the header content is correct. (ask Olea)
    }

    @Test
    public void getAuthenticatedUser() {
        url = url.concat("users/Maxim243");
        gitUserDTO = getUser(HEADERS, null, url);
        Assert.assertEquals(gitUserDTO.getResponseStatusCode(), SUCCESS_STATUS_CODE);
        Assert.assertEquals(gitUserDTO.getUrl(), PropertyReader.getProperty("myGitHubUrl"));
    }

    @Test
    public void createNewRepository() {
        String description = createRandomNameOfRepository(7);
        nameOfRepository = createRandomNameOfRepository(5);
        url = url.concat("user/repos");
        CreateRepositoryDTO createRepositoryDTO = new CreateRepositoryDTO(nameOfRepository, description,
                "https://github.com", false, true, true, true);
        GithubRepoDTO githubRepoDTO = postRepository(HEADERS, null, createRepositoryDTO, url);
        Assert.assertEquals(githubRepoDTO.getOwner().getLogin(), MY_USER_NAME);
        Assert.assertEquals(githubRepoDTO.getResponseStatusCode(), CREATED_STATUS_CODE);
    }

    @Test(dependsOnMethods = "createNewRepository")
    public void deleteRepository() {
        url = PropertyReader.getProperty("baseUrl");
        url = url.concat("repos/Maxim243/" + nameOfRepository);
        Assert.assertEquals(deleteRepo(HEADERS, url).getResponseStatusCode(), NO_CONTENT_STATUS_CODE);
    }

    @Test
    public void updateRepositoryAuthenticatedUser() {
        url = url.concat("/repos/Maxim243/rwjuN");
        CreateRepositoryDTO createRepositoryDTO = new CreateRepositoryDTO(nameOfRepository, "description",
                "https://github.com", false, true, true, true);
//        UpdateGitHubDTO updateGitHubDTO = updateGitHubDTO()

    }
}
