package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Machine;
import entities.Salle;

public class MachineService implements IDao<Machine> {

	private SalleService ss;

	public MachineService() {
		ss = new SalleService();
	}

	@Override
	public boolean create(Machine o) {

		try {
			String req = "insert into machine values (null, ?, ? , ? , ?, ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getReference());
			ps.setString(2, o.getMarque());
			ps.setDouble(3, o.getPrix());
			ps.setDate(4, new Date(o.getDateAchat().getTime()));
			ps.setInt(5, o.getSalle().getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean delete(Machine o) {
		try {
			String req = "delete from machine where id  = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getId());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Machine o) {
		try {
			String req = "update machine set reference = ? , marque = ?, prix = ?, dateAchat = ?, salle = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getReference());
			ps.setString(2, o.getMarque());
			ps.setDouble(3, o.getPrix());
			ps.setDate(4, new Date(o.getDateAchat().getTime()));
			ps.setInt(5, o.getSalle().getId());
			ps.setInt(6, o.getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Machine> findBySalle(Salle s) {
		List<Machine> machines = new ArrayList<Machine>();
		try {
			
			String sql = "select * from machine where salle = " + s.getId();
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next())
				machines.add(new Machine (rs.getInt("id"), rs.getString("reference"), rs.getString("marque"),rs.getDouble("prix"), rs.getDate("dateAchat"), ss.findById(rs.getInt("salle"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return machines;

	}
	public List<Machine> entreDeuxDates(Date d1,Date d2){
		List<Machine> machines = new ArrayList<Machine>();
		try {
			
			String sql = "select * from machine where dateAchat  BETWEEN " + d1+ "AND "+ d2;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next())
				machines.add(new Machine (rs.getInt("id"), rs.getString("reference"), rs.getString("marque"),rs.getDouble("prix"), rs.getDate("dateAchat"), ss.findById(rs.getInt("salle"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return machines;
		
	}

	@Override
	public Machine findById(int id) {
		  try {
	            String req = "select * from machine where id=" + id;
	            Statement st = Connexion.getConnection().createStatement();
	            ResultSet rs = st.executeQuery(req);
	            if (rs.next()) {
	                return new Machine(rs.getString("reference"),rs.getString("marque"),rs.getDouble("prix"), rs.getDate("dateAchat"),ss.findById(rs.getInt("salle")));
	            }
	        } catch (SQLException ex) {
	            System.out.println("Erreur SQL");
	        }
	        return null;
	}
	public Machine findBydate(Date d1,Date d2) {
		  try {
	            String req = "select * from machine where dateAchat>" + d1+"and dateAchat<"+d2;
	            Statement st = Connexion.getConnection().createStatement();
	            ResultSet rs = st.executeQuery(req);
	            if (rs.next()) {
	                return new Machine(rs.getString("reference"),rs.getString("marque"),rs.getDouble("prix"), rs.getDate("dateAchat"),ss.findById(rs.getInt("salle")));
	            }
	        } catch (SQLException ex) {
	            System.out.println("Erreur SQL");
	        }
	        return null;
	}
	
	public Machine findBysl(int salle) {
		  try {
	            String req = "select * from machine where salle=" + salle;
	            Statement st = Connexion.getConnection().createStatement();
	            ResultSet rs = st.executeQuery(req);
	            if (rs.next()) {
	                return new Machine(rs.getString("reference"),rs.getString("marque"),rs.getDouble("prix"), rs.getDate("dateAchat"),ss.findById(rs.getInt("salle")));
	            }
	        } catch (SQLException ex) {
	            System.out.println("Erreur SQL");
	        }
	        return null;
	}

	@Override
	public List<Machine> findAll() {
		List<Machine> machines = new ArrayList<Machine>();
		try {
			String sql = "select * from machine";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getString("marque"),
						rs.getDouble("prix"), rs.getDate("dateAchat"), ss.findById(rs.getInt("salle"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return machines;
	}
	
	
	
	

}
