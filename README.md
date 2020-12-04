# StudentData
</br></br>
#Requirements : </br> </br>
  Java 8 </br>
  mvn 3.5.x or above
</br></br>
#Steps  </br>
  1) Clone this repo </br>
  2) Run "mvn clean install" </br>
  3) Run studentdata*.jar </br>
      java -Dspring.profiles.active=local -Duser.timezone=Asia/Kolkata -Dspring.studentdata.log.dir={Your_log_path} 
      -jar studentdata*.jar </br></br>

#Swagger Details
</br></br>
  Url: http://localhost:8080/student/swagger-ui.html
  </br>
  For all end points ,provide following header values 
  </br>
  Content-Type :application/json
  </br>
  Accept-Language:application/json 
