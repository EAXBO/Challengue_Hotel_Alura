package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionBase {
	
	public DataSource dataSou;
	
	public ConexionBase() {
		ComboPooledDataSource combopool = new ComboPooledDataSource();
		combopool.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura");
		combopool.setUser("root");
		combopool.setPassword("demonio13");
		
		this.dataSou = combopool;
	}
	
	public Connection conectarBase() {
		try {
			return this.dataSou.getConnection();
		}catch (SQLException e){
			System.out.println("Error de conexion");
			throw new RuntimeException (e);
		}
	}
}
