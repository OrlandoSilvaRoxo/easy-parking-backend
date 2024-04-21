package br.easy.parking.utils;
/**
 * Classe que armazena os exemplos para anotações do swagger da API.
 */
public class SwaggerExamples {
    /**
     * HomeController.
     * Página html utilizada para o redirecionamento ao Swagger da API.
     */
    public static final String REDIRECTPAGE = """
      <!DOCTYPE html>
      	<html lang="en">
      		<head>
      		<meta http-equiv="refresh" content="1; URL=/swagger-ui/">
      		</head>
      		<body bgcolor="#7FFFD4">
              <center><h1><p>Você será redirecionado automaticamente, aguarde...<p>&#8987</p><a href="doxygen/html/index.html"</a></p></h1></center>
      		</body>
      	</html>
      """;

    public static final String CREATECAREXAMPLE = """
            {
              "id": 1,
              "licensePlate": "ABC-1234",
              "user": {
                "id": 10,
                "username": "john_doe",
                "email": "john@example.com",
                "password": "encrypted_password"
              },
              "make": "Toyota",
              "model": "Corolla",
              "color": "Blue",
              "parkingTime": "2024-04-15T14:30:00"
            }
                  
      """;
}
