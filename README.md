Cegeka's Starters
======================

A project by Cegeka's finest starters.

Installation and Usage
---------------------

* `git` checkout.
* run command `npm install` (will install all the node modules)
* run command `npm install -g gulp` (will install gulp globally, if not already installed)
* run command `gradlew clean build` from inside the project's root
* run `StarterApplication.java` to start the application's back-end (make sure the database is up and running, see below (*))
* run command `gulp start` from inside `/starter-ui` to start the application's Angular frontend (see the README.md in `/starter-ui`)

* the application's back-end base url is: `http://localhost:8080`
* the application's frontend (angular) base url is: `http://localhost:3000/#/`

Database (*):
* Start a local MySQL server (for example with xampp)
* Create a database named `starter`, username = root, no password
* Make sure the MySQL is accessible through `127.0.0.1` or `localhost` (should be default behaviour)


TODO (Starters, take notice)
---------------------

* The generated public folder of the starter-ui module is not yet included in the generated jar/war
    * it could be copied to the webapp folder of the `deploy` module, it will then be package inside the jar/war en served when running.    
* The Angular setup from the `ui` module is very basic: consider transforming it to a component structure OR use Angular 2.