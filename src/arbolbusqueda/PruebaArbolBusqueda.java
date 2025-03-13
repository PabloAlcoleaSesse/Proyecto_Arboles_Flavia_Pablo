package arbolbusqueda;

import arbolbusqueda.ArbolBusqueda;
import arbolbusqueda.NodoBinario;

public class PruebaArbolBusqueda {
	 public static void main(String[] args) {
		 
		 
		 ArbolBusqueda arbol = new ArbolBusqueda(new NodoBinario(1));
		 
		 try {
			 arbol.insertar(2);
			 arbol.insertar(-1);
			 arbol.insertar(44);
			 arbol.insertar(20);
			 NodoBinario i = arbol.buscarMin();
			 System.out.println("El mínimo es " + i.dato);
			 
			 NodoBinario dos = arbol.buscar(2);
			 NodoBinario y = dos.der;
			 System.out.println("El valor del hijo derecho de dos es " + y.dato);
			 
		 
	     
		 } catch (Exception exception) {
	            exception.printStackTrace();
	     }
	     
	     
	     
	     
	 }
}
