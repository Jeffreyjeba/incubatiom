import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import stringtask.StringTask;
import utility.InputDefectException;
import utility.Marker;


class nullCheck {
	StringTask task=new StringTask();
	@Test
	void test() {
		
		try {
		assertEquals(2,task.count("jeffrey", 'e'));
		}
		catch (InputDefectException e) {
			e.printStackTrace();
		}	
	}
	@Test
	@Category(Marker.class)
	void test2() {
		try {
		assertEquals("reyfre",task.replaceFront("jeffrey", "rey"));
		}
		catch (InputDefectException e) {
			e.printStackTrace();
		}	
	}
}
