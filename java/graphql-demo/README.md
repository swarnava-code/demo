# Graphql Demo


## Graphiql - Test tool for graphql
```properties
spring.graphql.graphiql.enabled=true
```
[http://localhost:8080/graphiql?path=/graphql](Graphiql Test tool)


## Postgres Db Setup
[docker-compose.yml](docker-compose.yml)
```shell
docker compose up
```
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/graphql-db
spring.datasource.username=graphql
spring.datasource.password=graphql
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
```
