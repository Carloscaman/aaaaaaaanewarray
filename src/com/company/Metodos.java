package com.company;

public class Metodos {

    public enum Jugada {
        PAPEL, PIEDRA, TIJERAS,
    }

    public static Jugada aleatorio() {//Elige una jugada aleatoriamente
        Jugada[]jugadas= Jugada.values();
        return jugadas[(int) (Math.random() * jugadas.length)];
    }

    public static int ganadorRonda(String jugador, String ai) {//Coge dos Strings y calcula el ganador de la ronda
        if (jugador.equals(ai)) {
            return 2;
        }
        switch (jugador) {
            case "Piedra":
                if (ai.equals("Papel"))
                    return 1;
                else return 0;
            case "Tijeras":
                if (ai.equals("Piedra"))
                    return 1;
                else return 0;

            case "Papel":
                if (ai.equals("Tijeras"))
                    return 1;
                else return 0;
        }
        return 3;
    }

    public static Jugada jugadaUsuario(String jugadaUsuario) {//Cambia la jugada por un String estandarizado
        return switch (jugadaUsuario) {
            case "p", "P" -> Jugada.PIEDRA;
            case "T", "t" -> Jugada.TIJERAS;
            default-> Jugada.PAPEL;
        };
    }

    public static String muestraEstadistica(String[] array) {//Muestra estadisticas en un String
        int contador1 = 0;
        int contadorPiedra = 0, contadorPapel = 0, contadorTijeras = 0;
        for (int i = 0; i < array.length; i += 2) {//Cuenta las veces que gana el ususario
            int resultado = Metodos.ganadorRonda(array[i], array[i + 1]);
            if (resultado == 0) {
                contador1++;
            }
        }
        for (String s : array) {//Cuenta las Jugadas hechas durante el Juego
            switch (s) {
                case "Piedra" -> contadorPiedra++;
                case "Papel" -> contadorPapel++;
                case "Tijeras" -> contadorTijeras++;
            }
        }
        return ("Porcentaje partidas ganadas: " + (contador1 * 20) + "%." + "Porcentaje Piedras jugadas" + (contadorPiedra * 10) + "%." + "Porcentaje Papel jugados" + (contadorPapel * 10) + "%." + "Porcentaje Tijeras jugadas" + (contadorTijeras * 10) + "%.");
    }

}

