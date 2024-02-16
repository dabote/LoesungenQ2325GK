import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse LineareSuche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LineareSucheWrapper
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    List<Integer> listeZahlen;
    Random randomGenerator;
    /**
     * Konstruktor für Objekte der Klasse LineareSuche
     */
    public LineareSucheWrapper()
    {
        listeZahlen = new List<Integer>();
        randomGenerator = new Random();
    }

    public void listeFuellen( int anzElemente )
    {
        while( ! listeZahlen.isEmpty() ){
            listeZahlen.remove();
        }
        for( int i = 0; i<anzElemente; i++ ){
            listeZahlen.append( randomGenerator.nextInt(1000)   );
        }
    }
    
    
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public boolean lineareSuche(int i, List<Integer> liste)
    {
        // tragen Sie hier den Code ein
        return false;
    }
    
    
}
