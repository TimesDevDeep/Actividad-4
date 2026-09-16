public class PruebaArbolBinario {

    public static void main(String[] args) {

        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        System.out.println("=== 1. INSERCION DE ELEMENTOS ===");
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 10, 90};
        for (int v : valores) {
            arbol.insertar(v);
            System.out.println("Insertado: " + v);
        }

        System.out.println("\n=== 2. RECORRIDOS DEL ARBOL ===");
        System.out.println("Preorden : " + arbol.preorden());
        System.out.println("Inorden  : " + arbol.inorden());
        System.out.println("Postorden: " + arbol.postorden());

        System.out.println("\n=== 3. BUSQUEDAS ===");
        int[] buscar = {40, 100};
        for (int b : buscar) {
            boolean existe = arbol.buscar(b);
            System.out.println("Buscar " + b + " -> " + (existe ? "ENCONTRADO" : "NO ENCONTRADO"));
        }

        System.out.println("\n=== 4. ELIMINACION DE ELEMENTOS ===");

        System.out.println("Eliminando 20 (nodo hoja)...");
        arbol.eliminar(20);
        System.out.println("Inorden tras eliminar 20: " + arbol.inorden());

        System.out.println("\nEliminando 30 (nodo con un hijo)...");
        arbol.eliminar(30);
        System.out.println("Inorden tras eliminar 30: " + arbol.inorden());

        System.out.println("\nEliminando 50 (raiz, nodo con dos hijos)...");
        arbol.eliminar(50);
        System.out.println("Inorden tras eliminar 50: " + arbol.inorden());

        System.out.println("\nRecorridos finales:");
        System.out.println("Preorden : " + arbol.preorden());
        System.out.println("Inorden  : " + arbol.inorden());
        System.out.println("Postorden: " + arbol.postorden());
    }
}
