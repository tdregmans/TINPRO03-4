import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<Integer, Student> studenten = new HashMap<>();
        Set<Vak> vakken = new HashSet<Vak>();
        // maak 5x studenten en met elk 5 curssenen aan
        studenten.put(1000, new Student(1000,"Thomas",'m'));
        studenten.put(1054, new Student(1054,"Kees",'m'));
        studenten.put(1470, new Student(1470,"Anne",'v'));
        studenten.put(1843, new Student(1843,"Eva",'v'));
        studenten.put(1903, new Student(1903,"Thijs",'m'));

        Vak tes2 = new Vak("TES2", 1);
        Vak pro2 = new Vak("PRO2", 1);
        Vak sec = new Vak("SEC", 1);
        Vak dtb = new Vak("DTB", 1);
        Vak llc = new Vak("LLC", 1);

        vakken.add(tes2);
        vakken.add(pro2);
        vakken.add(sec);
        vakken.add(dtb);
        vakken.add(llc);

        tes2.cijfers.add(new Cijfer(1000, 3));
        tes2.cijfers.add(new Cijfer(1054, 8));
        tes2.cijfers.add(new Cijfer(1470, 8));
        tes2.cijfers.add(new Cijfer(1843, 9));
        tes2.cijfers.add(new Cijfer(1903, 7));

        pro2.cijfers.add(new Cijfer(1000, 5));
        pro2.cijfers.add(new Cijfer(1054, 6));
        pro2.cijfers.add(new Cijfer(1470, 8));
        pro2.cijfers.add(new Cijfer(1843, 6));
        pro2.cijfers.add(new Cijfer(1903, 9));

        sec.cijfers.add(new Cijfer(1000, 8));
        sec.cijfers.add(new Cijfer(1054, 5));
        sec.cijfers.add(new Cijfer(1470, 6));
        sec.cijfers.add(new Cijfer(1843, 4));
        sec.cijfers.add(new Cijfer(1903, 8));

        dtb.cijfers.add(new Cijfer(1000, 6));
        dtb.cijfers.add(new Cijfer(1054, 6));
        dtb.cijfers.add(new Cijfer(1470, 7));
        dtb.cijfers.add(new Cijfer(1843, 6));
        dtb.cijfers.add(new Cijfer(1903, 8));

        llc.cijfers.add(new Cijfer(1000, 7));
        llc.cijfers.add(new Cijfer(1054, 7));
        llc.cijfers.add(new Cijfer(1470, 7));
        llc.cijfers.add(new Cijfer(1843, 8));
        llc.cijfers.add(new Cijfer(1903, 7));

        // een opsomming van alle studenten die een bepaald vak hebben gehaald.
        Vak vak = tes2;
        System.out.println("De volgende studenten hebben " + vak.getModulecode() + " gehaald:");
        Set<Student> studentenMetGehaaldVak = Administratie.getStudentenMetGehaaldVak(vak, studenten);
        Iterator<Student> Iterator = studentenMetGehaaldVak.iterator();

        while (Iterator.hasNext()) {
            System.out.println("- " + Iterator.next().getNaam());
        }

        // een opsomming van alle vakken die één specifieke student heeft gehaald.
        int student = 1054;
        System.out.println("De student met het nummer " + student + " heeft de volgende vakken gehaald:");
        Set<Vak> gehaaldeVakken = Administratie.getGehaaldeVakken(student, vakken);
        Iterator<Vak> Iterator2 = gehaaldeVakken.iterator();

        while (Iterator2.hasNext()) {
            System.out.println("- " + Iterator2.next().getModulecode());
        }

        // een opsomming van alle vakken die dezelfde student nog moet halen.
        System.out.println("De student met het nummer " + student + " heeft de volgende vakken niet gehaald:");
        Set<Vak> nietGehaaldeVakken = Administratie.getNietGehaaldeVakken(student, vakken);
        Iterator<Vak> Iterator3 = nietGehaaldeVakken.iterator();

        while (Iterator3.hasNext()) {
            System.out.println("- " + Iterator3.next().getModulecode());
        }

        System.out.println("Andere stats: ");

        // het gemiddelde van alle cijfers die studenten voor een bepaald vak hebbengehaald.
        Vak vak1 = sec;
        System.out.println("Het gemiddelde van het vak " + vak1.getModulecode() + " is " + Administratie.getGemiddeldeVanVak(vak1));

        // de optelsom van alle cijfers die een (meegegeven) student voor alle vakkenheeft gehaald.
        int student1 = 1843;
        System.out.println("De som van alle cijfers van student " + student1 + " is " + Administratie.getSomStudent(student1, vakken));

        // de standaarddeviatie van alle cijfers die een student heeft gehaald.
        System.out.println("De standaarddeviatie van de cijfers van student " + student1 + " is " + Administratie.standaarddeviatieVanCijfers(student1, vakken));

        // de variantie van alle cijfers die alle studenten voor een vak gehaald hebben.
        System.out.println("De variatie in de cijfers van het vak " + vak1.getModulecode() + " is " + Administratie.variatieInCijfers(vak1));

        // de docent wil weten of mannen beter of slechter scoren voor een specifiekvak dan vrouwen.
        double verschil = Administratie.verschilTussenMV(vak1, studenten);
        if(verschil >= 0.0) {
            System.out.println("Mannen scoren t.o.v. vrouwen voor het vak " + vak1.getModulecode() + " gemiddeld " + verschil + " hoger.");
        }
        else {
            System.out.println("Mannen scoren t.o.v. vrouwen voor het vak " + vak1.getModulecode() + " gemiddeld " + -1 * verschil + " lager.");
        }
        
    }
}