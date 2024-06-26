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

    public static final String POSTLOGIN = """
              {
                "email": "john@example.com",
                "password": "encrypted_password"
              }
            """;
    public static final String POSTREGISTER = """
                {
                  "name": "John",
                  "lastName": "Cury",
                  "phone": "47475457674",
                  "plate": "CBX56789",
                  "email": "john@example.com",
                  "password": "encrypted_password"
                }
            """;
    public static final String POSTOCCUPY = """
                {
                  "id": "1",
                  "plate": "CBX56789",
                  "startTime": "2023-10-01T15:00:00.000Z",
                  "endTime": "2023-10-01T17:00:00.000Z",
                }
            """;
}
