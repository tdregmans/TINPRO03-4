public class Cijfer {
    private int studentnummer;

    private String modulecode;
    private int cijfer;
    private int jaar;

    public Cijfer (int studentnummer, String modulecode, int cijfer, int jaar) {
        this.studentnummer = studentnummer;
        this.modulecode = modulecode;
        this.cijfer = cijfer;
        this.jaar = jaar;
    }

    public void printCursus() {
        System.out.println("Cursus: [studentnummer:" + this.studentnummer
                + ", modulecode:" + this.modulecode
                + ", cijfer:" + this.cijfer
                + ", jaar:" + this.jaar + "]");
    }

    public int getStudentnummer() {
        return this.studentnummer;
    }

    public String getModulecode() {
        return this.modulecode;
    }

    public int getCijfer() {
        return this.cijfer;
    }

    public void setCijfer(int nieuwCijfer) {
        this.cijfer = nieuwCijfer;
    }

    public int getJaar() {
        return this.jaar;
    }

    public void setJaar(int nieuwJaar) {
        this.cijfer = nieuwJaar;
    }
}