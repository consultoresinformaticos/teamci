package py.consultoresinformaticos.DTO;

import java.sql.Blob;

public class UsuarioDTO {
	private int id;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	private Blob foto;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Blob getFoto() {
		return foto;
	}
	
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
}
