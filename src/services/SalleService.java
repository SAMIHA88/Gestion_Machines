package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Salle;

public class SalleService implements IDao<Salle> {

	@Override
	public boolean create(Salle o) {
		try {
			String sql = "insert intos salle values (null, '" + o.getCode() + "', '" + o.getLibelle() + "')";
			Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Salle o) {
		try {
			String sql = "delete from salle where id = " + o.getId();
			Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Salle o) {
		try {
			String sql = "update salle set code = '" + o.getCode() + "', libelle = '" + o.getLibelle() + "' where id = "
					+ o.getId();
			Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Salle findById(int id) {
		Salle salle = null;
		try {
			String sql = "select * from salle where id = " + id;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			if(rs.next())
				return new Salle (rs.getInt("id"), rs.getString("code"), rs.getString("libelle"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Salle> findAll() {
		List<Salle> salles = new ArrayList<Salle>();
		try {
			String sql = "select * from salle";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next())
				salles.add(new Salle (rs.getInt("id"), rs.getString("code"), rs.getString("libelle")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salles;
	}

}
