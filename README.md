Skeleton Spring Boot + Multi-module Gradle
======================

Installation and Usage
---------------------

* `git` checkout.
* run command `npm install` (will install all the node modules)
* run command `npm install -g gulp` (will install gulp globally, if not already installed)
* run command `gradlew clean build` from inside the project's root
* run `RunApplication.java` to start the application's back-end (make sure the database is up and running, see below (*))

* the application's back-end base url is: `http://localhost:8080`

Database (*):
* Start a local MySQL server (for example with xampp)
* Create a database named `skeleton`, username = root, no password
* Make sure the MySQL is accessible through `127.0.0.1` or `localhost` (should be default behaviour)
