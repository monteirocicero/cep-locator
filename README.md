# cep-locator

Aplicação Spring boot com API REST rodando no Jetty 9.

Instruções para execução da aplicação, após fazer o clone do projeto:

- Entrar no prompt de comando
- Na raiz do projeto, executar o comando com maven instalado: mvn clean package.
- Logo em seguida, java -jar target/cep-locator-0.0.1-SNAPSHOT.jar.
- O Jetty será iniciado: Jetty started on port(s) 8080 (http/1.1).
- A aplicação estará respondendo na uri: /api/cep/{numeroCep}.

Exemplo de requisição via curl:

curl -i http://localhost:8080/api/cep/01005003
ou via browser
http://localhost:8080/api/cep/01005003

OBS: No momento a aplicação está rodando com dados mockados apenas os seguintes cep encontram-se disponíveis:

01311923, 01046925, 01014010, 01046010, 01005000, 01005001, 01005002, 01005003.
