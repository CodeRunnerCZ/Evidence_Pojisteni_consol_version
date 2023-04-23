package cz.zaverecnyProject;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Pojisteny {

    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefon;

    private ArrayList<Pojisteny> seznamPojistenych = new ArrayList<>();
    public Pojisteny(String jmeno, String prijmeni, int vek, int telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    public Pojisteny(){
    }

    public String getJmeno() {
        return jmeno;
    }
    public String getPrijmeni() {
        return prijmeni;
    }

    @Override
    public String toString() {
        return jmeno + " \t" + prijmeni + " \t \t" + vek + " \t" + " \t" + telefon;
    }

    public void vytvorPojisteneho() {
        try {
        Scanner sc = new Scanner(System.in, "Windows-1250");

        System.out.print("\nZadejte jméno: ");
        String jmeno = sc.nextLine().trim();
        System.out.print("Zadejte příjmení: ");
        String prijmeni = sc.nextLine().trim();
        System.out.print("Zadej věk: ");
        int vek = sc.nextInt();
        System.out.print("Zadejte telefonní číslo: ");
        int telefon = sc.nextInt();

        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
        seznamPojistenych.add(pojisteny);

        System.out.println("\nPojištěný " + "\nJméno \tPříjmení \tVěk \tTelefon\n" + pojisteny + "\nbyl úspěšně vytvořen");

        } catch (InputMismatchException e) {
            System.out.println("\nChybně zadaný věk, nebo telefonní číslo.\n * \tPro věk zadej celé číslo\n * \tTelefon zadávej ve formátu 9 čísel - např. 123123123");
        }
    }

    public void zobrazSeznamPojistenych() {
        if (seznamPojistenych.isEmpty()) {
            System.out.println("\nSeznam pojištěných je prázdný");
        } else {
            System.out.println("\nSeznam pojištěných:");
            System.out.println("Jméno \tPříjmení \tVěk \tTelefon");
            for (Pojisteny pojisteny : seznamPojistenych) {
                System.out.println(pojisteny);
            }
        }
    }

    public void najdiPojisteneho() {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        ArrayList<Pojisteny> hledanyPojistenec = new ArrayList<>();

        System.out.println("Zadejte jméno pojištěného: ");
        String hledaneJmeno = sc.nextLine().trim();
        for (Pojisteny pojisteny : seznamPojistenych) {
            if (pojisteny.getJmeno().equalsIgnoreCase(hledaneJmeno)) {
                hledanyPojistenec.add(pojisteny);
                System.out.println("Zadejte příjmení hledaného pojištěného:");
                String hledanePrijmeni = sc.nextLine().trim();
                for (Pojisteny pojisteny1 : hledanyPojistenec) {
                    if (pojisteny1.getPrijmeni().equalsIgnoreCase(hledanePrijmeni)) {
                        System.out.println("\nHledaný pojištěný: \nJméno \tPříjmení \tVěk \tTelefon");
                        System.out.println(pojisteny1);
                        return;
                    }
                }
            }
        }
        System.out.println("\nPojištěný, nebyl nalezen.");
    }

    public void odstranPojisteneho() {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        ArrayList<Pojisteny> pojistenecKvymazani = new ArrayList<>();

        System.out.println("Zadejte jméno pojištěného: ");
        String hledaneJmeno = sc.nextLine().trim();
        for (Pojisteny pojisteny : seznamPojistenych) {
            if (pojisteny.getJmeno().equalsIgnoreCase(hledaneJmeno)) {
                pojistenecKvymazani.add(pojisteny);
                System.out.println("Zadejte příjmení hledaného pojištěného:");
                String hledanePrijmeni = sc.nextLine().trim();
                for (Pojisteny pojisteny1 : pojistenecKvymazani) {
                    if (pojisteny1.getPrijmeni().equalsIgnoreCase(hledanePrijmeni)) {
                        System.out.println("\nPojištěný: \n \tJméno \tPříjmení \tVěk \tTelefon");
                        System.out.println("\t" + pojisteny1);
                        System.out.println("bude vymazán z evidence!");
                        System.out.println("\nSkutečně chcete pojištěného vymazat? (Zadejte ANO/NE)");
                        String vymazat = sc.nextLine().trim();
                        if(vymazat.equalsIgnoreCase("ano")) {
                            seznamPojistenych.remove(pojisteny1);
                            System.out.println("Pojištěný byl z evidence vymazán.");
                        } else {
                            System.out.println("Nedošlo k odstranění dat, pokračujte dále.");
                        }
                        return;
                    }
                }
            }
        }
        System.out.println("\nPojištěný, nebyl nalezen.");
    }

}

