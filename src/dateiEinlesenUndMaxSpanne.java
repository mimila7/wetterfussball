import java.io.*;

class dateiEinlesenUndMaxSpanne {
// diese Klasse bekommt die Datei aus der sie auslesen soll, als Variable übergeben.	
String dateiName;
// welche Spalten sollen verglichen werden?
String spalteMin;
String spalteMax;

//Konstruktor
public dateiEinlesenUndMaxSpanne(String dName, String sMin, String sMax)
{
	dateiName = dName;
	spalteMin = sMin;
	spalteMax = sMax;
}

//Methode, die die Überschriften einliest
public void ueberschriftenEinlesen(String dateiName)
{
try {
FileReader datei1 = new FileReader(dateiName);
BufferedReader datei2 = new BufferedReader(datei1);

String ueberschriften = datei2.readLine();
System.out.println(ueberschriften);

datei2.close();
}

catch(IOException e){   
        System.out.println("Falsche Eingabe, System meldet: " + e);
}	

}// end ueberschriftenEinlesen


//Spalte der Eintraege finden.
public int[] spaltenFinden(String dateiName, String spalteMin, String spalteMax)
{

//Rückgabe
	int[] gesamt= new int[2];
	
try {
FileReader datei1 = new FileReader(dateiName);
BufferedReader datei2 = new BufferedReader(datei1);

String ueberschriften = datei2.readLine();

//Trennzeichen ist ",", finden der Anzahl der "," vor dem Eintrag spalteMin und spalteMax
int positionSpalteMin = ueberschriften.indexOf(spalteMin);
int positionSpalteMax = ueberschriften.indexOf(spalteMax);

int i =0; int j=0;
int i1 = ueberschriften.indexOf(",");
int i2 = ueberschriften.indexOf(",");
while(i1<positionSpalteMin)
{
	i=i+1;
	i1=ueberschriften.indexOf(",", i1+1);
}

while(i2<positionSpalteMax)
{
	j=j+1;
	i2=ueberschriften.indexOf(",", i2+1);
}

gesamt[0]=i;
gesamt[1]=j;

datei2.close();
}

catch(IOException e){   
        System.out.println("Falsche Eingabe, System meldet: " + e);
}	

return gesamt;
}


//Methode, die die Datei durchläuft
public void maxSpanneAnschauen(String dateiName, String min, String max)
{
	try {
		FileReader datei1 = new FileReader(dateiName);
		BufferedReader datei2 = new BufferedReader(datei1);
		
		int[] intMaxSpanne= new int[2];
		int zeile =1;
		
		int[] anzahl = spaltenFinden(dateiName, min, max);
		String eintraege1 = datei2.readLine();
		String eintraege = datei2.readLine();
		
		while (eintraege != null) {
			int a =eintraege.indexOf(",");
			
			for(int i=1; i<anzahl[0]; i++) {
			a = eintraege.indexOf(",",a+1);
			}
			int minPosKommaplus1 =a+1;
			a = eintraege.indexOf(",",a+1);
			int minPosKommadanach =a;
			
            int b =eintraege.indexOf(",");
			
			for(int i=1; i<anzahl[1]; i++) {
			b = eintraege.indexOf(",",b+1);
			}
			int maxPosKommaplus1 =b+1;
			b = eintraege.indexOf(",",b+1);
			int maxPosKommadanach =b;
			
            String strMinWert = eintraege.substring(minPosKommaplus1, minPosKommadanach);
            String strMaxWert = eintraege.substring(maxPosKommaplus1, maxPosKommadanach);
        System.out.println(strMinWert+" "+strMaxWert);
        
        int MinWert = Integer.parseInt(strMinWert);
        int MaxWert = Integer.parseInt(strMaxWert);
        
        intMaxSpanne[0]= zeile;
        intMaxSpanne[1]= MaxWert-MinWert;
        
        System.out.println(intMaxSpanne[0]);
        System.out.println(intMaxSpanne[1]);
        
        zeile = zeile +1;
        eintraege = datei2.readLine();
		}
		
        datei2.close();
		}

		catch(IOException e){   
		        System.out.println("Falsche Eingabe, System meldet: " + e);
		}		
	
}

public int[] maxSpanneAusgeben(String dateiName, String min, String max) {
	
	//Rückgabe
	int[] maxSpanne = new int[4];
	
		try {
		FileReader datei1 = new FileReader(dateiName);
		BufferedReader datei2 = new BufferedReader(datei1);
		
		
		int zeile =1;
		maxSpanne [0]=zeile;
		maxSpanne [1]=0;
		maxSpanne [2]=0;//Minimalwert
		maxSpanne [3]=0;//Maximalwert
		
		int[] spanne = new int[2];
		
		//Methode spaltenFinden wird aufgerufen, um die position der Spalten zu ermitteln
		int[] anzahl = spaltenFinden(dateiName, min, max);
		//in der ersten Zeile stehen die Überschriften
		String ueberschriften = datei2.readLine();
		//ab der zweiten Zeile stehen die Daten.
		String eintraege = datei2.readLine();
		
		while (eintraege != null) {
			int a =eintraege.indexOf(",");
			
			for(int i=1; i<anzahl[0]; i++) {
			a = eintraege.indexOf(",",a+1);
			}
			int minPosKommaplus1 =a+1;
			a = eintraege.indexOf(",",a+1);
			int minPosKommadanach =a;
			
            int b =eintraege.indexOf(",");
			
			for(int i=1; i<anzahl[1]; i++) {
			b = eintraege.indexOf(",",b+1);
			}
			int maxPosKommaplus1 =b+1;
			b = eintraege.indexOf(",",b+1);
			int maxPosKommadanach =b;
			
            String strMinWert = eintraege.substring(minPosKommaplus1, minPosKommadanach);
            String strMaxWert = eintraege.substring(maxPosKommaplus1, maxPosKommadanach);
        //System.out.println(strMinWert+" "+strMaxWert);
        
        int MinWert = Integer.parseInt(strMinWert);
        int MaxWert = Integer.parseInt(strMaxWert);
        
        spanne[0]= zeile;
        spanne[1]= MaxWert-MinWert;
        
        if(spanne[1]>maxSpanne[1]){
        	maxSpanne[1]=spanne[1];
        	maxSpanne[0]=spanne[0];
        	maxSpanne[2]=MinWert;
        	maxSpanne[3]=MaxWert;
        }
        
        
        //System.out.println(intMaxSpanne[0]);
        //System.out.println(intMaxSpanne[1]);
        
        zeile = zeile +1;
        eintraege = datei2.readLine();
		}
		
        datei2.close();
		}

		catch(IOException e){   
		        System.out.println("Falsche Eingabe, System meldet: " + e);
		}
		
		System.out.println("Die groesste Spanne war an Tag " + maxSpanne[0] 
				+ " mit einer Spanne von " + maxSpanne[1]+ ", Minimaltemperatur von "+ maxSpanne[2]
						+ " und Maximaltemperatur von "+ maxSpanne[3]+".");
        
 return maxSpanne;
}



} //end class dateiEinlesenUndMaxSpanne
