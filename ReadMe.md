

``1. Rest Controllers should be either in the same package as springbootconfiguration application.``

Error:
    {"timestamp":"2020-01-10T22:06:08.566+0000","status":500,"error":"Internal Server Error","message":"No converter found for return value of type: class com.example.model.Book","path":"/books"}
Resolution:
    Added default constructor and getters and setters on the POJO
    
@Valid
    Without this annotation, validations on the POJO properties won't come to effect.   
    
Example Validations:
    curl -v -X POST localhost:8080/books -H "Content-type:application/json" -d "{\"name\":\"ABC\"}"
    
Example Class level Validations
    curl -v -X POST localhost:8080/books/0  
    
Example Format Validation
    curl --location --request POST 'http://localhost:8080/books' \
    --header 'Content-Type: application/json' \
    --data-raw '{"name":"ABC", "author":"ABC", "price":"as"}'
    
Lombok example:
    https://www.baeldung.com/intro-to-project-lombok
    curl --location --request POST 'http://localhost:8080/builder' \
    --header 'Content-Type: application/json' \
    --data-raw '{"name":"test", "phone":"1234"}'
    
Note:
    To enable debug logging, use --debug in "Program Arguments"
    
Autowiring: https://blog.marcnuri.com/field-injection-is-not-recommended/

Note: lombock introduces @Slf4j

Fine tuned logging : https://www.baeldung.com/spring-boot-logging

Note: Field injection is not recommended: https://blog.marcnuri.com/field-injection-is-not-recommended/

Solid principles: https://en.wikipedia.org/wiki/SOLID

Maven dependency scopes: https://howtodoinjava.com/maven/maven-dependency-scopes/

Running application: java -jar target/demo-0.0.1-SNAPSHOT.jar 

Swagger:
    If not method type is put for an api it is open for all method types.
    Reference: 
     https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
     https://www.javainuse.com/spring/boot_swagger
     
