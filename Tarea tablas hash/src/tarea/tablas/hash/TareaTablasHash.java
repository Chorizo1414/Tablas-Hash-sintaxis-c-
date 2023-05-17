
package tarea.tablas.hash;

import java.util.HashMap;
import java.util.Scanner;

public class TareaTablasHash {


    public static void main(String[] args) {
        String[] tokens = {"int", "suma", "=", "0", ";", "suma", "=", "54", "+", "20", ";"};
        String[] clavesHash = {"00", "04", "09", "011", "012", "10", "15", "17", "110", "112", "114"};

        HashMap<String, String> tablaHash = new HashMap<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            String claveHash = clavesHash[i];
            tablaHash.put(claveHash, token);
        }

        System.out.println("Tabla Hash:");
        for (String clave : tablaHash.keySet()) {
            String token = tablaHash.get(clave);
            System.out.println(clave + " -> " + token);
        }

        Scanner scanner = new Scanner(System.in);

        String opcion = "s";
        while (opcion.equalsIgnoreCase("s")) {
            System.out.println("\nIngrese las claves separadas por comas:");
            String clavesBusqueda = scanner.nextLine();

            String[] claves = clavesBusqueda.split(",");
            StringBuilder tokensEncontrados = new StringBuilder();

            for (String clave : claves) {
                String tokenEncontrado = tablaHash.get(clave.trim());

                if (tokenEncontrado != null) {
                    tokensEncontrados.append(tokenEncontrado).append(" ");
                }
            }

            if (tokensEncontrados.length() > 0) {
                System.out.println("Tokens encontrados: " + tokensEncontrados.toString().trim());
            } else {
                System.out.println("No se encontró ningún token para las claves ingresadas.");
            }

            System.out.println("\n¿Desea buscar otras claves? (s/n)");
            opcion = scanner.nextLine();
        }
    }
}

