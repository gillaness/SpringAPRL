package cl.awakelab.springaprl.model;

public class Empresa {

	private String rutEmpresa;
	private String nombreEmpresa;
	private String direccion;
	private String contacto;
	private String telefono;
	private String mailContacto;
	private float accidentabilidad;
	private int headCount;
	private int qAccidentes;
	
	public Empresa() {
		this.rutEmpresa="";
	}

	public Empresa(String rutEmpresa, String nombreEmpresa, String direccion, String contacto, String telefono,
			String mailContacto, int headCount) {
		this.rutEmpresa = rutEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.direccion = direccion;
		this.contacto = contacto;
		this.telefono = telefono;
		this.mailContacto = mailContacto;
		this.headCount = headCount;
	}
	
	public Empresa(String rutEmpresa, String nombreEmpresa, float accidentabilidad, int headCount, int qAccidentes) {
		this.rutEmpresa = rutEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.accidentabilidad = accidentabilidad;
		this.headCount = headCount;
		this.qAccidentes = qAccidentes;
	}

	
	
	public int getHeadCount() {
		return headCount;
	}

	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}

	public int getqAccidentes() {
		return qAccidentes;
	}

	public void setqAccidentes(int qAccidentes) {
		this.qAccidentes = qAccidentes;
	}

	public float getAccidentabilidad() {
		return accidentabilidad;
	}

	public void setAccidentabilidad(float accidentabilidad) {
		this.accidentabilidad = accidentabilidad;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMailContacto() {
		return mailContacto;
	}

	public void setMailContacto(String mailContacto) {
		this.mailContacto = mailContacto;
	}

	@Override
	public String toString() {
		return "Empresa [rutEmpresa=" + rutEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", direccion=" + direccion
				+ ", contacto=" + contacto + ", telefono=" + telefono + ", mailContacto=" + mailContacto + "]";
	}
	
	
	
}
