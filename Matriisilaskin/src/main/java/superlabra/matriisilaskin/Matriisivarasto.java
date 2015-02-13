package superlabra.matriisilaskin;

/**
 * Tämä luokka muuntaa syötteenä saadun merkkijonon taulukkomatriisiksi ja tallettaa sen.
 * @author anna
 */
public class Matriisivarasto {
   
    
    public Matriisivarasto() {
        
    }
    /**
     * muutaMatriisiksi muuttaa annetun merkkijonon matriisitaulukoksi.
     * @param merkkijono annettu merkkijono
     * @param pituus matriisin pituus
     * @param leveys matriisin leveys
     * @return Matriisi-olio
     */
    public Matriisi muutaMatriisiksi(String merkkijono, int pituus, int leveys) {
        double[][] matriisi = new double[pituus][leveys];
        int i = 0; int j = 0; String luku = "";
        
        for (int k = 0; k < merkkijono.length(); k++) {
            char c = merkkijono.charAt(k);
            
            if (c == ';') { // Jos c = ; niin siirrytään alemmalle riville
                matriisi[i][j] = Double.parseDouble(luku); // Lisätään luku matriisin soluun ij
                i++;
                j = 0;
                luku = "";
            } else if (c == ',') { // Jos c = , niin siirrytään oikealle
                matriisi[i][j] = Double.parseDouble(luku);
                j++;
                luku = "";
            } else if (c == '.'|| c == '-') { // Jos c = . tai - niin luvussa on desimaali tai negatiivinen arvo
                luku += c;
            } else if (String.valueOf(c).matches("[0-9]")) { // Jos c = numero niin lisätään lukuun
                luku += c;
                 if (k == merkkijono.length()-1) { // Jos luku on viimeinen merkkijonon merkki, lisätään se matriisiin.
                      matriisi[i][j] = Double.parseDouble(luku);
                 }
            } else { // Jos syöte sisältää merkkejä joita ei ole sallittu
                throw new IllegalArgumentException("Syöte voi sisältää vain merkit '0-9', '.', '-', ',' ja ';'.");
            }
        }
        
        return new Matriisi(matriisi);
    }
    
}
