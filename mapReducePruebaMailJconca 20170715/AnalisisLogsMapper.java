package org.sourygna;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AnalisisLogsMapper extends Mapper<Text, Text, Text, Text> {
	
	Text outKey = new Text();   //la MapOutputKey sera un Text tipo "US," donde los caracteres antes de la coma son el nombre del pais donde se tomo la medida								
	Text outValue = new Text();	//el MapOutputValue sera un Text tipo "20160101,TMAX,347" donde se guardan la fecha, el tipo y la magnitud de cada medida
  	  		
  	protected void map(Text line, Text notUsed, Context context) throws IOException ,InterruptedException {
  		
  		String[] row = line.toString().split(","); //separamos la linea por comas y cada palabra (String) será un elemento de row
 		  		
  		String meteoStationNameStr = row[0];	//en el String row[0] guardo el nombre de la estación
  		  		String countryNameStr = meteoStationNameStr.substring(0,2); //en countryNameStr guardo el pais q son los 2 primeros caracteres
  		
  		String dateStr = row[1];				//en el String row[1] guardo la fecha de la medida  		
  		String measureTypeStr = row[2];			//en el String row[2] guardo el tipo de la medida
  		String measureStr = row[3];				//en el String row[3] guardo la magnitud de la medida
  		 		  		
  		String outKeyDefinitivaStr = countryNameStr + ",";
  		String outValueDefinitivoStr = dateStr + "," + measureTypeStr + "," + measureStr;
  		  		
  		outKey.set(outKeyDefinitivaStr);
  		outValue.set(outValueDefinitivoStr);  	
  		
  		context.write(outKey, outValue);	//emitimos la dupla de salida
  	}	
}