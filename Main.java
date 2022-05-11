import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    private static int beuteCaptain;
    private static int beuteCrew; // Das erhält die gesamte Crew
    private static int beuteJeMitglied; // Anteil, den jedes Mitglied erhält
    private static String beuteartZufallsBeute;
    private static int beute;
    private static int banditenAnzahl;

    private static int spielAuswahl = 1;
    public static ArrayList beuteArten = new ArrayList<String>();

    // Wenn spielBeenden 1 ist, wird das Spiel beendet

    public static void main(String[] args) {
        // array wird initialisiert
        beuteArten.add(" Kisten Gold");
        beuteArten.add(" Goldstücke");
        beuteArten.add(" Schnapsflaschen");
    spielen();


    }

    protected static void spielen() {

        // Hier wird unser Scanner definiert
        Scanner scan = new Scanner(System.in);
        while (spielAuswahl !=0) {
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
                System.out.println(beute);
                // Anzahl Beute je Mitglied
                beuteJeMitglied = (int) Math.ceil(beute / 2.0 / banditenAnzahl);
                System.out.println(beuteJeMitglied);
                // Alles, was die gesamte crew erhält
                beuteCrew = beuteJeMitglied * banditenAnzahl;

                // Berechnung Gold für die Crew
                System.out.println("Jedes Crewmitglied erhält " + getBeuteJeMitglied() + getBeuteartZufallsBeute() );
                // Berechnung Gold Captain
                beuteCaptain = beute - beuteCrew;
                System.out.println("Unser Captain hat " + getBeuteCaptain() + getBeuteartZufallsBeute() );


                // Erneute Spielabfrage
                System.out.println("Wollt ihr erneut auf Beutezug gehen, das Spiel beenden oder einen neuen erbeutbaren Gegenstand hinzufügen ? Fürs spielen bitte die 0 wählen, zum spielen die 1 und zum hinzufügen von Beute die 2");
                spielAuswahl= scan.nextInt();
                if (spielAuswahl == 2){
                    beuteHinzufügen();
                }
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


    public static ArrayList getBeuteArten() {
        return beuteArten;
    }


    public static int getBeuteJeMitglied() {
        return beuteJeMitglied;
    }


    public static String getBeuteartZufallsBeute() {
        return beuteartZufallsBeute;
    }

    protected static void beuteErmitteln(){
        int beuteartZufallsZahl;

        // Hier wird die Art der Beute ermittelt
        beuteartZufallsZahl = (int) (Math.random()* beuteArten.size());
        beuteartZufallsZahl = Math.round(beuteartZufallsZahl) -1;
        beuteartZufallsBeute = String.valueOf(beuteArten.get((int) beuteartZufallsZahl));
        System.out.println(beuteartZufallsZahl);


    }

    private static void beuteHinzufügen(){
      String neueBeute;

        Scanner scan = new Scanner(System.in);
      while (spielAuswahl == 2)
        try {
            System.out.println("Hier kannst du deine eigenen Ideen für Beute, welche du mit Captain Ciao erbeuten kannst hinzufügen");
            neueBeute = scan.next();
            beuteArten.add(neueBeute);
            beuteErmitteln();
            System.out.println("Um einen weiteren Gegenstand hinzuzufügen bitte erneut die 2 wählen, ansonsten wieder die 1 zum weiterspielen und die 0 zum beenden");
            spielAuswahl = scan.nextInt();
        }  catch (Exception InputMismatchException){
            System.out.println("Bitte gib eine gültige Zahl ein");
        }
      scan.close();

    }


}