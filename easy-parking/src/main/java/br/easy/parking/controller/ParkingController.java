package br.easy.parking.controller;

import br.easy.parking.model.ParkingModel;
import br.easy.parking.model.UserModel;
import br.easy.parking.repository.entity.ParkingEntity;
import br.easy.parking.service.ParkingService;
import br.easy.parking.utils.SwaggerExamples;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kong.unirest.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    ParkingService parkingService;

    @CrossOrigin
    @ApiOperation(value = "Cria um estacionamento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "201", description = "Status não utilizado"),
            @ApiResponse(responseCode = "401", description = "Status não utilizado."),
            @ApiResponse(responseCode = "403", description = "Status não utilizado."),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @PostMapping(value = "/create/")
    public boolean createParking() {
        return parkingService.createParking();
    }

    @CrossOrigin
    @ApiOperation(value = "Retorna todos os estacionamentos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "201", description = "Status não utilizado"),
            @ApiResponse(responseCode = "401", description = "Status não utilizado."),
            @ApiResponse(responseCode = "403", description = "Status não utilizado."),
            @ApiResponse(responseCode = "400", description = "Corpo do json mal formado inválido"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @GetMapping(value = "/get-all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkingEntity> getParkings() {
        return parkingService.getAllParkings();
    }

    @CrossOrigin
    @ApiOperation(value = "Ocupa um estacionamento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "201", description = "Status não utilizado"),
            @ApiResponse(responseCode = "401", description = "Status não utilizado."),
            @ApiResponse(responseCode = "403", description = "Status não utilizado."),
            @ApiResponse(responseCode = "400", description = "Corpo do json mal formado inválido"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @PostMapping(value = "/occupy/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean occupyParking(@ApiParam(name = "requestBody", type = MediaType.APPLICATION_JSON_VALUE, value = "Corpo do cadastro de usuário", example = SwaggerExamples.POSTOCCUPY) @RequestBody String requestBody) {
        JSONObject requestBodyJson = new JSONObject(requestBody);
        ParkingModel parkingModel = new ParkingModel(requestBodyJson);
        boolean hasOccupied = parkingService.occupyParking(parkingModel);
        return hasOccupied;
    }

    @CrossOrigin
    @ApiOperation(value = "Libera um estacionamento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ParkingEntity.class),
                    examples = {@ExampleObject(value = "{'id': 1, 'occupied': false}, {'id': 2, 'occupied': true}")})
            ),
            @ApiResponse(responseCode = "201", description = "Status não utilizado"),
            @ApiResponse(responseCode = "401", description = "Status não utilizado."),
            @ApiResponse(responseCode = "403", description = "Status não utilizado."),
            @ApiResponse(responseCode = "400", description = "Corpo do json mal formado inválido"),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @GetMapping(value = "/free/")
    public boolean freeParking(@Parameter(description = "Id da vaga", example = "1") @RequestParam String id) {
        return parkingService.freeParking(Long.valueOf(id));
    }

    @CrossOrigin
    @ApiOperation(value = "Deleta um estacionamento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "201", description = "Status não utilizado"),
            @ApiResponse(responseCode = "401", description = "Status não utilizado."),
            @ApiResponse(responseCode = "403", description = "Status não utilizado."),
            @ApiResponse(responseCode = "500", description = "Erro interno na requisição")})
    @DeleteMapping(value = "/delete/")
    public boolean deleteParking(@Parameter(description = "Id da vaga", example = "1") @RequestParam Long id) {
        return parkingService.deleteParking(id);
    }
}
