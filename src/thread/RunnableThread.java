package thread;

public class RunnableThread implements Runnable{
	@SuppressWarnings("unused")
	private boolean toggle=true;
	long sleep=0;
	public RunnableThread(long sleep) {
		this.sleep=sleep;
	}
	public RunnableThread() {}
	@Override
	public void run(){
		ThreadUtility taskMethods=new ThreadUtility();
		taskMethods.threadDetailPrint();
		if(sleep>0) {
			taskMethods.threadSleep(sleep);
		}
	}
	public void setToggle(boolean toggle) {
		this.toggle=toggle;
	}
}
