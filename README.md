# odj-starter-springboot-datastore-minimal- 
A starter application for ODJ with DataStore, written in Java with Spring Boot.

## Building the application

### Gradle 

    ./gradlew clean build
    
### Docker

1. First, create a directory "auth" under the project root and copy your Google Authentication JSON file into it
2. Issue Docker build:

        docker build --build-arg ODJ_GOOGLE_APPLICATION_CREDENTIALS=auth/<your_file>.json . -t odj-datastore
    
    
## Running the application

### Docker

    ./docker-run.sh 

### Local: Using the Spring Boot Shell

Make sure you have install the Shell binary. Recommended is using sdkman:

    sdk install springboot
    
    
Start the application interactively

    gradle clean bootRun
    
    
### Adding a product

POST a JSON request to <host>:<port>/product as follows:

...
    

### Finding products by EAN

Make a GET request to <host>:<port>/product/ean/<ean>
    
...        
        
