 package vaccine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import vaccine.domain.Vaccine;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class VaccineDao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
public Vaccine findByName(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
Vaccine vaccine = new Vaccine();
try {

Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");
   String sql = "select * from vaccine where name=?";
   PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,name);
   ResultSet resultSet = preparestatement.executeQuery();

   while(resultSet.next()){
    String vaccine_name = resultSet.getString("name");
    if(vaccine_name.equals(name)){
    vaccine.setName(resultSet.getString("name"));
   	vaccine.setType(resultSet.getString("type"));
   	vaccine.setCompany(resultSet.getString("company"));
   	vaccine.setProtectionRate(resultSet.getDouble("protection_rate"));
   	
    }
   }

   
} catch(SQLException e) {
throw new RuntimeException(e);
}
return vaccine;
}




/**
* insert People
* @param people
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
public void add(Vaccine vaccine) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "insert into vaccine (name, type, company, protection_rate) values(?,?,?,?)";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,vaccine.getName());
   preparestatement.setString(2,vaccine.getType());
   preparestatement.setString(3,vaccine.getCompany());
   preparestatement.setDouble(4,vaccine.getProtectionRate());
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

String sql = "select * from vaccine";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.execute();

} catch(SQLException e) {
throw new RuntimeException(e);
}

//return list;
}


public void delete(double protectionRate) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "delete from vaccine where protection_rate < ?";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setDouble(1,protectionRate);
   preparestatement.executeUpdate();

} catch(SQLException e) {
throw new RuntimeException(e);
}
}


public void update(Vaccine vaccine) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "update vaccine set protection_rate=? where name=?";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setDouble(1,vaccine.getProtectionRate());
   preparestatement.setString(2,vaccine.getName());
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


String sql = "select * from vaccine";
PreparedStatement preparestatement = connect.prepareStatement(sql);
ResultSet resultSet = preparestatement.executeQuery();

while(resultSet.next()){
Vaccine vaccine = new Vaccine();
vaccine.setType(resultSet.getString("type"));
	vaccine.setName(resultSet.getString("name"));
	vaccine.setCompany(resultSet.getString("company"));
	vaccine.setProtectionRate(resultSet.getDouble("protection_rate"));
    list.add(vaccine);
}

} catch(SQLException e) {
throw new RuntimeException(e);
}
return list;

}

}
