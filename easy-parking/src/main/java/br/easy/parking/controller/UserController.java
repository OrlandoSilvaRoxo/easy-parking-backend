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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Content;

import java.util.List;

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
    @PostMapping(value = "/login/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@ApiParam(name = "requestBody", type = MediaType.APPLICATION_JSON_VALUE, value = "Corpo do login", example = SwaggerExamples.POSTLOGIN) @RequestBody String requestBody) {
        JSONObject requestBodyJson = new JSONObject(requestBody);
        String email = requestBodyJson.getString("email");
        String password = requestBodyJson.getString("password");

        boolean isLogged = userService.login(email, password);
        boolean isAdmin = userService.isAdmin(email);

        JSONObject responseJson = new JSONObject();
        responseJson.put("success", isLogged);
        responseJson.put("isAdmin", isAdmin);

        return ResponseEntity.ok(responseJson.toString());
    }

    @CrossOrigin
    @ApiOperation(value = "Obtém todos os usuários.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @GetMapping(value = "/get-all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @CrossOrigin
    @ApiOperation(value = "Atualiza um usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @PutMapping(value = "/update/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestParam Long id, @RequestBody String requestBody) {
        JSONObject requestBodyJson = new JSONObject(requestBody);
        UserModel userModel = new UserModel(requestBodyJson);
        boolean hasUpdated = userService.updateUser(id, userModel);
        if (hasUpdated) {
            return ResponseEntity.ok("Usuário atualizado com sucesso.");
        } else {
            return ResponseEntity.status(500).body("Erro ao atualizar usuário.");
        }
    }

    @CrossOrigin
    @ApiOperation(value = "Deleta um usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @DeleteMapping(value = "/delete/")
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        boolean hasDeleted = userService.deleteUser(id);
        if (hasDeleted) {
            return ResponseEntity.ok("Usuário deletado com sucesso.");
        } else {
            return ResponseEntity.status(500).body("Erro ao deletar usuário.");
        }
    }

    @CrossOrigin
    @ApiOperation(value = "Alterna o status de administrador de um usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @PostMapping(value = "/toggle-admin/")
    public ResponseEntity<String> toggleAdmin(@RequestParam Long id) {
        boolean hasToggled = userService.toggleAdminStatus(id);
        if (hasToggled) {
            return ResponseEntity.ok("Status de administrador alternado com sucesso.");
        } else {
            return ResponseEntity.status(500).body("Erro ao alternar status de administrador.");
        }
    }
}

