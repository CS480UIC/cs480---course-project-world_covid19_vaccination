package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.User;

import java.sql.ResultSet;

public class InitializeDao {
    
    
    public void initDB()  {
        Statement statement;
        PreparedStatement preparedStatement;
        String sqlstmt;
        //ResultSet resultSet;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection connect = DriverManager
                      .getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
                              + "user=root&password=123456");
            
        statement = connect.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS people");
        statement.executeUpdate("DROP TABLE IF EXISTS hospital");
        statement.executeUpdate("DROP TABLE IF EXISTS state");
        statement.executeUpdate("DROP TABLE IF EXISTS country_vaccine_relationship");
        statement.executeUpdate("DROP TABLE IF EXISTS vaccine");
        statement.executeUpdate("DROP TABLE IF EXISTS country");

        
        statement = connect.createStatement();
        sqlstmt = "CREATE TABLE country (\r\n"
                + "country_name              VARCHAR(30) NOT NULL, \r\n"
                + "country_abbreviation      VARCHAR(10) NOT NULL,\r\n"
                + "vaccine_type           VARCHAR(30) NOT NULL, \r\n"
                + "PRIMARY KEY (country_name)\r\n"
                + ")";
        statement.executeUpdate(sqlstmt);
        
        preparedStatement = connect
                .prepareStatement("insert into country (country_name, country_abbreviation, vaccine_type) value (?, ?, ?)");
        preparedStatement.setString(1, "United States");
        preparedStatement.setString(2, "USA");
        preparedStatement.setString(3, "Phizer");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country (country_name, country_abbreviation, vaccine_type) value (?, ?, ?)");
        preparedStatement.setString(1, "China");
        preparedStatement.setString(2, "CHN");
        preparedStatement.setString(3, "Sinopharm COVID19 Vaccine");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country (country_name, country_abbreviation, vaccine_type) value (?, ?, ?)");
        preparedStatement.setString(1, "India");
        preparedStatement.setString(2, "IN");
        preparedStatement.setString(3, "Covaxin");
        preparedStatement.executeUpdate();
        
        
        statement = connect.createStatement();        
        sqlstmt = "CREATE TABLE vaccine (\r\n"
                + "name              VARCHAR(30) NOT NULL, \r\n"
                + "type      VARCHAR(30) NOT NULL,\r\n"
                + "company           VARCHAR(60) NOT NULL, \r\n"
                + "protection_rate           DECIMAL(3, 1) NOT NULL, \r\n"
                + "PRIMARY KEY (name)\r\n"
                + ")";
        statement.executeUpdate(sqlstmt);
        
        preparedStatement = connect
                .prepareStatement("insert into vaccine (name, type, company, protection_rate) value (?, ?, ?, ?)");
        preparedStatement.setString(1, "Phizer");
        preparedStatement.setString(2, "mRNA");
        preparedStatement.setString(3, "BioNTech");
        preparedStatement.setDouble(4, 95);
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into vaccine (name, type, company, protection_rate) value (?, ?, ?, ?)");
        preparedStatement.setString(1, "Sinopharm COVID19 Vaccine");
        preparedStatement.setString(2, "Inactivated vaccines");
        preparedStatement.setString(3, "China");
        preparedStatement.setDouble(4, 79.34);
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into vaccine (name, type, company, protection_rate) value (?, ?, ?, ?)");
        preparedStatement.setString(1, "Covaxin");
        preparedStatement.setString(2, "Inactivated vaccines");
        preparedStatement.setString(3, "Bharat Biotech");
        preparedStatement.setDouble(4, 77.8);
        preparedStatement.executeUpdate();
        
        
        statement = connect.createStatement();  
        sqlstmt = "CREATE TABLE country_vaccine_relationship (\r\n"
                + "country_name              VARCHAR(30) NOT NULL, \r\n"
                + "vaccine_name      VARCHAR(30) NOT NULL,\r\n"
                + "PRIMARY KEY (country_name, vaccine_name), \r\n"
                + "FOREIGN KEY (country_name) REFERENCES country(country_name) ON DELETE CASCADE,\r\n"
                + "FOREIGN KEY (vaccine_name) REFERENCES vaccine(name) ON DELETE CASCADE\r\n"
                + ")";
        statement.executeUpdate(sqlstmt);
        
