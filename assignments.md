# Assignments

# Ex. 1
Update the `MessageController` in your student package with your first name only.  Submit a PR wait
for the instructor to approve it.  Once it has been approved, get the latest changes for the `dev` branch
and delete your working branch for this exercise. 

# Ex. 2
Update the `MessageController` in your student package with your first AND last name.  Submit a PR wait
for the instructor to approve it.  Once it has been approved, get the latest changes for the `dev` branch
and delete your working branch for this exercise. 

# Ex. 3
Update the `MessageController` in your student package with your first AND last name AND middle initial.  Submit a PR wait
for the instructor to approve it.  Once it has been approved, get the latest changes for the `dev` branch
and delete your working branch for this exercise. 

# Ex. 4
Update the `MessageController` in your student package with your first AND last name AND middle initial AND your
favor color.  Submit a PR wait
for the instructor to approve it.  Once it has been approved, get the latest changes for the `dev` branch
and delete your working branch for this exercise.

# Ex. 5
Update the `MessageController` in your student package with your first AND last name AND middle initial AND your
favor color AND favorite band.  Submit a PR wait
for the instructor to approve it.  Once it has been approved, get the latest changes for the `dev` branch
and delete your working branch for this exercise.

# Ex. 6 Return Hardcoded Book
Create a `BookController{studentid}` in your student package that has supports the following endpoint:

`GET student{id}/api/v1/book`

Create a `Book` model and place it in your student model package.  The `Book` model must align with the `Book` table in 
the database.  Delete the test class in your model directory, it was just a placeholder because Git does not
like empty directories.

The endpoint returns an arbitrary hardcoded book of your choice.

Create a request in Postman that hits this new endpoint:

`localhost:8080/student{your id}/api/v1/book`

# Ex. 7 Connect Book Endpoint to Database
Follow the example from the reference repo and use a `JDBCTemplate` to return book id 1 from the database in your `BookController`.

`https://gitlab.com/mburolla/java-spring-boot-web-api-2/-/blob/step-4/src/main/java/com/example/demo/service/DataAccess.java#L40`

# Ex. 8 Create Managers GET Endpoint
Create a `ManagerController` that contains the following endpoint:

`GET student{id}/api/v1/managers`

This endpoint returns a List of all the Managers from the managers table. Add a Manager model to your 
student directory.

# Ex. 9 Create Managers POST Endpoint
Create the following endpoint in your `ManagerController`:

`POST student{id}/api/v1/managers`

This endpoint will add (insert) a manager into the `managers` table.  Create a POST request in Postman
and be sure to add the following header for this request:

`Content-Type` `application/json`

---

#### Christmas

---
# Ex. 10 After Christmas Warmup 
Update the `MessageController` in your student package to include something that you got for Christmas
this year ("sleep" is an acceptable answer).  Submit a PR wait for the instructor to approve it.  Once it has been approved, get the latest changes for the `dev` branch
and delete your working branch for this exercise. 

# Ex. 11 Create Managers PUT Endpoint
Create the following endpoint in your `ManagerController`:

`PUT student{id}/api/v1/managers`

This endpoint will update a manager into the `managers` table.  Create a PUT request in Postman
and be sure to add the following header for this request:

`Content-Type` `application/json`

# Ex. 12 Create Book Endpoint
Create the following endpoint in your `BookController`:

`POST student{id}/api/v1/bookstores/{bookstoreId}/books`]

This endpoint inserts one book into the `book` table and links this book to an existing bookstore
in the `bookstore_book` table.

HINT: The `namedParameterJdbcTemplate` may be useful to you.

# Ex. 13 Bookstore Inventory
Create the following endpoint in a new controller `BookStoreController`:

`GET student{id}/api/v1/bookstores/{bookstoreId}/books`

This endpoint calculates the price of all the books in a bookstore and returns a list of books:

```
 [
    {
      "book_id": <book id>
      "title": <book title>
      "isbn": <isbn>
      "quantity: <quantity>
      "price" : <price>
      "total_price": <total price for all these books in the bookstore>
    }
    ... 
 ]
```

# Ex. 14 Technical Debt: Controllers Are Not Ideal
Ideally, controllers should be as lightweight as possible.  Most (or all) of the work in a 
controller should be done in one or more classes. 

Create a class called `DataService{studentid}` and place it in a new student package under the 
service package (Be sure to append your student id to this class to avoid namespace collisions 
with SpringBoot).  Also be sure to annotate this class as a `@Service`.

Move the code from the endpoints into the controllers into public methods
in the `DataService` class.  All the controllers should resemble the following:

