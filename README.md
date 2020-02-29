# simulados

Projeto que visa construir api de Simulado.

### Tecnologias utilizadas

- Java 8
- Maven
- Spring Boot
- Spring Data Jpa
- Flyway
- PostgreSQL

### Rodando localmente

Antes de rodar a aplicação é necessário configurar o PostgreSQL localmente na porta 5432 e criar a base 'simulados'

```sh
mvn clean compile spring-boot:run -Dspring-boot.run.profiles=dev
```

### Acessando remotamente

Acessar link https://simulados-igor.herokuapp.com/

