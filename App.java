import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<Integer, Student> studenten = new HashMap<>();
        Set<Cijfer> cijfers = new HashSet<Cijfer>();

        // maak 5x studenten en met elk 5 curssenen aan
        studenten.put(1000, new Student(1000,"Thomas",'m'));
        studenten.put(1054, new Student(1054,"Kees",'m'));
        studenten.put(1470, new Student(1470,"Anne",'v'));
        studenten.put(1843, new Student(1843,"Eva",'v'));
        studenten.put(1903, new Student(1903,"Thijs",'m'));

        cijfers.add(new Cijfer(1000,"TES2", 3, 1));
        cijfers.add(new Cijfer(1000,"PRO2", 5, 1));
        cijfers.add(new Cijfer(1000,"SEC", 8, 1));
        cijfers.add(new Cijfer(1000,"DTB", 6, 1));
        cijfers.add(new Cijfer(1000,"LLC", 7, 1));

        cijfers.add(new Cijfer(1054,"TES2", 8, 1));
        cijfers.add(new Cijfer(1054,"PRO2", 6, 1));
        cijfers.add(new Cijfer(1054,"SEC", 5, 1));
        cijfers.add(new Cijfer(1054,"DTB", 6, 1));
        cijfers.add(new Cijfer(1054,"LLC", 7, 1));

        cijfers.add(new Cijfer(1470,"TES2", 8, 1));
        cijfers.add(new Cijfer(1470,"PRO2", 8, 1));
        cijfers.add(new Cijfer(1470,"SEC", 6, 1));
        cijfers.add(new Cijfer(1470,"DTB", 7, 1));
        cijfers.add(new Cijfer(1470,"LLC", 7, 1));

        cijfers.add(new Cijfer(1843,"TES2", 9, 1));
        cijfers.add(new Cijfer(1843,"PRO2", 6, 1));
        cijfers.add(new Cijfer(1843,"SEC", 4, 1));
        cijfers.add(new Cijfer(1843,"DTB", 6, 1));
        cijfers.add(new Cijfer(1843,"LLC", 8, 1));

        cijfers.add(new Cijfer(1903,"TES2", 7, 1));
        cijfers.add(new Cijfer(1903,"PRO2", 9, 1));
        cijfers.add(new Cijfer(1903,"SEC", 8, 1));
        cijfers.add(new Cijfer(1903,"DTB", 8, 1));
        cijfers.add(new Cijfer(1903,"LLC", 7, 1));

        // een opsomming van alle studenten die een bepaald vak hebben gehaald.
        String vak = "TES2";
        System.out.println("De volgende studenten hebben " + vak + " gehaald:");
        Set<Student> studentenMetGehaaldVak = Administratie.getStudentenMetGehaaldVak(vak, cijfers, studenten);
        Iterator<Student> Iterator = studentenMetGehaaldVak.iterator();

        while (Iterator.hasNext()) {
            System.out.println("- " + Iterator.next().getNaam());
        }

        // een opsomming van alle vakken die één specifieke student heeft gehaald.
        int student = 1054;
        System.out.println("De student met het nummer " + student + " heeft de volgende vakken gehaald:");
        Set<Cijfer> gehaaldeVakken = Administratie.getGehaaldeVakken(student, cijfers);
        Iterator<Cijfer> Iterator2 = gehaaldeVakken.iterator();

        while (Iterator2.hasNext()) {
            System.out.println("- " + Iterator2.next().getModulecode());
        }

        // een opsomming van alle vakken die dezelfde student nog moet halen.
        System.out.println("De student met het nummer " + student + " heeft de volgende vakken niet gehaald:");
        Set<Cijfer> nietGehaaldeVakken = Administratie.getNietGehaaldeVakken(student, cijfers);
        Iterator<Cijfer> Iterator3 = nietGehaaldeVakken.iterator();

        while (Iterator3.hasNext()) {
            System.out.println("- " + Iterator3.next().getModulecode());
        }

        System.out.println("Andere stats: ");

        // het gemiddelde van alle cijfers die studenten voor een bepaald vak hebbengehaald.
        String vak1 = "SEC";
        System.out.println("Het gemiddelde van het vak " + vak1 + " is " + Administratie.getGemiddeldeVanVak(vak1, cijfers));

        // de optelsom van alle cijfers die een (meegegeven) student voor alle vakkenheeft gehaald.
        int student1 = 1843;
        System.out.println("De som van alle cijfers van student " + student1 + " is " + Administratie.getSomStudent(student1, cijfers));

        // de standaarddeviatie van alle cijfers die een student heeft gehaald.
        System.out.println("De standaarddeviatie van de cijfers van student " + student1 + " is " + Administratie.standaarddeviatieVanCijfers(student1, cijfers));

        // de variantie van alle cijfers die alle studenten voor een vak gehaald hebben.
        System.out.println("De variatie in de cijfers van het vak " + vak1 + " is " + Administratie.variatieInCijfers(vak1, cijfers));

        // de docent wil weten of mannen beter of slechter scoren voor een specifiekvak dan vrouwen.
        double verschil = Administratie.verschilTussenMV(vak1, cijfers, studenten);
        if(verschil >= 0.0) {
            System.out.println("Mannen scoren t.o.v. vrouwen voor het vak " + vak1 + " gemiddeld " + verschil + " hoger.");
        }
        else {
            System.out.println("Mannen scoren t.o.v. vrouwen voor het vak " + vak1 + " gemiddeld " + -1 * verschil + " lager.");
        }

        
    }
}