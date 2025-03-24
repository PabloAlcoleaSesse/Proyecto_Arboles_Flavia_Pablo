package arbolgeneral;


public class ArbolGeneral {

    private NodoGeneral raiz;

    public ArbolGeneral() {
        raiz = null;
    }

    public ArbolGeneral(NodoGeneral nodo) {
        this.raiz = nodo;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public void vaciar() {
        raiz = null;
    }

    public NodoGeneral raiz() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en raiz: árbol vacío");
        }
        return raiz;
    }

    public ArbolGeneral primerHijo() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en hijoIzq: árbol vacío");
        }

        return new ArbolGeneral(raiz.primerHijo);
    }

    public ArbolGeneral hermano() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en hijoIzq: árbol vacío");
        }

        return new ArbolGeneral(raiz.hermano);
    }

    public ArbolGeneral padre() throws Exception { //argumento ilegal
        if (raiz == null) {
            throw new Exception("Error en padre: subárbol vacío");
        }

        return new ArbolGeneral(raiz.padre);
    }

    public void añadirHijo(NodoGeneral hijo) throws Exception { // si el árbol está vacío o argumento ilegal
        if (hijo == null) {
            throw new Exception("Error en añadirHijo: hijo es un árbol vacío");
        }
        if (esVacio()) {
            throw new Exception("Error en añadirHijo: árbol vacío");
        }

        if (raiz.primerHijo == null) {
            raiz.primerHijo = hijo;
            hijo.padre = raiz;
        } else {
            NodoGeneral aux = raiz.primerHijo;
            while (aux.hermano != null) {
                aux = aux.hermano;
            }

            aux.hermano = hijo;
            hijo.padre = raiz;
        }
    }

    public void eliminar(ArbolGeneral subarbol) throws Exception {
        if (subarbol == null) {
            throw new Exception("Error en borra: subárbol vacío");
        }

        if (subarbol.raiz == raiz) {
            raiz = null;
        } else {
            ArbolGeneral p = subarbol.padre();
            if (p.esVacio()) {
                throw new Exception("Error en borra: no existe el subárbol a eliminar");
            } else if (p.raiz.primerHijo == subarbol.raiz) {
                p.raiz.primerHijo = p.raiz.primerHijo.hermano;
            } else {
                NodoGeneral aux = p.raiz.primerHijo;
                while (aux.hermano != subarbol.raiz) {
                    aux = aux.hermano;
                }

                aux.hermano = aux.hermano.hermano;
            }
        }
    }

    public void pintaArbol(int esp) {
        if (!esVacio()) {
            try {
                for (int i = 0; i < esp; i++) {
                    System.out.print("  ");
                }
                System.out.print("|");
                System.out.println(raiz.dato + " ");

                for (ArbolGeneral aux = primerHijo(); !aux.esVacio(); aux = aux.hermano()) {
                    aux.pintaArbol(esp + 1);
                }
            } catch (Exception e) {
            }
        }
    }


    public static void main(String[] args) {

        ArbolGeneral a = new ArbolGeneral(new NodoGeneral(1));
        ArbolGeneral b = new ArbolGeneral(new NodoGeneral(2));
        ArbolGeneral c = new ArbolGeneral(new NodoGeneral(3));
        ArbolGeneral d = new ArbolGeneral(new NodoGeneral(-4));
        ArbolGeneral e = new ArbolGeneral(new NodoGeneral(2));
        ArbolGeneral f = new ArbolGeneral(new NodoGeneral(43));
        ArbolGeneral g = new ArbolGeneral(new NodoGeneral(1));
        ArbolGeneral h = new ArbolGeneral(new NodoGeneral(-3));
        ArbolGeneral i = new ArbolGeneral(new NodoGeneral(54));

        try {
            c.añadirHijo(new NodoGeneral(-8));
            a.añadirHijo(c.raiz());
            a.añadirHijo(b.raiz());
            b.añadirHijo(d.raiz());
            c.añadirHijo(new NodoGeneral(5));
            e.añadirHijo(a.raiz());
            b.añadirHijo(f.raiz());
            b.añadirHijo(g.raiz());
            b.añadirHijo(h.raiz());
            b.añadirHijo(i.raiz());
//	    	a.primerHijo().hermano()
            System.out.println("arbol");
            e.pintaArbol(0);


            e.eliminar(c);
            e.pintaArbol(0);

            System.out.println("--------");
            System.out.println(grado(b));
            System.out.println(contarHijosPorEliminacion(b));

            System.out.println("--------");

        } catch (Exception exc) {
        }

    }
//____-____________________________________________________________________________________
    //Primer metodo para contar los hijos de un arbol

    public static int grado(ArbolGeneral arbol) {
        try {
            if (arbol.esVacio()) {
                return 0;
            }
            // Llamada a la versión sobrecargada con el primer hijo de la raíz
            return grado(arbol.raiz().primerHijo);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

        // Metodo sobrecargado para la recursión interna

    private static int grado(NodoGeneral nodo) {
        if (nodo == null) {
            return 0;
        }
        // Cuenta este nodo más todos sus hermanos recursivamente
        return 1 + grado(nodo.hermano);
    }
//____-____________________________________________________________________________________
   
