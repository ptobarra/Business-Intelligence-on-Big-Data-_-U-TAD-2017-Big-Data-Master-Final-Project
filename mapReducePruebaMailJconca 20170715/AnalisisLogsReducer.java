package org.sourygna;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AnalisisLogsReducer extends Reducer<Text, Text, Text, Text>  { 	  	 	
  	
  	//el reducer a implementar es un reducer identidad que me sacará los datos de cada estacion meteorologica todos seguidos 	        
    
  	Text outKey = new Text();
  	/* la reduceOutputKey sera un Text tipo "US,20160101,TMAX,347" donde se guardan: 
  	 * el pais, la fecha, el tipo y la magnitud de cada medida */		
	
  	Text outValue = new Text();
  	/* el reduce outputValue definitivo sera un String vacio "" pues la info q necesito ya la tendre construida en la key */	    
	
	protected void reduce(Text countryNameComaText, Iterable<Text> measureDataTextList, Context context) throws IOException ,InterruptedException {
		
		String lineaDefinitivaStr; 			//esta variable auxiliar la uso para construir la key de salida del reducer
		String espacioDefinitvoStr = ""; 	//esta variable auxiliar la uso para construir el value de salida del reducer 
		
		String countryNameComaStr = countryNameComaText.toString(); 
		//convierto countryNameComaText a String para construir la linea definitiva
		
		for (Text measureDataText: measureDataTextList) {
			
			lineaDefinitivaStr = countryNameComaStr + measureDataText.toString();
			
			outKey.set(lineaDefinitivaStr);
	  		outValue.set(espacioDefinitvoStr);						
			
			context.write(outKey, outValue);			
		}				 
	}			
}