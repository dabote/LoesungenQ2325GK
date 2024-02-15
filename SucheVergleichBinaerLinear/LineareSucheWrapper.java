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
    
    public void testeLineareSucheIterativ( int anzahlVersuche )
    {
        long timeStart;
        long timeEnd;
        
        timeStart = System.currentTimeMillis();
        for( int i=0; i<anzahlVersuche; i++){
            lineareSucheIterativ( randomGenerator.nextInt(10000) );    
        }
        timeEnd = System.currentTimeMillis();
        
        System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");

    }
            
            

    public void listeFuellen( int anzElemente )
    {
        listeZahlen.toFirst();
        while( ! listeZahlen.isEmpty() ){
            listeZahlen.remove();
        }
        for( int i = 0; i<anzElemente; i++ ){
            listeZahlen.append( randomGenerator.nextInt(10000)   );
        }
    }

    public void listeDrucken( )
    {
        listeZahlen.toFirst();
        while( listeZahlen.hasAccess() == true ){
            System.out.println(listeZahlen.getContent());
            listeZahlen.next();
        }
    }
    
    public boolean lineareSucheIterativ(int i)
    {
        int listeItem;
        listeZahlen.toFirst();
        while( listeZahlen.hasAccess() == true ){
            listeItem = listeZahlen.getContent();
            if( listeItem == i ){
                return true;
            }
            listeZahlen.next();
        }
        return false;
    }
    
    
}