```java
@RestController
public class ProductController {

   @Autowired
   private DataService instructorDataService;

   @GetMapping("instructor/api/v1/products")
   public List<Product> getProducts() {
       return instructorDataService.getProducts();
   }
}
```

# Ex. 15 SpringData JPA: Gym Endpoint
Copy the approach used in the [reference repo](https://gitlab.com/mburolla/java-spring-boot-spring-data-mysql/-/blob/main/src/main/java/com/xpanxion/springboot/mysql/demo/controller/ProductController.java) for the Product
controller, but instead of a Product entity, use a Gym entity.

Create a `GymService{studentId}` in your student service package.  Create a
`GymRepository{studentId)` in a student package under the repository
package.  `GymService` contains a `GymRepository` as a private data member.

Create a method on the `GymService` called addGym that accepts a model
called `Gym`.  The `Gym` model has the following fields:

- id
- name
- street1
- street2
- city
- state
- zip

Create the following endpoint:

`POST student{id}/api/v1/gym`

The endpoint contains a reference to the `GymService` and adds a gym to the
gym table.

# Ex. 16 Find Gyms
Create the following endpoint:

`GET student{id}/api/v1/gym?name={partial gym name}`

This endpoint will use SpringData JPA to return all the gyms that have a similar name:

For example:
`GET student{id}/api/v1/gym?name=Gold`

Output:
```
[
 {
   "id": 1,
   "name": "Gold's Gym of New York"
 },
 {
   "id": 2,
   "name": "Gold & Silver Gym"
 },
 {
   "id": 3
   "name": "Golden Oldies Gym for Old Folks Like Me"
 }
]
```

# Ex. 17 Member
Create the following endpoint:

`POST student{id}/api/v1/gym/{gymId}/member`

This endpoint adds a member for the specified `gymId`.  A member has the following attributes:

- id
- gymId
- first name
- last name
- date of birth
- subscription start date
- subscription end date

Make sure to link this member to the Gym.

# Ex. 18 Add Member Workout History
Create the following endpoints:

- `POST student{id}/api/v1/member/{memberId}/checkin?time=2021-12-30 13:48:28`
- `POST student{id}/api/v1/member/{memberId}/checkout?time=2021-12-30 13:48:28`

This endpoint allows the API to keep track of a person's workouts.  Be sure link to the memberId. 
This endpoint should echo the arguments passed into it.  If a member id is passed into this endpoint,
the endpoint should return an HTTP status code of `404`: `Member id not found`.  Otherwise 
return an HTTP Status code of `200`.


# Ex. 19 Get Member Workout History
Create the following endpoint:

- `GET /instructor/api/v1/member/{memberId}/workout-history`

This endpoint returns the workout history for a user:

Example output:
```
[
    {
        "memberId": 32,
        "timeUtc": "2022-01-02T19:48:28.000+00:00",
        "checkType": "CHECK_IN"
    },
    {
        "memberId": 32,
        "timeUtc": "2022-01-02T19:48:28.000+00:00",
        "checkType": "CHECK_OUT"
    },
    {
        "memberId": 32,
        "timeUtc": "2022-01-02T14:48:28.000+00:00",
        "checkType": "CHECK_IN"
    },
    {
        "memberId": 32,
        "timeUtc": "2022-01-02T15:48:28.000+00:00",
        "checkType": "CHECK_OUT"
    }
]

```

It should return an HTTP status code of `404` if a member is not found.


# BONUS: 405 Method Not Allowed
Tired of seeing this error in Postman?  Me too!

Start a new IntelliJ project and create a Java commandline tool that creates a function signature 
for a SpringBoot ReST endpoint. The program works something like this:

Input:
```
HTTP Method: GET
URI: api/v1/products/{productId}/stuff?page=page&size=size
Model: None
Name: getAllProducts
Return: List<Product>
```

Output:
```
@GetMapping("api/v1/products/{productId}/stuff")  //?page=page&size=size
public List<Product> getAllProducts(@PathVariable productID, @RequestParam int page, @RequestParam int size) {
```

---

Input:
```
HTTP Method: POST
URI: api/v1/products/
Model: Product
Name: addProduct
Return: Product
```

Output:
```
@PostMapping("api/v1/products/")
public Product getAllProducts(@RequestBody Product product) {
```


Be sure to:
- Create a new GitHub repo in your account
- Create a nice ReadMe that describes:
  - The problem that this solves
  - How to use this tool & examples
- Sell it for $1.2M
- Give Marty %10
