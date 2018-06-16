package pl.mrs.movie_raiting_system.rest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.service.DetailsService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/details")
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
            @ApiResponse(code = 200, message = "Operation succesful."),
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
            return ResponseEntity.ok().headers(headers).body(detailsService.getMovieInfo(id));
        } catch (Exception e) { //something else here
            return ResponseEntity.status(404).build();
        }
    }
}
