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

# Ex. 8 Create Managers Endpoint
Create a `ManagerController` that contains the following endpoint:

`GET student{id}/api/v1/managers`

This endpoint returns a List of Managers (add a Manager model to your student directory).
