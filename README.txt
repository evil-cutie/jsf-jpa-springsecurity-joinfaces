INSTALLING AND RUNNING THE PROJECT:

1. Installing and running postgresql
    Use any convenient package manager, e.g. brew to install postgres. For brew, run this line in terminal:

        brew install postgresql

    To run/stop the service use these commands:

        brew services start postgresql
        brew services stop postgresql

2. Creating a Database Server
    Once you started a postgresql service, run this to create a new server:
        // for logging in postgres service
            psql postgres

        // creating a new server
            CREATE ROLE newUser WITH LOGIN PASSWORD ‘password’;
            ALTER ROLE newUser CREATEDB;

        // exiting postgres service
            \q

3. Install pgAdmin and log in with your username and password
    Once logged in, create a new database that you will use for this project

4. Open the project in your IDE.
    If you use Eclipse or Netbeans you may need to convert it first.
    If you use Intellij, just create a new project from existing source.

5. Installing Lombok plugin
    Some IDEs have it bundled, but some don't. Check if you need to install it before running the application.
    If you work with Intellij, you may need to enable annotation processing:

        Go to File > Settings (or IntelliJ IDEA > Preferences on macOS).
        Navigate to Build, Execution, Deployment > Compiler > Annotation Processors.
        Check the "Enable annotation processing" box.
        Ensure "Obtain processors from project classpath" is selected

6. Setting up a JDBC connection and running the project
    Go to src > main > resources > application.properties file and set up the connection with the database you've created earlier

        spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
        spring.datasource.username=username
        spring.datasource.password=password

    To seed initial data, uncomment these lines:

        spring.jpa.defer-datasource-initialization=true
        spring.sql.init.mode=always

    You will need it only for initial build to make some data entries which come from the data.sql file.
    Your IDE will probably detect a Spring Application running configuration, so you don't need any special setup to run it.
    After successful build, you can check in pgAdmin if the tables were created and the data was entered.
    If so, remove those two lines from the application.properties

    Alternatively, you can run the project without data.sql
    Remove those two lines from the configuration file and run the project. You will see that the tables were create but with no data
    Copy data.sql in pgAdmin query console and run it (please don't change the order of queries as it may cause unexpected errors)

    Now that the application is running, head to the http://localhost:8080/ and explore!

    PLEASE MAKE SURE THAT YOU HAVE A POSTGRESQL SERVICE RUNNING IN ALL OF THE STEPS ABOVE