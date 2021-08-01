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
                .prepareStatement("insert into country (country_name, country_abbreviation, vaccine_type) value (\"United States\", \"USA\", \"Phizer\")" +"");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country (country_name, country_abbreviation, vaccine_type) value (\"China\", \"CHN\", \"Sinopharm COVID19 Vaccine\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country (country_name, country_abbreviation, vaccine_type) value (\"India\", \"IN\", \"Covaxin\")");
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
                .prepareStatement("insert into vaccine (name, type, company, protection_rate) value (\"Phizer\", \"mRNA\", \"BioNTech\", 95)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into vaccine (name, type, company, protection_rate) value (\"Sinopharm COVID19 Vaccine\", \"Inactivated vaccines\", \"China\", 79.34)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into vaccine (name, type, company, protection_rate) value (\"Covaxin\", \"Inactivated vaccines\", \"Bharat Biotech\", 77.8)");
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
                .prepareStatement("insert into country_vaccine_relationship (country_name, vaccine_name) value (\"United States\", \"Phizer\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country_vaccine_relationship (country_name, vaccine_name) value (\"China\", \"Sinopharm COVID19 Vaccine\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into country_vaccine_relationship (country_name, vaccine_name) value (\"India\", \"Covaxin\")");
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
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Illinois\", \"United States\", 12775352)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Hubei\", \"China\", 25852345)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Tamil Nadu\", \"India\", 230000000)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Washington\", \"United States\", 39613493)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Arizona\", \"United States\", 29730311)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Xinjiang\", \"China\", 126012510)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Shandong\", \"China\", 101527453)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into state (state_name, country_name, population) value (\"Telangana\", \"India\", 112374333\r\n"
                		+ ")");
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
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"UIHealth\", \"Illinois\", \"Chicago\", 18189)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"Wuhan Central Hospital\", \"Hubei\", \"Wuhan\", 100000)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"Apollo Hospital\", \"Tamil Nadu\", \"Chennai\", 76907)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"UW Medical Center\", \"Washington\", \"Seattle\", 55000)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"Banner\", \"Arizona\", \"Tucson\", 73890)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"People's Hospital\", \"Xinjiang\", \"Urumqi\", 89320)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"Jinan Hospital\", \"Shandong\", \"Jinan\", 139809)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"Billroth Hospitals\", \"Tamil Nadu\", \"Chennai\", 92341)");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into hospital (hospital_name, state_name, city, vaccinated_people) value (\"Care Hospital\", \"Telangana\", \"Hyderabad\", 67537)");
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
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"UIHealth\", 677447670, \"Jiangni\", 21, \"2000-01-04\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"Wuhan Central Hospital\", 671847966, \"Jiaqi Yin\", 21, \"1999-09-19\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"Apollo Hospital\", 657001198, \"Adnan Sami\", 27, \"1994-02-12\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"UIHealth\", 677447675, \"Jiang\", 10, \"2010-01-04\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"UIHealth\", 677447680, \"Ren\", 23, \"1998-01-04\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"Wuhan Central Hospital\", 671847976, \"Jia\", 8, \"2012-09-19\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"Wuhan Central Hospital\", 671847986, \"Yin\", 18, \"2003-09-19\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"Apollo Hospital\", 657001185, \"Adnan\", 15, \"2006-02-12\")");
        preparedStatement.executeUpdate();
        preparedStatement = connect
                .prepareStatement("insert into people (hospital_name, ID, name, age, date_of_birth) value (\"Apollo Hospital\", 657001165, \"Sami\", 19, \"2002-09-19\")");
        preparedStatement.executeUpdate();
        
        
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
