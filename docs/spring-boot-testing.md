In Spring Boot testing, these tools are used at **different layers of testing**. Think of them as fitting into **unit testing vs integration testing vs controller testing**.

---

##  1. **MockMvc**

###  When to use:

Use **MockMvc** when you want to **test the Controller layer without starting the server**.

###  Key Idea:

* Simulates HTTP requests
* No real server (fast)
* Only tests **Spring MVC layer**

###  Typical Use Case:

* Testing REST endpoints (`@RestController`)
* Validating request/response
* Checking status codes, JSON response

###  Example:

```java
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUser() throws Exception {
        mockMvc.perform(get("/users/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1));
    }
}
```

###  When NOT to use:

* When you need full DB + service integration

---

##  2. **TestRestTemplate** (TestRestClient)

###  When to use:

Use **TestRestTemplate** when you want to **test the full application with a running server**.

###  Key Idea:

* Starts embedded server (`@SpringBootTest`)
* Makes **real HTTP calls**
* Full integration test

###  Typical Use Case:

* End-to-end testing
* Testing complete flow: Controller → Service → Repository → DB

###  Example:

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetUser() {
        ResponseEntity<String> response =
            restTemplate.getForEntity("/users/1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
```

###  When NOT to use:

* For fast unit tests (it's slower)

---

## 3. **@Mock**

### When to use:

Use **@Mock** when you want to **create a fake object** for unit testing.

###  Key Idea:

* Provided by Mockito
* No Spring context required
* Used in **pure unit tests**

###  Typical Use Case:

* Mock dependencies (e.g., Repository inside Service)
* Isolate business logic

###  Example:

```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void testService() {
        when(userRepository.findById(1L))
            .thenReturn(Optional.of(new User()));

        // test logic
    }
}
```

---

## 4. **@InjectMocks**

###  When to use:

Use **@InjectMocks** when you want to **inject mocked dependencies into a class under test**.

###   Key Idea:

* Combines with `@Mock`
* Automatically injects mocks into the class

###   Typical Use Case:

* Testing service layer with mocked repository

###   Example:

```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testService() {
        when(userRepository.findAll())
            .thenReturn(List.of(new User()));

        List<User> users = userService.getAllUsers();
        assertEquals(1, users.size());
    }
}
```

---

## 5. **@SpringDataJpaTest**

###  When to use:

Use **`@SpringDataJpaTest`** when you want to **test only the JPA Repository layer**.

---

##   Key Idea:

* Loads **only JPA components**
* Configures:

  * `EntityManager`
  * Hibernate
  * Spring Data Repositories
* Uses **in-memory DB (like H2)** by default
* **Does NOT load controllers/services**

---

##   Typical Use Case:

* Test custom queries (`@Query`)
* Test JPA relationships (OneToMany, ManyToOne)
* Validate database constraints
* Verify CRUD operations at repository level

---

##   Example:

```java
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        User user = new User();
        user.setEmail("test@gmail.com");
        userRepository.save(user);

        Optional<User> result =
            userRepository.findByEmail("test@gmail.com");

        assertTrue(result.isPresent());
    }
}
```

---

##   What gets loaded?

*  Entity classes
*  Repository interfaces
*  Hibernate + JPA config
*  No Controllers
*  No Services

---

##   Important Notes:

* Runs each test in a **transaction (auto rollback)**
* Faster than full `@SpringBootTest`
* Uses **embedded DB unless overridden**

---

##   If you want real DB:

```java
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
```

---
##  Quick Comparison Table


| Tool                 | Layer      | Server | DB     | Speed   | Use Case           |
| -------------------- | ---------- | ------ | ------ | ------- | ------------------ |
| **MockMvc**          | Controller |  No   |       |  Fast  | Test REST APIs     |
| **TestRestTemplate** | Full App   |  Yes  |       |  Slow | End-to-end testing |
| **@Mock**            | Unit       |  No   |       |  Fast  | Fake dependencies  |
| **@InjectMocks**     | Unit       |  No   |       |  Fast  | Inject mocks       |
| **@DataJpaTest**     | Repository |  No   |  (H2) |  Fast  | Test DB layer      |

---

##  Final Layer Mapping (Very Important)

| Layer      | What to Use                            |
| ---------- | -------------------------------------- |
| Controller | `@WebMvcTest` + `MockMvc`              |
| Service    | `@Mock` + `@InjectMocks`               |
| Repository | `@DataJpaTest`                         |
| Full App   | `@SpringBootTest` + `TestRestTemplate` |

---

##  Simple Mental Model

Think of testing like layers:

```
Controller → Service → Repository → Database
```

| Layer      | Tool             |
| ---------- | ---------------- |
| Controller | MockMvc          |
| Service    | Mock             |
| Repository | DataJpaTest      |
| All Layers | TestRestTemplate |

---



