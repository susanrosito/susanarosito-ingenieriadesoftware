package codificacion;

public class CambioPropiedad {

	private String propiedad;
	private Object valorViejo;
	private Object valorNuevo;
	

	public CambioPropiedad(String propiedad, Object valorViejo, Object valorNuevo) {
		this.setPropiedad(propiedad);
		this.setValorViejo(valorViejo);
		this.setValorNuevo(valorNuevo);
		
		
	}
	
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}


	public String getPropiedad() {
		return propiedad;
	}


	public void setValorViejo(Object valorViejo) {
		this.valorViejo = valorViejo;
	}


	public Object getValorViejo() {
		return valorViejo;
	}


	public void setValorNuevo(Object valorNuevo) {
		this.valorNuevo = valorNuevo;
	}


	public Object getValorNuevo() {
		return valorNuevo;
	}

}
