/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;




public class PruebaArbolBinario {
        public static int n = 0;
    public static void main(String[] args) {

        ArbolBinario<String> arbolA = new ArbolBinario(new NodoBinario<String>("A"));
        ArbolBinario<String> arbolB = new ArbolBinario(new NodoBinario<String>("B"));
        ArbolBinario<String> arbolC = new ArbolBinario(new NodoBinario<String>("C"));
        ArbolBinario<String> arbolD = new ArbolBinario(new NodoBinario<String>("D"));
        ArbolBinario<String> arbolE = new ArbolBinario(new NodoBinario<String>("E"));
        ArbolBinario<String> arbolF = new ArbolBinario(new NodoBinario<String>("F"));
        ArbolBinario<String> arbolG = new ArbolBinario(new NodoBinario<String>("G"));
        
        try {
            arbolA.ponHijoIzq(arbolB);
            arbolA.ponHijoDer(arbolC);
            arbolB.ponHijoIzq(arbolD);

            arbolC.ponHijoIzq(arbolE);
            arbolC.ponHijoDer(arbolF);

            arbolF.ponHijoDer(arbolG);
            
            
            preorden(arbolA.raiz);
            System.out.println();
            
            inorden(arbolA.raiz);
            System.out.println();
            
            postorden(arbolA.raiz);
            System.out.println();
            
            System.out.println(numeroNodos(arbolA));
            System.out.println(contNodos(arbolA));
            System.out.println(altura(arbolA));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
    }

    public static void preorden(NodoBinario nodo){
        if(nodo != null){
            System.out.print(nodo.dato);
            preorden(nodo.izq);
            preorden(nodo.der);
        }
    }
    
    public static void inorden(NodoBinario nodo){
        if(nodo != null){
            inorden(nodo.izq);
            System.out.print(nodo.dato);
            inorden(nodo.der);
        }
    }
    
    public static void postorden(NodoBinario nodo){
        if(nodo != null){
            postorden(nodo.izq);
            postorden(nodo.der);
            System.out.print(nodo.dato);
        }
    }
    public static int numeroNodos(ArbolBinario arbol){
        try {
            if(arbol.raiz != null) {
                    numeroNodos(arbol.hijoIzq());
                    numeroNodos(arbol.hijoDer());
                    n++;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return n;
    }
    public static int contNodos(ArbolBinario arbol)throws Exception{
        if(arbol.raiz == null) return 0; else return 1 + contNodos(arbol.hijoIzq()) + contNodos(arbol.hijoDer());
    }

    public static int altura(ArbolBinario arbol)throws Exception{
        if(arbol.raiz == null)
            return 0;
        else 
            return 1 + Math.max(altura(arbol.hijoIzq()), altura(arbol.hijoDer()));
    }
}
