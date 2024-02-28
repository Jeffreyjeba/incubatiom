package reflectionrunner;
		
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;


import utility.UtilityHelper;
		
public class Reflection {
	private static Logger logger=Logger.getLogger("reflection");
			
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void main(String[] args)  {
		try {
			UtilityHelper.logSetter("reflectlon",true, logger);
			Class student=Class.forName("utility.PersonalDetail");
			Method[] methods =student.getDeclaredMethods();
			Constructor[] constructors=student.getConstructors();
			Constructor newConstructor=student.getDeclaredConstructor(String.class,int.class);
			int option=1;
				
				
				for (Method method:methods) {
					logger.info(option+" "+method.getName());
					option++;
				}
				
				for (Constructor constructor:constructors) {
					logger.info(option+" "+constructor);
					for (Object type:constructor.getGenericParameterTypes()) {
						logger.info(" ,"+type);
					}
					option++;
				}
				
			//constructor 		
			Object constructorObj1=  (Object) constructors[1].newInstance("jeffrey",21);
			Object constructorObj2=newConstructor.newInstance("jerry",14);
			
			Method method = student.getDeclaredMethod("getName");
			String string=(String) method.invoke(constructorObj1);
			logger.info("\n The name is : "+string);
			
			String string2=(String) method.invoke(constructorObj2);
			logger.info("\n The second  name is : "+string2);
		}  
		catch (InstantiationException e) {
			logger.log(Level.WARNING, "This class cannot be instanciated ",e);
		} 
		catch (IllegalAccessException e) {
			logger.log(Level.WARNING, "You dont have acces to this  ",e);
		} 
		catch (IllegalArgumentException e) {
			logger.log(Level.WARNING, "There is a illegal argument ",e);
		} 
		catch (InvocationTargetException e) {
			logger.log(Level.WARNING, "",e);
		}
		catch (ClassNotFoundException e) {
			logger.log(Level.WARNING, "The required class cannot be found ",e);
		} 
		catch (NoSuchMethodException e) {
			logger.log(Level.WARNING, "No such method exist",e);
		} 
		catch (SecurityException e) {
			logger.log(Level.WARNING, "You dont have acces to this file",e);
		}
		catch (IOException e) {
			logger.log(Level.WARNING, "There is something wrong with io operations",e);
		}
		finally {
			logger.log(Level.INFO, "FINISHED");
		}
	}

}
