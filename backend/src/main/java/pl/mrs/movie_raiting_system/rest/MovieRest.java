package pl.mrs.movie_raiting_system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.service.MovieService;

@RestController
@RequestMapping("/api/movies")
@Api(value = "Rest for movies",
        basePath = "/api/movies",
        produces = "application/json",
        description = "Information about favourite movies")
public class MovieRest {

    @Autowired
    private MovieService movieService;

    @ApiOperation(value = "Gets movie details",
            response = UserInfo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation succesful."),
            @ApiResponse(code = 401, message = "You are unauthorized."),
            @ApiResponse(code = 403, message = "You are forbidden to access this resource."),
            @ApiResponse(code = 404, message = "Information about movie unavailable."),
            @ApiResponse(code = 500, message = "Unknown error.")
    })
    @GetMapping("/favourite")
    public ResponseEntity getFavouriteMovies(){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            return ResponseEntity.ok().headers(headers).body(movieService.getFavouriteMovies());
        } catch (HttpClientErrorException e){
            return ResponseEntity.status(404).build();
        }
    }
}
