public class Student {
    private int studentnummer;
    private String naam;
    private char geslacht;
    private String klas;
    private String studierichting;

    public Student(int studentnummer_, String naam_, char geslacht_) {
        this.studentnummer = studentnummer_;
        this.naam = naam_;
        this.geslacht = geslacht_;
        this.klas = null;
        this.studierichting = null;
    }

    public Student(int studentnummer_, String naam_, char geslacht_, String klas_, String studierichting_) {
        this.studentnummer = studentnummer_;
        this.naam = naam_;
        this.geslacht = geslacht_;
        this.klas = klas_;
        this.studierichting = studierichting_;
    }

    public void printStudent() {
        System.out.println("Student: " + this.naam + " (" + this.studentnummer + "); " +
                            "geslacht: " + this.geslacht + "; "+ 
                            "klas: " + this.klas + "; studierichting: " + this.studierichting);
        
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public String getNaam() {
        return this.naam;
    }

    public char getGeslacht() {
        return this.geslacht;
    }

    public String getKlas() {
        return this.klas;
    }

    public void setKlas(String nieuweKlas) {
        this.klas = nieuweKlas;
    }

    public String getStudierichting() {
        return this.studierichting;
    }

    public void setStudierichting(String nieuweStudierichting) {
        this.studierichting = nieuweStudierichting;
    }
}