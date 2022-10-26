public class Cijfer {
    private int studentnummer;
    private int cijfer;

    public Cijfer (int studentnummer, int cijfer) {
        this.studentnummer = studentnummer;
        this.cijfer = cijfer;
    }

    public int getStudentnummer() {
        return this.studentnummer;
    }

    public int getCijfer() {
        return this.cijfer;
    }

    public void setCijfer(int nieuwCijfer) {
        this.cijfer = nieuwCijfer;
    }
}