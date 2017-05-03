# Desing Pattern

propiedades indizadas(arreglos) en los componentes
se accede a través de los metodos: 

private int/char/string/boolean propiedades[]:

public TipoDato[] getPropiedades(){ retunr propiedades };

-------------------------------------------------------------
	
-------------------------------------------------------------


jueves, 27 de abril de 2017
Suponer que se quiere hacer reactivos de opción multiple
para examenes

ejemplo 
unidad de minimo de medida de datos
[] kilobyte [] bit [] byte [] octeto 

---------------------------------------------------------------

---------------------------------------------------------------

Diseño del componente: 

pregunta: Texto(JLabel)
opciones: conjunto de JRadioButton 
respuesta correcta: Numero del conjunto de JRadioButton que considera correcta
Regresar si la opcion elegida fue la correcta

 ________
| JPanle |		
|________|		
|	 |<>-------|  
|	 |	   |	
|________|	   |
		   |
		   |
     --------------|--------------------
 ____|___	___|______	   ____|____	
| JLabel |     | opciones |	  | Integer |
|________|     | _________|	  |_________|
|	 |     |          |       |         |		    
|	 |     |	  |       |_________|
|________|     |__________|          