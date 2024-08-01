package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOLoginRepository {
	
	
	private Connection connection;
	
	
	public DAOLoginRepository() {
		connection = SingleConnectionBanco.getConnection();
	}
	
	public boolean validarAutenticacao(ModelLogin modelLogin) throws Exception {
		DAOLoginRepository();
		
		String sql = "select * from model_login where upper("+modelLogin.getLogin()+") = upper(?) and upper("+modelLogin.getSenha()+") = upper(?) ";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			return true;/*autenticado*/
		}
		
		return false; /*nao autenticado*/
	}

}