        preparedStatement = connect
                .prepareStatement("insert into country_vaccine_relationship (country_name, vaccine_name) value (?, ?)");
        preparedStatement.setString(1, "United States");
        preparedStatement.setString(2, "Phizer");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country_vaccine_relationship (country_name, vaccine_name) value (?, ?)");
        preparedStatement.setString(1, "China");
        preparedStatement.setString(2, "Sinopharm COVID19 Vaccine");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country_vaccine_relationship (country_name, vaccine_name) value (?, ?)");
        preparedStatement.setString(1, "India");
        preparedStatement.setString(2, "Covaxin");
        preparedStatement.executeUpdate();
        
        
        statement = connect.createStatement();        
        sqlstmt = "CREATE TABLE state (\r\n"
                + "state_name              VARCHAR(30) NOT NULL, \r\n"
                + "country_name      VARCHAR(30) NOT NULL,\r\n"
                + "population    		 	 INT UNSIGNED NOT NULL, \r\n"
                + "PRIMARY KEY (state_name),\r\n"
                + "FOREIGN KEY (country_name) REFERENCES country(country_name) ON DELETE CASCADE \r\n"
                + ")";
        statement.executeUpdate(sqlstmt);
        
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (?, ?, ?)");
        preparedStatement.setString(1, "Illinois");
        preparedStatement.setString(2, "United States");
        preparedStatement.setInt(3, 12775352);
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (?, ?, ?)");
        preparedStatement.setString(1, "Hubei");
        preparedStatement.setString(2, "China");
        preparedStatement.setInt(3, 25852345);
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (?, ?, ?)");
        preparedStatement.setString(1, "Tamil Nadu");
        preparedStatement.setString(2, "India");
        preparedStatement.setInt(3, 230000000);
        preparedStatement.executeUpdate();
        
        
        statement = connect.createStatement();        
        sqlstmt = "CREATE TABLE hospital (\r\n"
                + "hospital_name              VARCHAR(30) NOT NULL, \r\n"
                + "state_name      VARCHAR(30) NOT NULL,\r\n"
                + "city					 	 VARCHAR(30) NOT NULL,  \r\n"
                + "vaccinated_people		 	 INT UNSIGNED NOT NULL, \r\n"
                + "PRIMARY KEY (hospital_name),\r\n"
                + "FOREIGN KEY (state_name) REFERENCES state(state_name) ON DELETE CASCADE \r\n"
                + ")";
        statement.executeUpdate(sqlstmt);
        
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (?, ?, ?, ?)");
        preparedStatement.setString(1, "UIHealth");
        preparedStatement.setString(2, "Illinois");
        preparedStatement.setString(3, "Chicago");
        preparedStatement.setInt(4, 18189);
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (?, ?, ?, ?)");
        preparedStatement.setString(1, "Wuhan Central Hospital");
        preparedStatement.setString(2, "Hubei");
        preparedStatement.setString(3, "Wuhan");
        preparedStatement.setInt(4, 100000);
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (?, ?, ?, ?)");
        preparedStatement.setString(1, "Apollo Hospital");
        preparedStatement.setString(2, "Tamil Nadu");
        preparedStatement.setString(3, "Chennai");
        preparedStatement.setInt(4, 76907);
        preparedStatement.executeUpdate();
        
        
        statement = connect.createStatement();        
        sqlstmt = "CREATE TABLE people (\r\n"
                + "number					 SMALLINT AUTO_INCREMENT NOT NULL,\r\n"
                + "hospital_name		 	 VARCHAR(30) NOT NULL, \r\n"
                + "ID      			 	 INT UNSIGNED NOT NULL,  \r\n"
                + "name			 		 VARCHAR(30) NOT NULL, \r\n"
                + "age   		     		 TINYINT UNSIGNED NOT NULL,\r\n"
                + "date_of_birth    		 Date NOT NULL,\r\n"
                + "PRIMARY KEY (number),\r\n"
                + "FOREIGN KEY (hospital_name) REFERENCES hospital(hospital_name) ON DELETE CASCADE\r\n"
                + ")";
        statement.executeUpdate(sqlstmt);
        
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, "UIHealth");
        preparedStatement.setInt(2, 677447670);
        preparedStatement.setString(3, "Jiangni");
        preparedStatement.setInt(4, 21);
        preparedStatement.setString(5, "2000-01-04");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, "Wuhan Central Hospital");
        preparedStatement.setInt(2, 671847966);
        preparedStatement.setString(3, "Jiaqi Yin");
        preparedStatement.setInt(4, 21);
        preparedStatement.setString(5, "1999-09-19");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, "Apollo Hospital");
        preparedStatement.setInt(2, 657001198);
        preparedStatement.setString(3, "Adnan Sami");
        preparedStatement.setInt(4, 27);
        preparedStatement.setString(5, "1994-02-12");
        preparedStatement.executeUpdate();
        
//        
//        writeResultSet(resultSet);
        
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
}
