# Proyecto Árboles 
Problema: Realizar un código que sea capaz de a través de unos datos iniciales proporcionar el numero de hermanos que tendrá cada sujeto. Con esto tambien se podrá saber el rango del árbol.

Procedimiento: 

El método contarHijosPorEliminacion cuenta cuántos hijos tiene un nodo en un árbol mediante la eliminacion recursiva de el primer hijo de dicho arbol. Para ello realiza una copia del arbol, asi no afectará al arbol original. Y suma 1 cada vez que se ejecuta el metodo.

//Segundo metodo para contar los hijos de un arbol
    
    public static int contarHijosPorEliminacion(ArbolGeneral arbol) {
        if (arbol == null || arbol.esVacio()) {
            return 0;
        }

        try {
           
            ArbolGeneral copia = new ArbolGeneral(arbol.raiz);
       
            ArbolGeneral hijo = copia.primerHijo();
            
            if (hijo.esVacio()) {
                return 0;
            }

            copia.eliminar(hijo);

            return 1 + contarHijosPorEliminacion(copia);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}


Salida esperada: Un esquema del numero de los hermanos, cada uno con el espacio correspondiente para conseguir la estructura de un árbol
