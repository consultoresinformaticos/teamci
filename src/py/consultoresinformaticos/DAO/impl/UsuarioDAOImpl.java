package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import py.consultoresinformaticos.DAO.UsuarioDao;
import py.consultoresinformaticos.DTO.UsuarioDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class UsuarioDAOImpl implements UsuarioDao {

	@Override
	public void insertar(UsuarioDTO usuario) {
		String query = "INSERT INTO usuario(nombre, apellido, username, password, foto) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stm;
        ManejadorBD manDBd = new ManejadorBD();
        try {
			stm = manDBd.getCon().prepareStatement(query);
			stm.setString(1,usuario.getNombre());
	        stm.setString(2, usuario.getApellido());
	        stm.setString(3, usuario.getUsername());
	        stm.setString(4, usuario.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	@Override
	public void actualizar(UsuarioDTO usuario) {
		String sql ="UPDATE usuario SET nombre=?, apellido=?, username=?, password=?, foto=? WHERE id=?";
		PreparedStatement stm;
        ManejadorBD manDBd = new ManejadorBD();
        try {
			stm = manDBd.getCon().prepareStatement(sql);
			stm.setString(1,usuario.getNombre());
	        stm.setString(2, usuario.getApellido());
	        stm.setString(3, usuario.getUsername());
	        stm.setString(4, usuario.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void borrar(int id) {
		String sql ="DELETE FROM usuario WHERE id="+id;
		Statement stm;
        ManejadorBD manDb = new ManejadorBD();
        try {
                stm = manDb.getCon().createStatement();
                stm.executeUpdate(sql);
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

	}

	@Override
	public UsuarioDTO obtenerUsuarioPorId(int id) {
		UsuarioDTO usuario = null;
		String sql = "SELECT id, nombre, apellido, username, password, foto FROM usuario " +
				"where id = "+id;
		PreparedStatement stm;
		ResultSet rs = null;
		ManejadorBD manDb = new  ManejadorBD();
		try {
			stm = manDb.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				usuario = new UsuarioDTO();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setUsername(rs.getString("password"));
				usuario.setFoto(rs.getBlob("foto"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}

	@Override
	public List<UsuarioDTO> listar() {
		String sql = "select * from usuario";
		PreparedStatement stm;
		ResultSet rs = null;
		ManejadorBD manDB = new ManejadorBD();
		List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
		UsuarioDTO usuario = null;
		try {
			stm = manDB.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				usuario = new UsuarioDTO();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setPassword(rs.getString("password"));
				usuario.setFoto(rs.getBlob("foto"));
				usuario.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaUsuarios;
	}

}
