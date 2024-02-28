package rainbow;
public enum Rainbow{
	
	VIOLET(1),
	INDIGO(2),
	BLUE(3,"I am blue"),
	GREEN(4,"I am green"),
	YELLOW(5),
	ORANGE(6),
	RED(7);
	
	private  int value;
	private String word;
	
	//constructors
	private Rainbow(int value,String enumString){
		this.value=value;
		this.word=enumString;
	}
	private Rainbow(int value){
		this.value=value;
	}
	
	//getters
	public int getCode() {
		return value;
	}
	public String getWord() {
		return word;
	}
	
}

