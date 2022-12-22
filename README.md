# API for retrieving contacts
This is a REST API microservice built as practice for Spring boot. 

## Endpoints

#### /contact
* `POST`: Create a contact

#### /contact/all
* `GET` : Get all contacts

#### /contact/:id
* `GET` : Get a contact by the contact id
* `PUT` : Update a contact by the contact id
* `DELETE` : Delete a contact by the contact id

## Concepts utilized
1. **Three-layer architecture design**: Presentation (Controller, Model, View), Business (Service), Data Access (Repository) layers
2. **Beans and Dependency Injection**
    1. `@Component`, `@Controller`, `@Service` annotations for turning a class into a Spring Bean to be stored in the Spring Container
    2. `@Autowired` annotation to inject the bean into the class that needs it
3. Mapping HTTP requests to Controller handler methods with **Request Mapping Annotations**:
    1. **`@GetMapping("<URI path>")`** :  @GetMapping annotated methods handle the HTTP GET requests matched with the given URI expression
    2. **`@PostMapping("<URI path>")`** :  @PostMapping annotated methods handle the HTTP POST requests
    3. **`@PutMapping("<URI path>")`** :  @PutMapping annotated methods handle the HTTP PUT requests
    4. **`@DeleteMapping("<URI path>")`** : @DeleteMapping annotated methods handle the HTTP DELETE requests
4. `@ResponseBody` annotation: **Serialize an object that the handler method returns into JSON**, before sending the response to the client
5.  Creating a Controller specifically for RESTful APIs with **`@RestController`**.
    * It is effectively `@Controller` + `@ResponseBody`
6. **`@ResponseEntity`** annotation: Allows for the **configuration of a whole HTTP response**, containing a body, status code and headers.
7. **`@PathVariable`** annotation: Used to **handle template variables in the request URI mapping**, and set them as method parameters.
    * E.g. In the URI mapping @GetMapping("/contact/{id}"), the id template variable will be extracted and set as a method parameter.
8. **Validation** - Setting contraints with annotations, with the Spring Boot validator dependency
    * `@NotBlank`: Checks that a character sequence's trimmed length is not empty

## Dependencies
* **Spring Web**: Launch a Tomcat Http server
* **Spring Boot DevTools**: Live reload
* **Spring Boot Validation**: For validation of user input fields

