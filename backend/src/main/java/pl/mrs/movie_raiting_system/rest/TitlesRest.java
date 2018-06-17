package pl.mrs.movie_raiting_system.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.service.TitlesService;

@RestController
@RequestMapping("/api/title")
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@Api(value = "Movies and tv shows",
        basePath = "/api/title",
        produces = "application/json",
        description = "Information about movies and tv shows")
public class TitlesRest {

    @Autowired
    private TitlesService titlesService;

    @ApiOperation(value = "Searches for movie/ tv show titles",
            response = UserInfo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Search succesful."),
            @ApiResponse(code = 401, message = "You are unauthorized."),
            @ApiResponse(code = 403, message = "You are forbidden to access this resource."),
            @ApiResponse(code = 404, message = "Information about titles unavailable."),
            @ApiResponse(code = 500, message = "Unknown error.")
    })
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String query) {
        List<TitleInfo> result = titlesService.searchForTitles(query);
        return ResponseEntity.ok().body(result);
    }
}
