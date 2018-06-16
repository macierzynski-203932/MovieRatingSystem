package pl.mrs.movie_raiting_system.rest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.service.UserService2;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/user")
@Api(value = "Current user",
        basePath = "/api/user",
        produces = "application/json",
        description = "User and his movies")
public class UserRest {

    @Autowired
    private UserService2 userService;

    @ApiOperation(value = "Returns information about user",
            response = UserInfo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Information about current user founded."),
            @ApiResponse(code = 401, message = "You are unauthorized."),
            @ApiResponse(code = 403, message = "You are forbidden to access this resource."),
            @ApiResponse(code = 404, message = "Information about user unavailable."),
            @ApiResponse(code = 500, message = "Unknown error.")
    })
    @GetMapping("/{id}")
    public ResponseEntity getUserInfo(
            @ApiParam(value = "ID of current user") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUserInfo(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
