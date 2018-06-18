package pl.mrs.movie_raiting_system.rest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.mrs.movie_raiting_system.dto.TvShowDetails;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieDetails;
import pl.mrs.movie_raiting_system.service.DetailsService;

@RestController
@RequestMapping("/api/details")
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@Api(value = "Movies and tv shows details",
        basePath = "/api/title",
        produces = "application/json",
        description = "Detailed nformation about movies and tv shows")
public class DetailsRest {

    @Autowired
    private DetailsService detailsService;


    @ApiOperation(value = "Gets movie details",
            response = UserInfo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful."),
            @ApiResponse(code = 401, message = "You are unauthorized."),
            @ApiResponse(code = 403, message = "You are forbidden to access this resource."),
            @ApiResponse(code = 404, message = "Information about movie unavailable."),
            @ApiResponse(code = 500, message = "Unknown error.")
    })
    @GetMapping("/movie/{id}")
    public ResponseEntity getMovieDetails(
            @ApiParam(value = "ID of a movie") @PathVariable Long id) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            return ResponseEntity.ok().body(detailsService.getMovieInfo(id));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(404).build();
        }
    }


    @ApiOperation(value = "Gets tv show details",
            response = UserInfo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful."),
            @ApiResponse(code = 401, message = "You are unauthorized."),
            @ApiResponse(code = 403, message = "You are forbidden to access this resource."),
            @ApiResponse(code = 404, message = "Information about show unavailable."),
            @ApiResponse(code = 500, message = "Unknown error.")
    })
    @GetMapping("/tv/{id}")
    public ResponseEntity getTvShowDetails(
            @ApiParam(value = "ID of a tv show") @PathVariable Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            TvShowDetails det = detailsService.getTvShowInfo(id);
            return ResponseEntity.ok().body(det);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/movie/favourite")
    public ResponseEntity saveFavouriteMovie(
            @ApiParam(value = "favourite movie detail")@RequestBody MovieDetails movie) {
        try {
            System.out.println(org.hibernate.Version.getVersionString());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            detailsService.saveFavouriteMovie(movie);
           return ResponseEntity.ok().body("dziala super!");
        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

}
