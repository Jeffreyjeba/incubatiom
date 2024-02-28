package thread;

public class ExtendedThread extends Thread{
	//constructor
	private boolean toggle=true;
	String name;
	long sleep=0;
	public ExtendedThread(String name,long sleep) {
		this.name=name;
		this.sleep=sleep;
	}
	public ExtendedThread() {}

	@Override
	public void run() {
		while(toggle) {
			currentThread().setName(name);
			ThreadUtility taskMethods=new ThreadUtility();
			taskMethods.threadDetailPrint();
			if(sleep>0) {
				taskMethods.threadSleep(sleep);
			}
		}
	}
	public void setToggle(boolean toggle) {
		this.toggle=toggle;
	}
}
