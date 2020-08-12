# Data-Storage-and-Analytics


![Enterprise-Data-Storage1](https://user-images.githubusercontent.com/37260226/90009010-ea3b3d00-dcba-11ea-9087-bef46033eb7d.jpg)



Data storage and analytics is JAVA based Desktop Application designed in such a way that data can be entered offline and later on put into the  web when the network is available. 


## Prerequisites

1.Java (jdk1.8.0_192)

2.MySQL

3.SQLite (3.11.2)


## Workflows

The project target is providing a user-friendly interface to the govt. of Sikkim due to network challenging whether, to retrieve required data among four district is very difficult so that the data can be entry offline and later on put into the web when network is available. The project is based on java language to synchronization the data
whenever network is available and to run the server continuously using threads in java. A web-based approach is used to retrieve the data of student from database so that it will make available on four districts database. The project aims at providing a good user experience of the service to the govt. of Sikkim through the synchronization of data when network is available.

















   
















- FrontEnd

      • Only system administrator can write the data of respective school.
      
      • The data entered by system administrator goes to the “Backup System” as well as to the server side, 
        if system has active connection with server then “updated flag” will indicate successful data 
        updation at both the sides.
        
      • It goes to “Backup System” and in “File” and “data updated” flag will indicate data has not yet 
        updated at server side.
        
      • Those data which is not yet updated at server side will be updated as soon as system will get 
        active connection to the server.

- BackEnd

      • The information of students entered by system administrator goes to server side 
        on connection availability and returns 1 on success and 0 on failure.
        
      • The succeeded data as well as failed data goes to “Backup System” and “File” 
        which maintains the failed data and pointer information from which the data 
        has to be updated.
        
      • For updation of failed data due to unavailability of active connection to the 
        server “sync” function is used.
        
      • The “sync” function checks for arrival of active connection to server for 
        failed data updation at server side after specific period of time.
        
      • As soon as system gets active connection to the server “sync” function reads 
        the “File”, with the help of pointer it reads the failed and write to the 
        server side and modifies the “updated flag” indicating successful data updation.
        
      • In the middle of this process if system looses its connection with server or after 
        completion of this process “sync” function modifies the pointer value up to what 
        data  successfully updated.
        
      • Now the file will contain only failed data that has to be updated and pointers 
        Pointing to appropriate location.



