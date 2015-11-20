package com.autofood.util;

public class ValidarCNPJ {
	
	public static boolean validaCNPJ(String strCNPJ) {
		
	    int iSoma = 0, iDigito;
	    char[] chCaracteresCNPJ;
	    String strCNPJ_Calculado;
	 
	    if (! strCNPJ.substring(0,1).equals("")){
	        try{
	            strCNPJ=strCNPJ.replace('.',' ');
	            strCNPJ=strCNPJ.replace('/',' ');
	            strCNPJ=strCNPJ.replace('-',' ');
	            strCNPJ=strCNPJ.replaceAll(" ","");
	            strCNPJ_Calculado = strCNPJ.substring(0,12);
	            if ( strCNPJ.length() != 14 ) return false;
	            chCaracteresCNPJ = strCNPJ.toCharArray();
	            for(int i = 0; i < 4; i++) {
	                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i] - 48 ) * (6 - (i + 1)) ;
	                }
	            }
	            for( int i = 0; i < 8; i++ ) {
	                if ((chCaracteresCNPJ[i+4]-48 >= 0) && (chCaracteresCNPJ[i+4]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i+4] - 48 ) * (10 - (i + 1)) ;
	                }
	            }
	            iDigito = 11 - (iSoma % 11);
	            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
	               /* Segunda parte */
	            iSoma = 0;
	            for (int i = 0; i < 5; i++) {
	                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i] - 48) * (7 - (i + 1)) ;
	                }
	            }
	            for (int i = 0; i < 8; i++) {
	                if ((chCaracteresCNPJ[i+5]-48 >= 0) && (chCaracteresCNPJ[i+5]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i+5] - 48) * (10 - (i + 1)) ;
	                }
	            }
	            iDigito = 11 - (iSoma % 11);
	            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
	            return strCNPJ.equals(strCNPJ_Calculado);
	        } catch (Exception e) {
	            return false;
	        }
	    } else return false;
	}

}