# Java SpringBoot Data Access
Helper project used to access a MySQL database.

# Getting Started
- Create new local directory
- Clone this repo in that directory: `git clone git@github.com:mburolla/siu-java-spring-boot-da-1.git`
- Create `src/main/resources/application.properties` file 
- Copy and pastes contents from `application.properties.template` file to `application.properties` file
- Update DB credentials fields in `application.properties` file
- Run the project
- Use ReST client to test an endpoint

# Workflow
- Branch from `dev` branch using the following naming schema:
  - dev-{your two letter initials}-{excerise number}
  - Example: `git checkout -b dev-mb-ex1`
  - Do work on this branch
  - Before you commit, check the status of files that have been changed: `git status`
  - Stage your files: `git add --all`
  - Add a commit message: `git commit -m "Finish ex1"`
  - Push your branch: `git push origin dev-mb-ex1`

# Endpoints

|Action|Message|
|------|-------|
|GET   |http://localhost:8080/instructor/api/v1/message|
|GET   |http://localhost:8080/student1/api/v1/message|
|GET   |http://localhost:8080/student2/api/v1/message|
|GET   |http://localhost:8080/student3/api/v1/message|
|GET   |http://localhost:8080/student4/api/v1/message|
|GET   |http://localhost:8080/student5/api/v1/message|
|GET   |http://localhost:8080/student6/api/v1/message|
|GET   |http://localhost:8080/student7/api/v1/message|
|GET   |http://localhost:8080/student8/api/v1/message|
|GET   |http://localhost:8080/student9/api/v1/message|
|GET   |http://localhost:8080/student10/api/v1/message|
