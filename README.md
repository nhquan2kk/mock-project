1. create /main/resources/application.properties file and Enter config the necessary configuration
   ex content of application.properties file:  
        db.driver=com.mysql.cj.jdbc.Driver  
        db.url=jdbc:mysql://localhost:3306/mock_movie  
        db.username="your_account"  
        db.password="your_password"
        file.upload.directory="your_folder_name_to_save_file"  
3. maven update project  
4. run on server tomcat 10.1.26  
