package py.consultoresinformaticos.DAO;

import py.consultoresinformaticos.DAO.impl.UsuarioDAOImpl;

public class DaoFactory {
	public static UsuarioDAOImpl getUsuarioDAOImpl() {
		return new UsuarioDAOImpl();
	}
}