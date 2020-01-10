

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