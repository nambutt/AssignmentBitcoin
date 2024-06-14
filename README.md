
# Bitcoin Price API
This project is a Spring Boot application that fetches current Bitcoin price data from the CoinDesk API, saves it to a MySQL database, and provides RESTful endpoints to retrieve the data.


## Tech Stack

* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* RestTemplate
* JUnit 5
* Maven



## Installation

1. Clone the repository:

```bash
  git clone https://github.com/yourusername/bitcoin-price-api.git
  cd bitcoin-price-api
```

2. Set up MySQL:

```bash
create database assignment;

CREATE TABLE assignment.bitcoin (
    id INT NOT NULL,
    disclaimer Varchar(50),
    chartname varchar(20),
    PRIMARY KEY (id));
  
CREATE TABLE assignment.`time` (
    time_id INT NOT NULL AUTO_INCREMENT,
    updated varchar(50),
    updateduk varchar(50),
    updatedISO varchar(50),
    PRIMARY KEY (time_id));
  
CREATE TABLE assignment.`bitcoin-price-index` (
    bpi_id INT NOT NULL AUTO_INCREMENT,
    `code` varchar(50),
    symbol varchar(50),
    rate varchar(50),
    description varchar(50),
    rate_float float, 
    PRIMARY KEY (bpi_id));
  
select * from assignment.bitcoin;
select * from assignment.`bitcoin-price-index`;
select * from assignment.time;
```
3. Configure the application:
Open src/main/resources/application.properties and set your MySQL credentials:

```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/assignment?    useSSL=false
  spring.datasource.username=root
  spring.datasource.password=your_password
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
  spring.jpa.hibernate.ddl-auto=update

```
4. Build and run the application:
```bash
  mvn clean install
  mvn spring-boot:runate

```
## Usage

* Fetching and Saving Bitcoin Prices
To fetch the latest Bitcoin prices and save them to the database, send a Get request to:
```javascript
Get /api/fetch-and-save
```
* Retrieving Saved Bitcoin Prices
To retrieve all saved Bitcoin price data, send a GET request to:
```javascript
Get /api/show-data
```
## DB Schema

The application uses three main tables:

* time: Stores information about the time when the data was updated.
* bitcoin-price-index: Stores information about each currency's exchange rate.
* bitcoin: Stores general information about the Bitcoin price, including the disclaimer and chart name.


## Run Test

```bash
    mvn test

```
## Contributing

Contributions are always welcome!

Please adhere to this project's `code of conduct`.


## License

[MIT](https://choosealicense.com/licenses/mit/)

