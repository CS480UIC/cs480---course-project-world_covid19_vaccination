 package people.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import people.domain.People;
import people.domain.People;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class PeopleDao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
public People findByName(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
People people = new People();
try {

Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");
   String sql = "select * from people where name=?";
   PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,name);
   ResultSet resultSet = preparestatement.executeQuery();
   //ResultSet resultSet  = preparestatement.executeUpdate();
   while(resultSet.next()){
    String people_name = resultSet.getString("name");
    if(people_name.equals(name)){
    //people.setNumber(resultSet.getInt("number"));	
    people.setID(resultSet.getInt("ID"));
    people.setName(resultSet.getString("name"));
    people.setAge(resultSet.getInt("age"));
    people.setDateOfBirth(resultSet.getString("date_of_birth"));
    }
   }

   
} catch(SQLException e) {
throw new RuntimeException(e);
}
return people;
}




/**
* insert People
* @param people
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
public void add(People people) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "insert into people (hospital_name, Id, name, age, date_of_birth) values(?,?,?,?,?)";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,people.getHospitalName());
   preparestatement.setInt(2,people.getID());
   preparestatement.setString(3,people.getName());
   preparestatement.setInt(4,people.getAge());
   preparestatement.setString(5,people.getDateOfBirth());
   preparestatement.executeUpdate();

} catch(SQLException e) {
throw new RuntimeException(e);
}
}


public void read() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "select * from people";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.execute();
   

} catch(SQLException e) {
throw new RuntimeException(e);
}

}


public void delete(int age) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "delete from people where age < ?";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setInt(1,age);
   preparestatement.executeUpdate();

} catch(SQLException e) {
throw new RuntimeException(e);
}
}


public List<Object> findByHospitalName(String hospital) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
List<Object> list = new ArrayList<>();
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");


String sql = "select * from people where hospital_name = ?";
PreparedStatement preparestatement = connect.prepareStatement(sql);
preparestatement.setString(1,hospital);
ResultSet resultSet = preparestatement.executeQuery();

while(resultSet.next()){
People people = new People();
people.setNumber(resultSet.getInt("number"));
people.setHospitalName(resultSet.getString("hospital_name"));
people.setID(resultSet.getInt("ID"));
    people.setName(resultSet.getString("name"));
    people.setAge(resultSet.getInt("age"));
    people.setDateOfBirth(resultSet.getString("date_of_birth"));
    list.add(people);
}
//System.out.println(resultSet);

} catch(SQLException e) {
throw new RuntimeException(e);
}
return list;

}

public void update(People people) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "update people set age=?, date_of_birth=? where id=? or name=?";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setInt(1,people.getAge());
   preparestatement.setString(2,people.getDateOfBirth());
   preparestatement.setInt(3,people.getID());
   preparestatement.setString(4,people.getName());
   preparestatement.executeUpdate();
} catch(SQLException e) {
throw new RuntimeException(e);
}
}

public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
List<Object> list = new ArrayList<>();
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");


String sql = "select * from people";
PreparedStatement preparestatement = connect.prepareStatement(sql);
ResultSet resultSet = preparestatement.executeQuery();

while(resultSet.next()){
People people = new People();
people.setNumber(resultSet.getInt("number"));
people.setHospitalName(resultSet.getString("hospital_name"));
people.setID(resultSet.getInt("ID"));
    people.setName(resultSet.getString("name"));
    people.setAge(resultSet.getInt("age"));
    people.setDateOfBirth(resultSet.getString("date_of_birth"));
    list.add(people);
}

} catch(SQLException e) {
throw new RuntimeException(e);
}
return list;

}

}
