package com.ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lista de palabras
        String[] palabras = {"java", "python", "javascript", "programacion", "computadora", "teclado", "pantalla", "memoria", "procesador", "internet"};
        
        // Selección aleatoria de palabra
        Random rand = new Random();
        String palabra = palabras[rand.nextInt(palabras.length)];
        
        // Configuración del juego
        int intentos = 3;
        List<Character> letrasUtilizadas = new ArrayList<>();
        char[] progreso = new char[palabra.length()];
        
        for (int i = 0; i < palabra.length(); i++) {
            progreso[i] = '_';
        }
        
        Scanner scanner = new Scanner(System.in);
        
        // Ciclo principal del juego
        while (intentos > 0 && new String(progreso).contains("_")) {
            System.out.println("Progreso: " + String.valueOf(progreso));
            System.out.println("Letras utilizadas: " + letrasUtilizadas);
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Introduce una letra: ");
            
            char letra = scanner.next().charAt(0);
            
            if (letrasUtilizadas.contains(letra)) {
                System.out.println("Ya has utilizado esa letra. Prueba con otra.");
            } else {
                letrasUtilizadas.add(letra);
                boolean acierto = false;
                
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra) {
                        progreso[i] = letra;
                        acierto = true;
                    }
                }
                
                if (!acierto) {
                    intentos--;
                }
            }
        }
        
        if (intentos > 0) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabra);
        } else {
            System.out.println("Lo siento, has perdido. La palabra era: " + palabra);
        }
        
        scanner.close();
    }
}