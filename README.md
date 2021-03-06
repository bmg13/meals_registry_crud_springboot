# Meals registration and management using SpringBoot with Three Tier Architecture

A small backend project using Spring Boot to perform CRUD operations, across multiples microservices. This project is a simple example of using SpringBoot and storing data in a relational DB. The Three Tier Architecture is used, separating the controller, service and persistence layers. 

## Application

This consists in a CRUD application using SpringBoot. Three major components must be considered: Meal, MealItem and Sale. Everyone of this is separated to a own module, consisting in three different maven projects.


Regarding each model, they are separated in three different layers:   

- Controller 
- Service 
- Persistence

This division allows to only provide the client with the API, not exposing service or even DB logic. It is an extra step of protection. Additionally, the Service layer cannot directly access the database, being only responsible for the logic of the application instead. This is the ***Three Tier Architecture***. If more information is needed, please read the link available in the end.
To further the decoupling, DTO's are used in the API to ensure that the app only exposes non-confidential information. Mappers are then implemented to ease this communication.



### Controller

This layer exposes the API of the application. SpringBoot eases the implementation, only requiring the definition of the class (as a controller) and each action.
In order to define a class as a Controller, using SpringBoot's annotations it becames very straightforward.

```
@Controller
@RequestMapping(
        path = "/meal",
        produces = MediaType.APPLICATION_JSON_VALUE)
```

Regarding a specific action:

```
@GetMapping(path = "/id/{mealId}")
public ResponseEntity<MealDTO> getSingleMeal(@PathVariable long mealId) {
    return ResponseEntity.ok(this.mealService.getSingleMeal(mealId));
}
```

Simply setting the mapping as a "GET" and the respective path, as well as the path variable as a parameter, it is possible to define completely this action.

REST is used as an Architectural Pattern and each module is able to communicate with the remaining ones using this layer.



### Service

The Service layer is responsible for all the most important business logic. Every process that requires any update, creation, mapping, etc. is here.
SpringBoot is famous for allowing to annotate each class, and, regarding a service class, it even provides a specific annotation ```@Service```. This is similar to the "Component" annotation, setting this class as a singleton and giving the reader the easier understanding of its need.

So, each service uses the Dependency Injection and, since these classes interact with eachother and repositories, this injection is simply made by the "Autowired" annotation. This is a very interesting subject and it is recomended to read the link to the Baeldung blog explaining this.
The next is an example of this usage. The injection by annotation and the use of it in a method. No additional configuration has to be considered.

```
     @Autowired
    private MealRepository mealRepository;

    @Autowired
    private NutritionDataService nutritionDataService;

    public void createMeal(MealDTO mealDTO) {
        LOGGER.info("About to create a meal.");
        this.nutritionDataService.createNutritionData(mealDTO.getNutritionData());
        this.mealRepository.saveAndFlush(MealMapper.mapMealDTOToMeal(mealDTO));
        LOGGER.info("Meal created.");
    }
```

Please note that the entry parameter is a DTO, showing the abstraction previously mentioned, since this method is called by a controller.



### Persistence

This final layer works as an abstraction of the DB. Basically, the tables' structure is defined in the "Entities" classes. The following is a an example. 

```
@Entity
@Table
public class Meal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mealId;

    @Column
    private NutritionData nutritionData;

    @Column
    private int quantityToSell;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfFood typeOfFood;

    @Column
    private String photo;

    @Column
    @ElementCollection
    private List<Ingredient> ingredients;

    @Column(unique = true)
    private String designation;

    @Column
    private int quantitySold;

    @Column
    @ElementCollection
    private List<Allergen> allergen;
```

Here is important to focus on "@Entity" and "@Table" since they establish (with much added code) what this class represents. The "@Table" allows providing a name to ease even more the mapping to the DB, however when the name is the same, this is not necessary.
The "@Id" and  "@GeneratedValue" allow to define this as the ID of the table and indicate on how it is set. Please check the respective documentation (link below) to understand more.

With this mapping set, it is important to define the repository classes. These allow to interact with the DB and can now be easily created, just by simply extending the ```JpaRepository``` and add queries only to specific needed scenarios. The following is an example of this.

```
@Repository
@Transactional
public interface MealRepository extends JpaRepository<Meal, Long> {

    Meal findById(long mealId);

    Meal findByDesignation (String designation);
}
```

## DB

To store the data, a relational database is used. In this specific case, PostgreSQL is used. Since these are maven projects, the driver used and other related information are merely added as a dependency to the pom.

```
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```


To completely use this connection, it is necessary to indicate the data access credentials, host and jpa properties to the "application.properties" file.

```
spring.jpa.hibernate.ddl-auto=create
logging.level.root=INFO
logging.level.org.springframework=INFO
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
## PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/meal
spring.datasource.username=postgres
spring.datasource.password=password
```


To validate the operations, the respective PostgresSQL workbench was used and directly queried on.


## References

- https://spring.io/projects/spring-boot
- https://www.jinfonet.com/resources/bi-defined/3-tier-architecture-complete-overview/
- https://www.codecademy.com/articles/what-is-rest
- https://www.baeldung.com/spring-dependency-injection
- https://docs.oracle.com/javaee/7/api/javax/persistence/GeneratedValue.html
- https://www.postgresql.org/
