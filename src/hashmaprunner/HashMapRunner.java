package hashmaprunner;

import hashmaptask.HashMapTask;
import utility.InputDefectException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;


public class HashMapRunner {
	public static void main(String[] args) {
		 boolean loop=true;
		   while(loop) {
		   HashMapRunner use =new HashMapRunner();
		   System.out.println("This is an HashMap program");
		   int option=use.getNumber("Please Enter the option between 1-20 : ");
		   use.run(option);
		   int cont=use.getNumber("Enter 1 if you want to continue : ");
		   if(cont!=1) {
			   loop=false;
		    }
		   }
	  }
	
	private void run(int num) {
		HashMapTask task =new HashMapTask();
		switch(num) {
		case 1:
			try {
			HashMap<String,String> hashMap=task.createHashMap();
			int size=task.size(hashMap);
			System.out.println("The size of the hashmap is : "+size);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 2:
			try {
			HashMap<String,String> hashMap=task.createHashMap();
			multiStringAdd(hashMap,task);
			System.out.println("The hash map is : "+hashMap);
			System.out.println("the size is : "+task.size(hashMap));
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 3:
			try {
				HashMap<Integer,Integer> hashMap=task.createHashMap();
				multiIntegerAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 4:
			try {
				HashMap<String,Integer> hashMap=task.createHashMap();
				multiSIAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 5:
			try {
				HashMap<Object,Object> hashMap=task.createHashMap();
				multiObjectAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
				}
				catch(InputDefectException ex) {
					System.out.println(ex.getMessage());	
				}
				break;
		case 6:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				System.out.println("Null will be added for the next key and Value");
				task.add(hashMap, null, null);
				System.out.println("The size is : "+task.size(hashMap));
				System.out .println("the hashMap is : "+hashMap);
			}
		    catch(InputDefectException ex) {
		    	System.out.println(ex.getMessage());	
		    }
			break;
		case 7:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				System.out.println("Null will be the default key for the next element");
				task.add(hashMap, null, getString("Enter the value for the null key : "));
				System.out.println("The size is : "+task.size(hashMap));
				}
			    catch(InputDefectException ex) {
			    	System.out.println(ex.getMessage());	
			    }
			break;
		case 8:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
				String key=getString("Enter the key String you need to check for : ");
				boolean tof=task.checkKey(hashMap,key);
				System.out.println((tof)? "The key is found":"The key is not found");
				}
			catch(InputDefectException ex) {
					System.out.println(ex.getMessage());	
				}
				break;
		case 9:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
				String value=getString("Enter the value String you need to check for : ");
				boolean tof=task.checkValue(hashMap,value);
				System.out.println((tof)? "The value is found":"The value is not found");
				}
			catch(InputDefectException ex) {
					System.out.println(ex.getMessage());	
				}
				break;
		case 10:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
				Set<String> set=task.keySet(hashMap);
				for(String temp:set) {
					String str=getString("Enter the new value for the key "+temp+" : ");
					task.replace(hashMap, temp, str);
				}
				System.out.println("The final hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));	
			  }
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 11:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
				String key =getString("Enter the key of the value for : ");
				if(task.checkKey(hashMap,key)) {
					System.out.println("The value is : "+ task.get(hashMap,key));
				}
				else {
					System.out.println("key not found");
				}
				//System.out.println(task.checkMap(hashM11,key)?task.get(hashM11,key):"key not found in the map");	
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 12:
			try {
			HashMap<String,String> hashMap=task.createHashMap();
			multiStringAdd(hashMap,task);
			System.out.println("Null will be the default key for the next element");
			task.add(hashMap, null, getString("Enter the value for the null key : "));
			System.out.println("The value for null is "+task.get(hashMap,null));
			System.out.println("The hashmap is "+hashMap);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
			
		case 13:
			try {
			HashMap<String,String> hashMap=task.createHashMap();
			multiStringAdd(hashMap,task);
			String key=getString("Enter the key to be Searched : ");
			String word=getString("ENter the return in term of absence of key : ");
			String value=task.getOrDefault(hashMap, key, word);
			System.out.println("The value for thr key is "+value);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
			
			
		case 14:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				
				String key=getString("Enter the key to be removed : ");
				if(task.checkKey(hashMap,key)) {
					task.remove(hashMap,key);
					System.out.println("The key pair is removed");
					System.out.println("The hash map is : "+hashMap);
					System.out.println("the size is : "+task.size(hashMap));
				}
				else {
					System.out.println("The key is not fount in the map");
				}
				
				}
				catch(InputDefectException ex) {
					System.out.println(ex.getMessage());	
				}
			    break;
			    
		case 15:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				
				String key=getString("Enter the key to be removed : ");
				String value=getString("Enter the value of the key : ");
				if(task.checkKey(hashMap,key)) {
					if(task.removeIf(hashMap,key,value)){
					System.out.println("The key pair is removed");	
					System.out.println("The hash map is : "+hashMap);
					System.out.println("the size is : "+task.size(hashMap));
					}
					else {
						System.out.println("The keyvalue pair dosent match");
					}
				}
				else {
					System.out.println("The key is not fount in the map");
				}
				}
				catch(InputDefectException ex) {
					System.out.println(ex.getMessage());	
				}
			    break;
		case 16:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				
				String key=getString("Enter the key : ");
				String value=getString("Enter the new value : ");
				if(task.checkKey(hashMap,key)) {
					task.replace(hashMap, key, value);
					System.out.println("The hash map is : "+hashMap);
					System.out.println("the size is : "+task.size(hashMap));
				   }
			
				else {
					System.out.println("The key not found in the map");
				}
			}
				
				catch(InputDefectException ex) {
					System.out.println(ex.getMessage());	
				}
			    break;
		case 17:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				
				String key=getString("Enter the key : ");
				String newValue=getString("Enter the new value : ");
				String oldValue=getString("Enter the old value : ");
				if(task.checkKey(hashMap,key)) {
					if(task.replaceIf(hashMap, key, oldValue,newValue)) {
						System.out.println("The value is removed");
						System.out.println("The hash map is : "+hashMap);
						System.out.println("the size is : "+task.size(hashMap));
					}
					else {
						System.out.println("The old value dosent mathch the key");
					}
			    }
				else {
					System.out.println("The key not found in the map");
				}
				
			   }
				catch(InputDefectException ex) {
					System.out.println(ex.getMessage());	
				}
			    break;
		case 18:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				HashMap<String,String> copyHashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				task.copyContent(hashMap, copyHashMap);
				System.out.println("The old hash map is : "+hashMap);
				System.out.println("The new hash map is : "+copyHashMap);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 19:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				Set<String> set=task.keySet(hashMap);
				for(String temp:set) {
					String str=task.get(hashMap, temp);
					System.out.println("The value for the key "+temp+" is "+str);
				}
				
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
			break;
		case 20:
			try {
				HashMap<String,String> hashMap=task.createHashMap();
				multiStringAdd(hashMap,task);
				System.out.println("The hash map is : "+hashMap);
				System.out.println("the size is : "+task.size(hashMap));
				task.clear(hashMap);
				System.out.println("The hash map is : "+hashMap);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}
		case 100:
			/*?try {
				//task.add(null, null, null);
				//task.add(task.createHashMap(), null, "jef");
				//task.add(task.createHashMap(),, "jef" null);
				//task.checkKey(task.createHashMap(),null);
				//task.checkKey(null,null);
				//task.checkValue(task.createHashMap(),null);
				//task.clear(null);
				//task.copyContent( null,task.createHashMap());
				//task.copyContent( task.createHashMap(),null);
			    //task.get(task.createHashMap(),null);
				//task.keySet(null);
				//task.remove(task.createHashMap(),null);
				//task.removeIf(task.createHashMap(),null,null);
				//task.removeIf(task.createHashMap(),"jeg",null);
				//task.removeIf(task.createHashMap(),null,"jer");
				//task.size(null);
			}
			catch(InputDefectException ex) {
				System.out.println(ex.getMessage());	
			}*/
			break;
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
		  
		  
		  private void multiStringAdd(HashMap<String,String> hashM,HashMapTask task) throws InputDefectException{
			  int times=getNumber("Enter the number of pairs you need to enter : ");
			  int number=1;
			  while(times>0) {
				  task.add(hashM, getString("Enter the key String "+number+" : "),getString("Enter the value String "+number+" : ") );
				  times--;
				  number++;
			  }
			  
		  }
		  private void multiIntegerAdd(HashMap<Integer,Integer> hashM,HashMapTask task) throws InputDefectException{
			  int times=getNumber("Enter the number of pairs you need to enter : ");
			  int number =1;
			  while(times>0) {
				  task.add(hashM, getNumber("Enter the key Number "+number+" : "),getNumber("Enter the value Number "+number+" : ") );
				  times--;
				  number++;
			  }
			  
		  }
		  private void multiSIAdd(HashMap<String,Integer> hashM,HashMapTask task)throws InputDefectException {
			  int times=getNumber("Enter the number of pairs you need to enter : ");
			  int number =1;
			  while(times>0) {
				  task.add(hashM, getString("Enter the key Number "+number+" : "),getNumber("Enter the value Number "+number+" : ") );
				  times--;
				  number++;
			  }
			  
		  }
		  private void multiObjectAdd(HashMap<Object,Object> hashM,HashMapTask task)throws InputDefectException {
			  int times=getNumber("Enter the number of integer pairs you need to enter : ");
			  int intNumber =1;
			  while(times>0) {
				  task.add(hashM, getString("Enter the key Number "+intNumber+" : "),getNumber("Enter the value Number "+intNumber+" : ") );
				  times--;
				  intNumber++;
			  }
			  int times2=getNumber("Enter the number of string  pairs you need to enter : ");
			  int strNumber=1;
			  while(times2>0) {
				  task.add(hashM, getString("Enter the key String "+strNumber+" : "),getString("Enter the value String "+strNumber+" : ") );
				  times2--;
				  strNumber++;
			  }
			  
			  
		  }

}
