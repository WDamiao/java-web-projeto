package denuncia.dao;

import denuncia.model.Denuncia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DenunciaDao {
	
	public void cadastrarDenuncia(Denuncia denuncia) {
		
		String sql= "INSERT INTO DENUNCIA VALUES (null, ?, ?, ?, ?, ?)";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, denuncia.getPais());
			pStatement.setString(2, denuncia.getTipo());
			pStatement.setInt(3, denuncia.getQtdDenuncia());
			pStatement.setInt(4, denuncia.getCasosConfirmados());
			pStatement.setString(5, denuncia.getGravidade());
			
			pStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(pStatement != null)
					pStatement.close();
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
			try {
				if(conn != null)
					conn.close();
				
			}catch (Exception e3) {
				
				e3.printStackTrace();
				
			}
		}
	}
	
	public ArrayList<Denuncia> BuscarDenunciaPorPais(String pais) {
		
		String sql = "SELECT * FROM DENUNCIA WHERE pais LIKE '%"+ pais +"%'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Denuncia denuncia = null;
		ArrayList<Denuncia> denuncias = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if(rs != null) {
				denuncias = new ArrayList<Denuncia>();
				
				while(rs.next()) {
					denuncia = new Denuncia();
					denuncia.setIdDenuncia(rs.getInt("idDenuncia"));
					denuncia.setPais(rs.getString("pais"));
					denuncia.setTipo(rs.getString("tipo"));
					denuncia.setQtdDenuncia(rs.getInt("qtdDenuncia"));
					denuncia.setCasosConfirmados(rs.getInt("casosConfirmados"));
					denuncia.setGravidade(rs.getString("gravidade"));
					
					denuncias.add(denuncia);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(pStatement != null)
					pStatement.close();
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
			try {
				if(conn != null)
					conn.close();
				
			}catch (Exception e3) {
				
				e3.printStackTrace();
				
			}
		}
		
		return denuncias;
		
	}
}
