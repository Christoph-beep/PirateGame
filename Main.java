import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    private static int beuteCaptain;
    private static int beuteCrew; // Das erhält die gesamte Crew
    public static int beuteJeMitglied; // Anteil, den jedes Mitglied erhält
    protected static String beuteartZufallsBeute;
    private static int beute;
    protected static int banditenAnzahl;
    private static int spielBeenden = 0;
    private static ArrayList beuteArten = new ArrayList<String>();
    // Wenn spielBeenden 1 ist, wird das Spiel beendet

    public static void main(String[] args) {
    spielen();


    }

    protected static void spielen() {

        // Hier wird unser Scanner definiert
        Scanner scan = new Scanner(System.in);
        while (spielBeenden != 1) {
            // Die BeuteArt wird jede Rund neu ermittelt
            beuteErmitteln();
            System.out.println("Bitte gib die Anzahl der Personen an, die sich inklusive dir auf auf den Beutezug begeben , grundsätzlich bekommt der Captain die Hälfte der Beute, der Rest wird gleichmässig aufgeteilt ");
            // Auffangen von Fehlern
            try {

                banditenAnzahl = scan.nextInt();

                double beuteMengeUngerundet;
                // Hier wird die Anzahl der Beute ermittelt
                beuteMengeUngerundet = Math.random() * 100 + 100;
                beute = (int) Math.round(beuteMengeUngerundet);
                // Anzahl Beute je Mitglied
                beuteJeMitglied = beute / 2 / banditenAnzahl;
                beuteJeMitglied = (int) Math.ceil(beuteJeMitglied);
                // Alles, was die gesamte crew erhält
                beuteCrew = beuteJeMitglied * banditenAnzahl;

                // Berechnung Gold für die Crew
                System.out.println("Jedes Crewmitglied erhält " + getBeuteJeMitglied() + beuteartZufallsBeute + " erhalten");
                // Berechnung Gold Captain
                beuteCaptain = beute - beuteCrew;
                System.out.println("Unser Captain hat " + getBeuteCaptain() + beuteartZufallsBeute + " erhalten");


                // Erneute Spielabfrage
                System.out.println("Wollt ihr erneut auf Beutezug gehen ? 0 steht für Ja und 1 für nein");
                spielBeenden = scan.nextInt();
            } catch (Exception InputMismatchException){
                System.out.println("Bitte gib eine Zahl an");
                spielen();
            }
        }
        scan.close();
        System.out.println("Captain Ciao freut sich auf den nächsten Beutezug mit dir");
    }

    // getters n setters
    public static double getBeuteCaptain() {
        return beuteCaptain;
    }

    public static int getBeute() {
        return beute;
    }


    public static int getBanditenAnzahl() {
        return banditenAnzahl;
    }

    public static void setBanditenAnzahl(int banditenAnzahl) {
        Main.banditenAnzahl = banditenAnzahl;
    }


    public static ArrayList getBeuteArten() {
        return beuteArten;
    }

    public static void setBeuteArten(ArrayList beuteArten) {
        Main.beuteArten = beuteArten;
    }

    public static int getBeuteJeMitglied() {
        return beuteJeMitglied;
    }


    protected static void beuteErmitteln(){
        double beuteartZufallsZahl;

        // Hier wird die Art der Beute ermittelt
        beuteArten.add(" Kisten Gold");
        beuteArten.add(" Goldstücke");
        beuteArten.add(" Schnapsflaschen");
        beuteartZufallsZahl = Math.random()*3;
        beuteartZufallsZahl = Math.round(beuteartZufallsZahl) -1;
        beuteartZufallsBeute = String.valueOf(beuteArten.get((int) beuteartZufallsZahl));
        System.out.println(beuteartZufallsZahl);


    }

}