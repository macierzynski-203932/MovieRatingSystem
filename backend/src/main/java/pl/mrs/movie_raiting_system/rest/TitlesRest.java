package pl.mrs.movie_raiting_system.rest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.service.TitlesService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/title")
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
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        List<TitleInfo> result = titlesService.searchForTitles(query);
        return ResponseEntity.ok().headers(headers).body(result);
    }
}
