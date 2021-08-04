 package country.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import country.domain.Country;
import people.domain.People;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class CountryDao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
public Country findByName(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
Country country = new Country();
try {

Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

   String sql = "select * from country where country_name=?";
   PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,name);
   ResultSet resultSet = preparestatement.executeQuery();

   while(resultSet.next()){
    String CountryName = resultSet.getString("name");
    if(CountryName.equals(name)){
    	country.setCountryName(resultSet.getString("country_name"));
    	country.setCountryAbbreviation(resultSet.getString("country_abbreviation"));
    	country.setVaccineType(resultSet.getString("vaccine_type"));
   	
    }
   }

   
} catch(SQLException e) {
throw new RuntimeException(e);
}
return country;
}




/**
* insert People
* @param people
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
public void add(Country country) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "insert into country (country_name, country_abbreviation, vaccine_type) values(?,?,?)";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,country.getCountryName());
   preparestatement.setString(2,country.getCountryAbbreviation());
   preparestatement.setString(3,country.getVaccineType());
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

String sql = "select * from country";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.execute();
} catch(SQLException e) {
throw new RuntimeException(e);
}


}


public void delete(String vaccineName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "delete from country where vaccine_type = ?";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,vaccineName);
   preparestatement.executeUpdate();

} catch(SQLException e) {
throw new RuntimeException(e);
}
}


public void update(Country country) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");

String sql = "update country set vaccine_type=? where country_name=?";
PreparedStatement preparestatement = connect.prepareStatement(sql);
   preparestatement.setString(1,country.getVaccineType());
   preparestatement.setString(2,country.getCountryName());
   preparestatement.executeUpdate();
} catch(SQLException e) {
throw new RuntimeException(e);
}
}

public List<Object> orderByAbbreviation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
List<Object> list = new ArrayList<>();
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");


String sql = "select * from country order by country_abbreviation desc";
PreparedStatement preparestatement = connect.prepareStatement(sql);
ResultSet resultSet = preparestatement.executeQuery();

while(resultSet.next()){
	Country country = new Country();
	country.setCountryName(resultSet.getString("country_name"));
	country.setCountryAbbreviation(resultSet.getString("country_abbreviation"));
	country.setVaccineType(resultSet.getString("vaccine_type"));
    list.add(country);
}
//System.out.println(resultSet);

} catch(SQLException e) {
throw new RuntimeException(e);
}
return list;

}

public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
List<Object> list = new ArrayList<>();
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection connect = DriverManager
         .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
             + "user=root&password=123456");


String sql = "select * from country";
PreparedStatement preparestatement = connect.prepareStatement(sql);
ResultSet resultSet = preparestatement.executeQuery();

while(resultSet.next()){
Country country = new Country();
//country.getCountryName();
country.setCountryName(resultSet.getString("country_name"));
country.setCountryAbbreviation(resultSet.getString("country_abbreviation"));
country.setVaccineType(resultSet.getString("vaccine_type"));
    list.add(country);
}

} catch(SQLException e) {
throw new RuntimeException(e);
}
return list;

}

}
