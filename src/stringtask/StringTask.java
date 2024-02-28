package stringtask;

import utility.UtilityHelper ;
import utility.InputDefectException;

public class StringTask{
 public int findLength(String word) throws InputDefectException {								    	//1 findLength
  UtilityHelper.nullCheck(word);            			   
  return word.length();
  }

 public char[] stringToArray(String word) throws InputDefectException{
	UtilityHelper.nullCheck(word);           																 			 //2 stringToArray
   return word.toCharArray();
    }
  
 public char penultimate(String word,int number) throws InputDefectException{				       	 	 //3 penultimate 
    int length= findLength(word);
    UtilityHelper.lengthIndexCheck(length,number);
    return word.charAt(number);
    }

 public int count(String word,char letter) throws InputDefectException {		 		    		 		//4 count 
 int length4=findLength(word);
   int counts=0;
   for(int i=0;i<length4;i++){
    if(word.charAt(i)==letter){
     counts++;}
    }
   return counts;		                               
  }

 public int greatestPosition(String word,char letter) throws InputDefectException {     				    //5 greatestPosition
	 UtilityHelper.nullCheck(word);  
  int greatestPosition=word.lastIndexOf(letter);
  if(greatestPosition==-1){
  	throw new InputDefectException("The character " +letter+ " not found in the string" +word);
  }		
  return greatestPosition;
  }

 public String subArray(String word,int number) throws InputDefectException {		             			//6 subArray 
  int length=findLength(word);
  UtilityHelper.lengthIndexCheck(length,number);
  return slice(word,number,length-1);
  }

public String subInitArray(String word, int number) throws InputDefectException{		                    //7 subInitArray 
  int length=findLength(word);
  UtilityHelper.lengthIndexCheck(length,number);
  return slice(word,0,number);
  }

public String replaceFront(String word,String word2) throws InputDefectException {			    			//8 replaceFront 
   int length1= findLength(word);
   int length2= findLength(word2);
   UtilityHelper.lengthIndexCheck(length1,length2);
  String sub=slice(word,0,length2);
  return word.replaceFirst(sub,word2);
  }

public boolean starts(String word,String word2) throws InputDefectException{ 						        //9 starts
	UtilityHelper.nullCheck(word);
  return word.startsWith(word2);
  }
  
public boolean ends(String word,String word2) throws InputDefectException{ 							       //10 ends
  UtilityHelper.nullCheck(word);
  return word.endsWith(word2);
  }
public String upper(String word) throws InputDefectException{ 											   //11 upper
  UtilityHelper.nullCheck(word);
  return word.toUpperCase();
  }

public String lower(String word) throws InputDefectException{ 											   //12 lower
  UtilityHelper.nullCheck(word);
  return word.toLowerCase();
  }
  
public String reverse(String word) throws InputDefectException{ 						                   //13  reverse
 int length=findLength(word);
 String revString=null;
 int index=length-1;
 while(index>=0){
  revString=revString+word.charAt(index);
  index--;
    }
 return revString; 
  }

public String stringJoin(String deli,String[] arr) throws InputDefectException{ 						   //14 stringJoin
 String message="The delimeters cannot be null";
 UtilityHelper.nullCheck(deli,message);
 return String.join(deli,arr);	
 }

public String concatingAlternative(String word,String word2) throws InputDefectException{                  //15  concatingAlternative
	UtilityHelper.nullCheck(word); 
  return word.concat(word2);
  }
    
public String arrayToString(String[] word) throws InputDefectException{
	UtilityHelper.nullCheck(word); 																					    //16 arrayToString 
    return word.toString();
  }
	
  
public String join(String delimeter,String[] arr) throws InputDefectException{ 				         		//17 Join 
  String message="The delimeters cannot be null";
  UtilityHelper.nullCheck(delimeter,message);
  return String.join(delimeter,arr);
 }
 
public boolean equalSensitive(String word,String word2) throws InputDefectException{ 				        //18 equalSensitive
  UtilityHelper.nullCheck(word);
  return word.equals(word2);
  }
  
public boolean equalInSensitive(String word,String word2) throws InputDefectException{ 				        //19  equalInSensitive 
 UtilityHelper.nullCheck(word);
 return word.equalsIgnoreCase(word2);
  }

public String triming(String word) throws InputDefectException{ 				                           //20 trimming   
UtilityHelper.nullCheck(word);
 return word.trim();
 } 
 
 

public String slice(String word,int start,int end){															//slice support 
	String string=word.substring(start,end);
	return string;
 }
}
