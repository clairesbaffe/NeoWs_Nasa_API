# Asteroids Data Scraper

Asteroids Data Scraper is an API using a NASA public API, NeoWs, referencing all near Earth objects. Asteroids Data Scraper sends requests to the NASA public API, scrapes its data into a database and makes a CRUD on this data stored in the database.

## Start the project

You need to add a `application.properties` file to the project (`src/main/resources/application.properties`) and add project configuration :
- database connexion (url, username, password)
- Hibernate config
    ``` properties
    spring.jpa.hibernate.ddl-auto=none
    spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
    spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
    spring.jpa.properties.javax.persistence.schema-generation.database.action=none
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```
- Flyway config
    ``` properties
    spring.flyway.locations=classpath:db/migration,classpath:db/migration/testdata
    spring.flyway.enabled=true
    spring.flyway.out-of-order=true
    ```
- connections config (cors and target)
- jwt secret

Define an environment variable called `NASA_API_KEY` with your NASA public API key.