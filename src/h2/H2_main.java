package h2;

public class H2_main {

    public static void main(String[] args){
        Feld[][] felder = {
                {new Feld(false, 'L'), new Feld(true, 'R'), new Feld(false, 'L')},
                {new Feld(false, 'L'), new Feld(true, 'R'), new Feld(false, 'U')},
                {new Feld(false, 'L'), new Feld(false, 'U'), new Feld(false, 'U')},
        };

        Spielbrett brett = new Spielbrett(3);
        brett.setBrett(felder);

        Spielstein stein = new Spielstein(brett, 2,2);

        stein.go(7);
    }

}
