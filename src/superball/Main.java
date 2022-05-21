package superball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // 3. feladat
            List<Donto> dontok = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("SuperBowl.txt"))) {
                String sor;

                reader.readLine(); // fejléc kihagyása

                while ((sor = reader.readLine()) != null) {
                    Donto donto = new Donto(sor);
                    dontok.add(donto);
                }
            }

            // 4. feladat
            System.out.print("4. feladat: ");
            System.out.println("Döntők száma: " + dontok.size());

            // 5. feladat
            System.out.print("5. feladat: ");

            int osszeg = 0;

            for (Donto donto : dontok) {
                // Math.abs-ra nincs szükség, mivel szerzett >= kapott (specifikáció)
                int kulonbseg = donto.getSzerzett() - donto.getKapott();
                osszeg += kulonbseg;
            }

            double atlag = (double) osszeg / dontok.size();

            System.out.printf("Átlagos pontkülönbség: %.1f\n", atlag);

            // 6. feladat
            System.out.print("6. feladat: ");

            Donto legtobbNezo = null;

            for (Donto donto : dontok) {
                if (legtobbNezo == null || donto.getNezoszam() > legtobbNezo.getNezoszam()) {
                    legtobbNezo = donto;
                }
            }

            RomaiSorszam romaiSorszam = new RomaiSorszam(legtobbNezo.getSorszam());

            System.out.println("A legmagasabb nézőszám a döntők során:");
            System.out.println("\tSorszám (dátum): " + romaiSorszam.getArabSsz() + " (" + legtobbNezo.getDatum() + ")");
            System.out.println("\tGyőztes csapat: " + legtobbNezo.getGyoztes() + ", szerzett pontok: " + legtobbNezo.getSzerzett());
            System.out.println("\tVesztes csapat: " + legtobbNezo.getVesztes() + ", szerzett pontok: " + legtobbNezo.getKapott());
            System.out.println("\tHelyszín: " + legtobbNezo.getHelyszin());
            System.out.println("\tVáros, állam: " + legtobbNezo.getVarosAllam());
            System.out.println("\tNézőszám: " + legtobbNezo.getNezoszam());

            // 7. feladat
            Map<String, Integer> csapatSzamlalo = new HashMap<>();

            try (PrintWriter writer = new PrintWriter("SuperBowlNew.txt")) {
                writer.println("Ssz;Dátum;Győztes;Eredmény;Vesztes;Nézőszám");

                for (Donto donto : dontok) {
                    int gyoztesSzamlalo = csapatSzamlalo.getOrDefault(donto.getGyoztes(), 0) + 1;
                    csapatSzamlalo.put(donto.getGyoztes(), gyoztesSzamlalo);
                    int vesztesSzamlalo = csapatSzamlalo.getOrDefault(donto.getVesztes(), 0) + 1;
                    csapatSzamlalo.put(donto.getVesztes(), vesztesSzamlalo);

                    romaiSorszam.setRomaiSsz(donto.getSorszam());
                    String sor = romaiSorszam.getArabSsz() + ";"
                            + donto.getDatum() + ";"
                            + donto.getGyoztes() + " (" + gyoztesSzamlalo + ");"
                            + donto.getEredmeny() + ";"
                            + donto.getVesztes() + " (" + vesztesSzamlalo + ");"
                            + donto.getNezoszam();
                    writer.println(sor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
