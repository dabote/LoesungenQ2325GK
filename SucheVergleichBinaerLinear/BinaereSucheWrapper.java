import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse LineareSuche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BinaereSucheWrapper
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    int[] arrayZahlen;
    Random randomGenerator;
    int anzZahlen;
    /**
     * Konstruktor für Objekte der Klasse LineareSuche
     */
    public BinaereSucheWrapper()
    {
        anzZahlen=1000;
        arrayZahlen = new int[anzZahlen];
        randomGenerator = new Random();
        
    }
    
    public void testeBinaereSucheRekursiv( int anzahlVersuche )
    {
        long timeStart;
        long timeEnd;
        
        timeStart = System.currentTimeMillis();
        for( int i=0; i<anzahlVersuche; i++){
            binareSucheRekursiv( randomGenerator.nextInt(10000), 0, anzZahlen  );    
        }
        timeEnd = System.currentTimeMillis();
        
        System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");

    }
            
            

    public void listeFuellen( int anzElemente )
    {      
        for( int i = 0; i<anzZahlen; i++ ){
            arrayZahlen[i] = randomGenerator.nextInt(10000);
        }
    }

    public void listeDrucken( )
    {
        for( int i = 0; i<anzZahlen; i++ ){
            System.out.println( arrayZahlen[i] );
        }
    }
    
    public boolean binareSucheRekursiv(int i, int lowerBound, int upperBound)
    {
        return false;
    }
    
    
}
