import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dateiEinlesenUndMaxSpanneAbsName extends dateiEinlesenUndMaxSpanne {
	boolean abs;

	public dateiEinlesenUndMaxSpanneAbsName(String dName, String sMin, String sMax)
		{	
			super(dName, sMin, sMax);
			abs = false;
		}
	
	public dateiEinlesenUndMaxSpanneAbsName(String dName, String sMin, String sMax, boolean boolabs)
	{	
		super(dName, sMin, sMax);
		if(boolabs == true)
			abs=boolabs;
		else
		abs = false;
	}
	
    public String[] maxSpanneAusgeben(String dateiName, String min, String max, boolean bAbs) {
    	//Rückgabe
    			String[] maxSpanne = new String[4];
    			
    				try {
    				FileReader datei1 = new FileReader(dateiName);
    				BufferedReader datei2 = new BufferedReader(datei1);
    				
    				
    				String zeile ="";
    				maxSpanne [0]=zeile;
    				maxSpanne [1]="0";
    				maxSpanne [2]="0";//Minimalwert
    				maxSpanne [3]="0";//Maximalwert
    				
    				
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
    		        
    		            zeile = eintraege.substring(0,eintraege.indexOf(","));
    		            
    		        int MinWert = Integer.parseInt(strMinWert);
    		        int MaxWert = Integer.parseInt(strMaxWert);
    		        
    		        int spanne;
    		        
    		        if(bAbs)
    		        spanne= Math.abs(MaxWert-MinWert);
    		        else
    		        spanne=MaxWert-MinWert;
    		        
    		        if(spanne>Integer.parseInt(maxSpanne[1])){
    		        	maxSpanne[1]=Integer.toString(spanne);
    		        	maxSpanne[0]=zeile;
    		        	maxSpanne[2]=strMinWert;
    		        	maxSpanne[3]=strMaxWert;
    		        }
    		        
    		        
    		        //System.out.println(intMaxSpanne[0]);
    		        //System.out.println(intMaxSpanne[1]);
    		        
    		        eintraege = datei2.readLine();
    				}
    				
    		        datei2.close();
    				}

    				catch(IOException e){   
    				        System.out.println("Falsche Eingabe, System meldet: " + e);
    				}
    				if(bAbs)
    		    		System.out.println("Die groesste absolute Differenz ist bei Team " + maxSpanne[0] 
    		    				+ " mit Tordifferenz von " + maxSpanne[1]+ ", Tore: "+ maxSpanne[2]
    		    						+ " Gegentore: "+ maxSpanne[3]+".");
    		    		else
    		    			System.out.println("Die groesste Differenz ist bei Team " + maxSpanne[0] 
    		        				+ " mit Tordifferenz von " + maxSpanne[1]+ ", Tore: "+ maxSpanne[2]
    		        						+ " Gegentore: "+ maxSpanne[3]+".");
    		        
    		 return maxSpanne;	
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
            
            if(abs)
            spanne[1]= Math.abs(MaxWert-MinWert);
            else
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
    		if(abs)
    		System.out.println("Die groesste absolute Differenz ist bei Team " + maxSpanne[0] 
    				+ " mit Tordifferenz von " + maxSpanne[1]+ ", Tore: "+ maxSpanne[2]
    						+ " Gegentore: "+ maxSpanne[3]+".");
    		else
    			System.out.println("Die groesste Differenz ist bei Team " + maxSpanne[0] 
        				+ " mit Tordifferenz von " + maxSpanne[1]+ ", Tore: "+ maxSpanne[2]
        						+ " Gegentore: "+ maxSpanne[3]+".");
     return maxSpanne;
    }
    
}
