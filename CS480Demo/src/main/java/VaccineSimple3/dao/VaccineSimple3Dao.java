 package VaccineSimple3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import VaccineSimple3.domain.VaccineAvgProtectionByType;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class VaccineSimple3Dao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
	
public List<Object> avgProtectionByType() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	List<Object> list = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
						+ "user=root&password=123456");

		String sql = "select type, avg(protection_rate) as 'average_protection_rate' from vaccine group by type";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();

		while(resultSet.next()){
			VaccineAvgProtectionByType avgProtection = new VaccineAvgProtectionByType();
			avgProtection.setType(resultSet.getString("type"));
			avgProtection.setAvgProtectionRate(resultSet.getDouble("average_protection_rate"));
			list.add(avgProtection);
		}

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return list;
}

}
