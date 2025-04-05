# StudentSys

Heiheiheihei!!

En enkel backend-applikasjon for administrasjon av studentinformasjon bygget med Spring Boot og PostgreSQL. 
Applikasjonen lar deg opprette, hente, oppdatere og slette studentprofiler.

# Teknologier brukt
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- REST API
- Maven

## Endepunkter

| Metode  | Endpoint        | Beskrivelse                |
| ------- | --------------- | -------------------------- |
| GET     | /students       | Henter alle studenter      |
| GET     | /students/{id}  | Henter en student med ID   |
| POST    | /students       | Oppretter en ny student    |
| PUT     | /students/{id}  | Oppdaterer en student      |
| DELETE  | /students/{id}  | Sletter en student        |

## Oppsett lokalt

1. Klon repoet:
   ```bash
   git clone https://github.com/Nourkhalil0/StudentSys.git

2. Gå inn i prosjektmappen: cd StudentSys
3. Konfigurer application.properties med din PostgreSQL-database.
4. kjørrrrr: ./mvnw spring-boot:run
