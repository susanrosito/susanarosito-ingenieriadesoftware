package codificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

	

public class ListaContactos extends Observable {
	
	private List<Persona> contactos;
	
	
	public ListaContactos() {
	 this.contactos = new ArrayList<Persona>();
	 
	}
	
	public List<Persona> getLista(){
		return this.contactos;
		
	}
   public Persona sacarPersona(int posicion){
	   return this.contactos.get(posicion);
	   
   }
	
	public void agregar(Persona persona) {
		 this.contactos.add(persona); 
		
		setChanged();
		this.notifyObservers("lista","lista[a,b]","lista[a,b,c] agrega c");
	}
	
	public void borrar(int posicion){
		contactos.remove(posicion);
		
		setChanged();
		this.notifyObservers("lista","lista[a,b,c]", "lista[a,b] borra c");
		
	}
	
	public void notifyObservers(String propiedad, Object valorViejo, Object valorNuevo) {
		super.notifyObservers(new CambioPropiedad(propiedad, valorViejo, valorNuevo));
	}
}

