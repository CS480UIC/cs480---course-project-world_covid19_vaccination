 package complex2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import complex2.domain.Complex2;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class Complex2Dao {

/**
* get the search result with number
* @param peoplename
* @return
* @throws ClassNotFoundException
* @throws IllegalAccessException
* @throws InstantiationException
*/
	
public List<Object> hospitalVaccineInfo() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	List<Object> list = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/world_covid19_vaccination?"
						+ "user=root&password=123456");

		String sql = "select hospital_name, vaccine_type as vaccine_name, type, company, protection_rate, vaccinated_people\r\n"
				+ "from (select state_name, vaccine_type, type, company, protection_rate\r\n"
				+ "from country\r\n"
				+ "inner join state\r\n"
				+ "on country.country_name = state.country_name\r\n"
				+ "inner join vaccine\r\n"
				+ "on country.vaccine_type = vaccine.name) as tb_vaccine_name\r\n"
				+ "inner join hospital\r\n"
				+ "on tb_vaccine_name.state_name = hospital.state_name\r\n"
				+ "order by vaccinated_people asc;";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();

		while(resultSet.next()){
			Complex2 complex2 = new Complex2();
			complex2.setHospitalName(resultSet.getString("hospital_name"));
			complex2.setVaccineName(resultSet.getString("vaccine_name"));
			complex2.setType(resultSet.getString("type"));
			complex2.setCompany(resultSet.getString("company"));
			complex2.setProtectionRate(resultSet.getDouble("protection_rate"));
			complex2.setVaccinatedPeople(resultSet.getInt("vaccinated_people"));
			list.add(complex2);
		}

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return list;
}

}
