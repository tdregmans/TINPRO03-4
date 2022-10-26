import java.util.*;
import java.util.stream.*;

public class Administratie {

    public static Student getStudent(int studentnummer, Map<Integer,Student> studentenMap) {
        // return het Student-object van de student met meegegeven studentnummer
        return studentenMap.get(studentnummer);
    }

    public static Set<Student> getStudentenMetGehaaldVak(String modulecode, Set<Cijfer> cijfers, Map<Integer,Student> studentenMap) {
        // return een Set met studenten die een bepaald hebben gehaald

        return cijfers
                .stream()
                .filter(c -> c.getModulecode() == modulecode)
                .filter(c -> c.getCijfer() >= 6)
                .map(Cijfer::getStudentnummer)
                .map(studentenMap::get)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static Set<Cijfer> getGehaaldeVakken(int studentnummer, Set<Cijfer> cijfers) {
        // return een Set met vakken die door een bepaalde student zijn gehaald

        return cijfers
                .stream()
                .filter(c -> c.getStudentnummer() == studentnummer)
                .filter(c -> c.getCijfer() >= 6)
                .collect(Collectors.toSet());
    }

    public static Set<Cijfer> getNietGehaaldeVakken(int studentnummer, Set<Cijfer> cijfers) {
        // return een Set met vakken die door een bepaalde student niet zijn gehaald

        return cijfers
                .stream()
                .filter(c -> c.getStudentnummer() == studentnummer)
                .filter(c -> c.getCijfer() < 6)
                .collect(Collectors.toSet());
    }

    public static double getGemiddeldeVanVak(String modulecode, Set<Cijfer> cijfers) {
        // return het gemiddelde cijfer dat voor een bepaald vak is gehaald (van alle studenten die dat vak hebben)

        return cijfers
                .stream()
                .filter(c -> c.getModulecode() == modulecode)
                .map(p -> p.getCijfer())
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }

    public static int getSomStudent(int studentnummer, Set<Cijfer> cijfers) {
        // return de som van alle cijfers van een student

        return cijfers
                .stream()
                .filter(c -> c.getStudentnummer() == studentnummer)
                .map(p -> p.getCijfer())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double standaarddeviatieVanCijfers(int studentnummer, Set<Cijfer> cijfers) {
        // return de standaarddeviatie van alle cijfers van een student
        // Standaard Deviatie = Sqrt(Som((waarde - gemiddelde)^2) / aantal waardes)
        Set<Integer> cijferLijst = cijfers
                .stream()
                .filter(c -> c.getStudentnummer() == studentnummer)
                .map(p -> p.getCijfer())
                .collect(Collectors.toSet());

        double gemiddelde = cijferLijst
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);

        double som = 0;
        for (int cijferInt : cijferLijst) {
            double cijfer = cijferInt;
            som += Math.round(Math.pow(cijfer - gemiddelde, 2));
        }
        return Math.sqrt(som / cijfers.size());
    }

    public static double variatieInCijfers(String modulecode, Set<Cijfer> cijfers) {
        // return de variatie in cijfers van een bepaald vak
        // variatie = SD / gemiddelde
        Set<Integer> cijferLijst = cijfers
                .stream()
                .filter(c -> c.getModulecode() == modulecode)
                .map(p -> p.getCijfer())
                .collect(Collectors.toSet());

        double gemiddelde = cijferLijst
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);

        double som = 0;
        for (int cijfer : cijferLijst) {
            som += Math.round(Math.pow(cijfer - gemiddelde, 2));
        }

        return Math.sqrt(som / cijferLijst.size()) / gemiddelde;
    }

    public static double verschilTussenMV(String modulecode, Set<Cijfer> cijfers, Map<Integer,Student> studentenMap) {
        // return het verschil tussen het gemiddelde voor een vak van mannen min dat van vrouwen
        double gemiddeldeMannen = cijfers
                .stream()
                .filter(c -> c.getModulecode() == modulecode)
                .filter(c -> getStudent(c.getStudentnummer(),studentenMap).getGeslacht() == 'm')
                .map(p -> p.getCijfer())
                .collect(Collectors.toSet())
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);

        double gemiddeldeVrouwen = cijfers
                .stream()
                .filter(c -> c.getModulecode() == modulecode)
                .filter(c -> getStudent(c.getStudentnummer(),studentenMap).getGeslacht() == 'v')
                .map(p -> p.getCijfer())
                .collect(Collectors.toSet())
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);

        return gemiddeldeMannen - gemiddeldeVrouwen;
    }
}