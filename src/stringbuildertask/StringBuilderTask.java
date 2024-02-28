package stringbuildertask;

import utility.UtilityHelper;
import utility.InputDefectException;
public class StringBuilderTask{

																					// create empt *
	public StringBuilder createStringBuilder(){
		return new StringBuilder();
		
	}
	
																				 //create string over loaded *
	public StringBuilder createStringBuilder(String word){
		return new StringBuilder(word);
		
	}
																					//length *
	public int findLength(StringBuilder word) throws InputDefectException{
	    UtilityHelper.nullCheck(word);
		return word.length();
	}
																					//append *
	public StringBuilder appendString(StringBuilder wordSb,String word)throws InputDefectException{
	    UtilityHelper.nullCheck(wordSb);
		return wordSb.append(word);
	}
																					//append overload with deli *
	public StringBuilder appendString(StringBuilder wordSb,String word,String deli)throws InputDefectException{
	    appendString(wordSb,word);
		return appendString(wordSb,deli);
	}
		
																					//insert *
	public StringBuilder insertString(StringBuilder wordSb,String word,int index)throws InputDefectException{
		UtilityHelper.nullCheck(wordSb);
		lengthCheck(wordSb,index);
		return wordSb.insert(index,word);
	}
																					//insert overloaded with deli*
	public StringBuilder insertString(StringBuilder wordSb,String word,String deli,int index)throws InputDefectException{
		UtilityHelper.nullCheck(deli);
		lengthCheck(wordSb,index);
		int len=UtilityHelper.findLengthString(word);
		insertString(wordSb,word,index); // I India - wordSb, love - word , delim - space
 		return insertString(wordSb,deli,index+len);	
	}
	
	
																					//reverse*
	public StringBuilder reverse(StringBuilder wordSb)throws InputDefectException{
	    UtilityHelper.nullCheck(wordSb);
		return wordSb.reverse();
	}
																					//delete*
	public StringBuilder delete(StringBuilder wordSb,int start,int end)throws InputDefectException{
	    UtilityHelper.nullCheck(wordSb);
		startStopCheck(start,end,wordSb);
		return wordSb.delete(start,end);
	}
																					//replace *
	public StringBuilder replace(StringBuilder wordSb,int start,int end,String word)throws InputDefectException{
	    UtilityHelper.nullCheck(wordSb);
		startStopCheck(start,end,wordSb);
		return wordSb.replace(start,end,word);
	}
																						//deli position iterate *
	public int deliPositionIterate(StringBuilder wordSb,String deli,int times)throws InputDefectException{
		int index=0;
		while(times>=1){
		index=deliPosition(wordSb,deli,index+1);
		times--;
		}
		return index;
	}
	
	public int deliPosition(StringBuilder wordSb,String deli,int index)throws InputDefectException{
	    UtilityHelper.nullCheck(wordSb);
		return wordSb.indexOf(deli,index);
		
	}
	
	public int deliPosition(StringBuilder wordSb,String deli)throws InputDefectException{
		return deliPosition(wordSb,deli,0);
	}
	
	public int finalDeliPosition(StringBuilder wordSb,String deli)throws InputDefectException{
		return wordSb.lastIndexOf(deli);
	}
	private void lengthCheck(StringBuilder wordSb,int index)throws InputDefectException{
	    int len=findLength(wordSb);
		UtilityHelper.lengthIndexCheck(len,index);
		}
    private void startStopCheck(int start,int stop,StringBuilder wordSb)throws InputDefectException{
	    int len=findLength(wordSb);
		UtilityHelper.startStopCheck(start,stop,len);
		}
		
	public StringBuilder deliPositionInsert(StringBuilder wordSb,String word,String deli)throws InputDefectException{
		int position=deliPosition(wordSb,deli,1);
		insertString(wordSb,word,deli,position);
		return wordSb;
	}
}
