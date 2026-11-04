# HomeBanking Lite

Un'applicazione web di home banking personale sviluppata con Java e Spring Boot.

HomeBanking Lite è un'applicazione web che simula un ambiente bancario personale, consentendo agli utenti di autenticarsi in modo sicuro, visualizzare i propri conti correnti, consultarne i saldi e controllare lo storico delle operazioni.

[🇬🇧 Read the English version](README.md)

## Funzionalità

- Accesso sicuro tramite username e password.
- Dashboard personale con informazioni sul cliente e saldo totale.
- Panoramica dei conti correnti con saldi individuali e IBAN.
- Visualizzazione degli ultimi movimenti nella dashboard.
- Consultazione dello storico completo dei movimenti.
- Filtraggio dei movimenti per conto corrente.
- Logout sicuro.

## Tecnologie utilizzate

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Thymeleaf
- HTML5
- CSS3
- Maven

## Architettura

L'applicazione segue un'architettura a livelli, che permette di separare le diverse responsabilità:

- **Controller:** gestisce le richieste HTTP e la navigazione dell'applicazione.
- **Service:** contiene la logica applicativa.
- **Repository:** gestisce l'accesso ai dati tramite Spring Data JPA.
- **Model:** rappresenta le entità e i dati dell'applicazione.
- **View:** presenta l'interfaccia utente attraverso i template Thymeleaf.

## Sicurezza

- Autenticazione gestita tramite Spring Security.
- Password memorizzate sotto forma di hash BCrypt.
- Credenziali locali del database mantenute al di fuori del repository pubblico.

## Configurazione del database

L'applicazione utilizza MySQL come database relazionale.

Per configurare il database locale:

1. Creare un database MySQL denominato `homebanking_lite`.
2. Configurare i parametri di connessione nel file `application-local.properties`.
3. Utilizzare il file `application-local.example.properties` come modello di configurazione.

Il file di configurazione locale è escluso da Git per evitare la pubblicazione delle credenziali del database.

## Avvio dell'applicazione

### Requisiti

- Java 21
- MySQL
- Maven (oppure il Maven Wrapper incluso nel progetto)

### Procedura

1. Clonare il repository:

   ```bash
   git clone https://github.com/DavideMantuano/homebanking-lite.git   
2. Importare il progetto nell'IDE Java preferito.
3. Creare e configurare il database locale.
4. Configurare il file application-local.properties.
5. Avviare l'applicazione Spring Boot.
6. Aprire il browser e visitare: http://localhost:8080

   
###Stato del progetto
Questo progetto è stato sviluppato come progetto personale di portfolio per approfondire lo sviluppo backend in Java e l'ecosistema Spring.
L'applicazione simula un ambiente bancario personale utilizzando dati fittizi di clienti e movimenti. Non è collegata a servizi bancari reali.

##Autore

**Davide Mantuano**

- GitHub: [DavideMantuano](https://github.com/DavideMantuano)