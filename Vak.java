import java.util.*;

public class Vak {
    private String modulecode;
    private int jaar;
    
    public Set<Cijfer> cijfers = new HashSet<Cijfer>();

    public Vak(String modulecode) {
        this.modulecode = modulecode;
    }

    public Vak(String modulecode, int jaar) {
        this.modulecode = modulecode;
        this.jaar = jaar;
    }

    public Vak(String modulecode, int jaar, Set<Cijfer> cijfers) {
        this.modulecode = modulecode;
        this.jaar = jaar;
        this.cijfers.addAll(cijfers);
    }

    public String getModulecode() {
        return this.modulecode;
    }

    public int getJaar() {
        return this.jaar;
    }

    public void setJaar(int nieuwJaar) {
        this.jaar = nieuwJaar;
    }
}
