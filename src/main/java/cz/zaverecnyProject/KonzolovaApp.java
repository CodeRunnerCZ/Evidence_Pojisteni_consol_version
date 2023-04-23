package cz.zaverecnyProject;

import java.util.InputMismatchException;
import java.util.Scanner;


public class KonzolovaApp {

    Pojisteny pojisteny = new Pojisteny();
    public void hlavniMenu(){
        try {
            while (true) {
                Scanner sc = new Scanner(System.in, "Windows-1250");

                System.out.println("\nEvidence pojištěnců:");
                System.out.println("=================================");
                System.out.println("Vyberte akci:");
                System.out.println("1 \tVytvořit pojištěného");
                System.out.println("2 \tZobrazit seznam pojištěných");
                System.out.println("3 \tVyhledat pojištěného");
                System.out.println("4 \tVymaž pojištěného z evidence");
                System.out.println("0 \tKonec");

                System.out.print("\nZadej volbu: ");
                int volba = sc.nextInt();

                switch (volba) {
                    case 0:
                        System.out.println("Konec");
                        return;
                    case 1:
                        pojisteny.vytvorPojisteneho();
                        break;
                    case 2:
                        pojisteny.zobrazSeznamPojistenych();
                        break;
                    case 3:
                        pojisteny.najdiPojisteneho();
                        break;
                    case 4:
                        pojisteny.odstranPojisteneho();
                        break;
                    default:
                        System.out.println("\nNeplatná volba\nZadejte číslo ze seznamu");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\nChybně zadaná volba\nZadejte číslo ze seznamu");
            hlavniMenu();
        }
    }
}
