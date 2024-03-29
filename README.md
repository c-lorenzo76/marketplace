<p align="center">
    <a href="" target="_blank">
        <img src="https://wiki.melvoridle.com/images/4/4e/Ancient_Market_%28poi%29.png" height="100px" alt="market">
    </a>
    <h1 align="center" style="font-family: 'Poppins', sans-serif; text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);">Cambium</h1>
    <br>
</p>

## Motivation
The inspiration for Cambium was sparked by the web design unidenonline.com, 
a platform known for its niche focus of techwear fashion. I set out to develop 
'Cambium' a fictional store to showcase unique and captivation of fashion finds, 
offering a browsing experience for enthusiasts.

## Tech Stack
> Java |
> Spring Framework 


## Directory Structure
      src/                contains all source files 
        config/           contains application security configurations
        controller/       contains web controller classes
        dto/              contains files for requests 
        entity/           contains model classes
        repository/       contains querys methods to interact with database
        service/          contains business logic between controller and repository
        util/             contains mapper config for conversion of DTO to entities

        resources/        contains sql database, application properties, and progress notes

## Installation
You can install the project using the following command
```
git clone https://github.com/c-lorenzo76/marketplace.git
```

## Notes
You will have to manually create a database in MySQL or MariaDB and 
edit the file 'application.properties' with your database information: 
```
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR-DATABASE-NAME
spring.datasource.username=root
spring.datasource.password=
```


 