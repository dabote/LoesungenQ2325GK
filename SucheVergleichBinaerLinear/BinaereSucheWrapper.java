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
            binaereSucheRekursiv( randomGenerator.nextInt(10000), 0, anzZahlen  );    
        }
        timeEnd = System.currentTimeMillis();
        
        System.out.println("Laufzeit binäre Suche rekursiv: " + (timeEnd - timeStart) + " Millisek.");

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
    
    public boolean binaereSucheRekursiv(int i, int lowerBound, int upperBound)
    {
        // Abbruch der Suche
        if( lowerBound > upperBound ){
            return false;
        }
        // idx berechnen
        int idx = (int)(lowerBound + upperBound ) / 2;
                      
        // Pruefen ob gefunden
        if( arrayZahlen[idx] == i ){
            return true;
        }
        // gesuchte Zahl ist kleiner als idx-Zahl
        else if( i < arrayZahlen[idx] ){
            return binaereSucheRekursiv(i, lowerBound, idx-1 );
        }
        // gesuchte Zahl ist größer als idx-Zahl
        else{
            return binaereSucheRekursiv(i, idx+1, upperBound);
        }
        
              
        
    }
    
    
}
