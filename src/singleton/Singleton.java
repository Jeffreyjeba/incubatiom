package singleton;

import java.io.Serializable;
import utility.InputDefectException;

public class Singleton implements Cloneable,Serializable {

	private static final long serialVersionUID = 1L;


	private  String string;

	//thread caching safe
	private volatile static Singleton singletonObject=null;
	//constructor
	//reflection safe
	private Singleton() throws InputDefectException {
		if(singletonObject!=null) {
			throw new InputDefectException("The object cannot be created");
		}
		singletonObject=this;
	}
	//getter method
	//thread safe
	//double checked so no waiting time 
	public static Singleton getObject() throws InputDefectException {
		if(singletonObject==null) {
			synchronized(Singleton.class) {
				if(singletonObject==null) {
					new Singleton();
				}	
			}
		}
		return singletonObject;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("object cannot be cloned ");
	}
	//deSerializationProof
	public Object readResolve() { 
		return singletonObject;
	}

	//setter getter
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string=string;
	}
}
