package com.company;

import java.util.Scanner;

public class PiedraPapelTijeras {
    public static void main(String[] args) {
        int rondas = 5;//contador de partidas restantes
        Scanner inputValue = new Scanner(System.in);
        Metodos.Jugada[] partidas = new Metodos.Jugada[10];
        System.out.println("Introduce: 'p' para Piedra,'x' para Papel o 't' para Tijeras. Quedan " + rondas);
        int resultado;
        for (int i = 0; i < partidas.length; i++) {//Rellena el array de partidas mientras responde al usuario por cada jugada
            partidas[i] = Metodos.jugadaUsuario(inputValue.next());//Recoge la jugada del usuario y la pasa a Piedra, Papel o Tijeras
            i++;
            partidas[i] = Metodos.aleatorio();//Recoge la jugada de la I.A. aleatoriamente
            resultado = Metodos.ganadorRonda(partidas[i - 1], partidas[i]);//Calcula el ganador entre el jugador y la I.A.
            switch (resultado) {//Responde dependiendo del ganador de la partida o si a habido un error al introducir la jugada
                case 0 -> {
                    System.out.println("Tu jugada: " + partidas[i - 1]);
                    System.out.println("Jugada A.I.: " + partidas[i]);
                    System.out.println("Ganaste");
                }
                case 1 -> {
                    System.out.println("Tu jugada: " + partidas[i - 1]);
                    System.out.println("Jugada A.I.: " + partidas[i]);
                    System.out.println("Perdiste");
                }
                case 2 -> {
                    System.out.println("Tu jugada: " + partidas[i - 1]);
                    System.out.println("Jugada A.I.: " + partidas[i]);
                    System.out.println("Empataste");
                }
                case 3 -> {
                    System.out.println("Tu jugada: " + partidas[i - 1]);
                    System.out.println("Jugada A.I.: " + partidas[i]);
                    System.out.println("Mal introducida la Jugada");
                }
            }
            rondas--;//Cuenta atras de las rondas
            if (rondas != 0)
                System.out.println("Introduce: 'p' para Piedra,'x' para Papel o 't' para Tijeras. Quedan " + rondas+" rondas");

        }
        String porcentages = Metodos.muestraEstadistica(partidas);//Crea un String con todos los datos de las estadísticas
        for (int i = 0; i < porcentages.length(); i++) {//Separa el String por cada Estadistica
            String cadena = "";
            do {
                cadena = cadena + porcentages.charAt(i);
                i++;
            } while (porcentages.charAt(i) != '.');//Separa el String cuando encuentra un punto
            System.out.println(cadena);
        }
    }
}
