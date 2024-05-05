package br.easy.parking.controller;

import br.easy.parking.model.UserModel;
import br.easy.parking.utils.SwaggerExamples;
import br.easy.parking.repository.entity.UserEntity;
import br.easy.parking.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kong.unirest.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @ApiOperation(value = "Cria um usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = String.class),
                    examples = {@ExampleObject(value = SwaggerExamples.POSTREGISTER)})
            ),
            @ApiResponse(responseCode = "201", description = "Status não utilizado"),
            @ApiResponse(responseCode = "401", description = "Status não utilizado."),
            @ApiResponse(responseCode = "403", description = "Status não utilizado."),
            @ApiResponse(responseCode = "400", description = "Corpo do json mal formado ou inválido"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @PostMapping(value = "/create/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createUser(@ApiParam(name = "requestBody", type = MediaType.APPLICATION_JSON_VALUE, value = "Corpo do cadastro de usuário", example = SwaggerExamples.POSTREGISTER) @RequestBody String requestBody) {
        JSONObject requestBodyJson = new JSONObject(requestBody);
        UserModel userModel = new UserModel(requestBodyJson);
        boolean hasCreated = userService.createUser(userModel);
        return hasCreated;
    }

    @CrossOrigin
    @ApiOperation(value = "Loga um usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = String.class),
                    examples = {@ExampleObject(value = SwaggerExamples.POSTLOGIN)})
            ),
            @ApiResponse(responseCode = "201", description = "Status não utilizado"),
            @ApiResponse(responseCode = "401", description = "Status não utilizado."),
            @ApiResponse(responseCode = "403", description = "Status não utilizado."),
            @ApiResponse(responseCode = "400", description = "Corpo do json mal formado ou horário inválido"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @PostMapping(value = "/login/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean Login(@ApiParam(name = "requestBody", type = MediaType.APPLICATION_JSON_VALUE, value = "Corpo do login", example = SwaggerExamples.POSTLOGIN) @RequestBody String requestBody) {
        JSONObject requestBodyJson = new JSONObject(requestBody);
        return userService.login(requestBodyJson.getString("email"), requestBodyJson.getString("password"));
    }
}

