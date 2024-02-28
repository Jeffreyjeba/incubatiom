package arraylistrunner;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Iterator;

import arraylisttask.ArrayListTask;
import utility.InputDefectException;
public class ArrayListRunner {
	public static void main(String[] args) {
	   boolean loop=true;
	   while(loop) {
	   ArrayListRunner use =new ArrayListRunner();
	   System.out.println("This is an Array List program");
	   int option=use.getNumber("Please Enter the option between 1-20 : ");
	   use.run(option);
	   int cont=use.getNumber("Enter 1 if you want to continue");
	   if(cont!=1) {
		   loop=false;
	   }
	   }
	
	}
	
	public void run(int num) {
		ArrayListTask task=new ArrayListTask();
		switch(num) {
		case 1:
			try {
			ArrayList<String> arrayL=task.createArrayList();
			int size=task.findSize(arrayL);
			System.out.println("The size i" +size);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 2:
			try {
			ArrayList<String> arrayL2=createMultiString(task);
			int size2 =task.findSize(arrayL2);
			System.out.println("The Size is" +size2);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 3:
			try {
			ArrayList<Integer> arrayL3=task.createArrayList();
			multiIntegerAdd(arrayL3,task);
			int size3=task.findSize(arrayL3);
			System.out.println("the siz is" +size3);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 4:
			try {
			ArrayList<Object> arrayL4=task.createArrayList(); 
			multiObjectAdd(arrayL4,task);
			int size4=task.findSize(arrayL4);
			System.out.println(size4);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 5:
			try {
			ArrayList<Object> arrayL5=task.createArrayList();
			multiObjectAdd(arrayL5,task);
			System.out.println(task.findSize(arrayL5));
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 6:
			try {
			ArrayList<String> arrayL6=createMultiString(task);
			String word6=getString("Enter the String to be searched for : ");
			int position6=task.getIndex(arrayL6,word6);
			positionPrinter(position6);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 7:	
			try{//review
			ArrayList<String> arrayL7=createMultiString(task);
			/*for(String str7:arrayL7) {
				System.out.println(str7);
			}*/
			Iterator<String> iter=arrayL7.iterator();
			while(iter.hasNext()) {
				int i=1;
				System.out.println("The elemet "+i+ " is : "+iter.next());
				i++;
			}
			System.out.println(task.findSize(arrayL7));
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 8:
			try {
			ArrayList<String> arrayL8=createMultiString(task);
			int position8=getNumber("Enter the position from which the value must be taken : ");
			String word8=task.getObj(arrayL8,position8);
			System.out.println(word8);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 9:
			try {
			ArrayList<String> arrayL9=createMultiString(task);
			String word9=getString("Enter the String to be searched for : ");
			int position9=task.getIndex(arrayL9,word9);
			int lastPosition9=task.getLastIndex(arrayL9,word9);
			positionPrinter(position9);
			positionPrinter(lastPosition9,"The last position of the given obj is : ");
			break;
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
		case 10:
			try {
			ArrayList<String> arrayL10=createMultiString(task);
			String word10=getString("Enter the String needs to be added");
			int position10=getNumber("Enter the index position to be added at");
			task.addList(arrayL10,position10,word10);
			System.out.println("The inserted array list is : "+arrayL10);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 11:
			try {
			ArrayList<String> arrayL11=createMultiString(task);
			System.out.println("First arrayalist is created");
			int num11=getNumber("Enter the starting index : ");
			int num111=getNumber("Enter the ending index : ");
			List<String> L111=task.slice(arrayL11,num11,num111);
			System.out.println("The inserted array list is : "+L111);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 12:
			try {
			ArrayList<String> arrayL12=createMultiString(task);
			System.out.println("First arrayalist is created");
			ArrayList<String> arrayL121=createMultiString(task);
			System.out.println("second arrayalist is created");
			ArrayList<String> arrayL122=task.createArrayList();
			task.addAllList(arrayL12, arrayL122);
			task.addAllList(arrayL121, arrayL122);
			System.out.println("The third arraylist is  ; "+arrayL122);
			}
			catch(InputDefectException ex) {
				ex.getMessage();
				}
			break;
		case 13:
			try {
			ArrayList<String> arrayL13=createMultiString(task);
			System.out.println("First arrayalist is created");
			ArrayList<String> arrayL131=createMultiString(task);
			System.out.println("second arrayalist is created");
			ArrayList<String> arrayL132=task.createArrayList();
			task.addAllList(arrayL131, arrayL132);
			task.addAllList(arrayL13, arrayL132);
			System.out.println("The third arraylist is  ; "+arrayL132);
			}
			catch(InputDefectException ex) {
				ex.getMessage();
			}
			break;
		case 14:
			try {
			ArrayList<Float> arrayL14=task.createArrayList();
			multiFloatAdd(arrayL14,task);
			int index14= getNumber("enter the position at which the object should be removed : ");
			task.remove(arrayL14,index14);
			System.out.println("The arrayList is : "+arrayL14);	
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 15:
			try {
			ArrayList<String> arrayL15=createMultiString(task);
			System.out.print("First arrayalist is created");
			ArrayList<String> arrayL151=createMultiString(task);
			System.out.print("second arrayalist is created");
			task.remove(arrayL15, arrayL151);
			System.out.println("The removed array list is : "+arrayL15);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 16:
			try {
			ArrayList<String> arrayL16=createMultiString(task);
			ArrayList<String> arrayL161=createMultiString(task);
			task.retain(arrayL16, arrayL161);
			System.out.println("THe altered string is : " +arrayL16);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 17:
			try {
			ArrayList<Long> arrayL17=task.createArrayList();
			multiLongAdd(arrayL17,task);
			task.clear(arrayL17);
			System.out.println("The Size is : "+task.findSize(arrayL17));
			}
			catch(InputDefectException ex) {
				System.out.print(ex.getMessage());
			}
			break;
		case 18:
			try {
			ArrayList<String> arrayL18=createMultiString(task);
			String str18=getString("Enter the string to be searched in Array List");
			boolean tOF=task.contain(arrayL18,str18);
			if(tOF) {
				System.out.println("The element found");
			}
			else {
				System.out.println("The element found");
			}
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());
			}
			
			break;
		case 100:
			/*try {
			//ArrayList<String> arrayL100=createMultiString(task);
			//arrayL100=null;
			//print("the new is :",alt100.addAL(arrayL100,null));
			//alt100.addAL(arrayL100,-1,null);
			//alt100.addAL(arrayL100,10,null);
			//alt100.addAllAL(arrayL100, null);
			//alt100.addAllAL(null, null);
			//alt100.addAllAL(null,arrayL100);
			//print("the new is",alt100.checkAL(arrayL100,null));
			//print("the new is",alt100.checkAL(null,null));
			//print("the new is ",alt100.checkAL(null,"et"));
			//alt100.clear(null);
			//alt100.contain(arrayL100, null);
			//alt100.contain(null,null);
			//alt100.findSize(arrayL100);
			//alt100.getIndex(arrayL100, null);
			//print(alt100.getIndex(arrayL100,"tom"));     //review
			//alt100.getIndex(null, null);
			//alt100.getObj(arrayL100, -5);
			//alt100.getObj(arrayL100, 10);
			//alt100.getObj(arrayL100, 10);
			//alt100.remove(null, arrayL100);
			//alt100.remove(arrayL100,null);
			//alt100.remove(null, null);
			//alt100.remove(arrayL100,0);
			//alt100.remove(arrayL100,-1);
			//alt100.remove(arrayL100,100);
			//alt100.remove(null,null);
			//alt100.retain(null,arrayL100);
			//alt100.retain(arrayL100,null);
			//alt100.retain(null,null);
			//alt100.slice(arrayL100, 1, 2);  //processing
			//alt100.slice(arrayL100, -1, 2);
			//alt100.slice(arrayL100, 0,-2);
			//alt100.slice(null, 1, 2);
			}
			catch(InputDefectException ex) {
				System.out.print(ex.getMessage());
			}
			break;*/
			
		default :
			    System.out.print("Enter a valid number from 1 to 18");
			break;	
		}
	}
	
	

	  Scanner scan=new Scanner(System.in);
	  private int getNumber(){
		  try{
			  
		   int temp= scan.nextInt();
		   scan.nextLine();
		   return temp;
		   }
		  catch(InputMismatchException x){
		   System.out.println("Please eneter an integer");
		   System.out.print("Enter again : ");
		   scan.nextLine();
		   return getNumber();
		  }
		  }
		  private int getNumber(String str){
		   System.out.print(str);
		   int temp= getNumber();
		   return temp;
		  }
		  private String getString(){
		   return scan.nextLine();
		  }
		  private String getString(String str){
		    System.out.print(str);
		   return getString();
		  }
		  
		  
		  
		  
		  private ArrayList<String> multiStringAdd(ArrayList<String> arrayL,ArrayListTask alt)throws InputDefectException {
			  int times =getNumber("Enter the number of strings to be added : ");
			  for (int i=0;times>i;i++) {
				  String str=getString("please enter the String "+ (i+1) +" :");
			      alt.addList(arrayL,str);
				  }
			  return arrayL;
			  }	
		  private ArrayList<Integer> multiIntegerAdd(ArrayList<Integer> arrayL,ArrayListTask alt)throws InputDefectException {
			  int times =getNumber("Enter the number of integers to be added : ");
			  for (int i=0;times>i;i++) {
				  int temp=getNumber("please enter the number "+ (i+1) +" :");
			      alt.addList(arrayL,temp);
				  }
			  return arrayL;
			  }	
		  private ArrayList<Long> multiLongAdd(ArrayList<Long> arrayL,ArrayListTask alt) throws InputDefectException{
			  int times =getNumber("Enter the number of integers to be added : ");
			  for (int i=0;times>i;i++) {
				  long temp=getNumber("please enter the long number "+ (i+1) +" :");
			      alt.addList(arrayL,temp);
				  }
			  return arrayL;
			  }	
		  private ArrayList<Float> multiFloatAdd(ArrayList<Float> arrayL,ArrayListTask alt)throws InputDefectException {
			  int times =getNumber("Enter the number of integers to be added : ");
			  for (int i=0;times>i;i++) {
				  float temp=getNumber("please enter the long number "+ (i+1) +" :");
			      alt.addList(arrayL,temp);
				  }
			  return arrayL;
			  }	
		  private ArrayList<Object> multiObjectAdd(ArrayList<Object> arrayL,ArrayListTask alt)throws InputDefectException {
			  int times =getNumber("Enter the number of strings to be added : ");
			  for (int i=0;times>i;i++) {
				  String str=getString("please enter the String "+ (i+1) +" :");
			      alt.addList(arrayL,str);
				  }
			  int times2 =getNumber("Enter the number of Integers to be added");
			  for (int i=0;times2>i;i++) {
				  int temp=getNumber("please enter the number " + (i+1) +" :");
			      alt.addList(arrayL,temp);
				  }
			  return arrayL;
			  }
		  private ArrayList<String> createMultiString(ArrayListTask alt)throws InputDefectException {
			  ArrayList<String> arrayL=alt.createArrayList();
			  return multiStringAdd(arrayL,alt);
		  }
		  private void positionPrinter(int position,String st) { 
				if(position==-1) {
					System.out.println("The element not found");
				}
				else {
					System.out.println(st + position);
				}
		  }
		   private void positionPrinter(int position) { 
					positionPrinter(position,"The element is at : ");
		  	}	  


}
