public class Patuljak {

    private  String ime;
    private  int ubioGoblina;
    private  int godinaRodjenja;
    private  double iskopaoZlata;

    public Patuljak(String ime, int ubioGoblina, int godinaRodjenja, double iskopaoZlata) {

        if (ime == null){
            throw new IllegalArgumentException("ime -> ");
        }
        this.ime = ime;
        this.ubioGoblina = ubioGoblina;
        this.godinaRodjenja = godinaRodjenja;
        this.iskopaoZlata = iskopaoZlata;
    }

    public String ime(){
        return ime;
    }
    public int ubioGoblina(){
        return ubioGoblina;
    }
    public int godinaRodjenja(){
        return godinaRodjenja;
    }
    public double iskopaoZlata(){
        return iskopaoZlata;
    }

    @Override
    public int hashCode() {

        final int prost = 31;
        int rezultat = 1;

        rezultat = prost * rezultat + ime.hashCode();
        rezultat = prost * rezultat + ubioGoblina();
        rezultat = prost * rezultat + godinaRodjenja();

        long tmp = Double.doubleToLongBits(iskopaoZlata());
        rezultat = prost * rezultat + (int) tmp;

        rezultat = prost * rezultat + (int) (tmp ^ (tmp >> 32));

        return rezultat;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) 						return true;
        if (obj == null) 						return false;
        if (this.getClass() != obj.getClass()) 	return false;

        Patuljak p = (Patuljak) obj;

        if (!this.ime().equalsIgnoreCase(p.ime())) 						return false;
        if (this.ubioGoblina() != p.ubioGoblina()) 						return false;
        if (this.godinaRodjenja() != p.godinaRodjenja()) 				return false;
        if (Math.abs(this.iskopaoZlata() - p.iskopaoZlata()) > 1e-8) 	return false;

        return true;
    }


    @Override
    public String toString() {
        return ime + ";" + ubioGoblina() + ";" + godinaRodjenja() + ";" + iskopaoZlata();
    }


    public static Patuljak fromString(String string) {

        if (string == null) return null;

        String[] delovi = string.split(";");

        return new Patuljak(
                delovi[0], Integer.parseInt(delovi[1].trim()), Integer.parseInt(delovi[2]), Double.parseDouble(delovi[3]));
    }
}
