package propertiestask;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;
import utility.InputDefectException;
import utility.UtilityHelper;

public class PropertiesTask {
	public Properties createProperties() {
		return new Properties();
	}

	public void setProperty(Properties property,String key,String value) throws InputDefectException {
		UtilityHelper.nullCheck(property,"The properties cannot be empty");
		property.setProperty(key, value);
	}
	public String getProperty(Properties property,String key) throws InputDefectException {
		UtilityHelper.nullCheck(property,"The properties cannot be empty");
		return property.getProperty(key);
	}
	public void store(Properties property,Writer writerStream,String commend) throws IOException, InputDefectException {
		UtilityHelper.nullCheck(property,"The properties cannot be null");
		UtilityHelper.nullCheck(writerStream,"The write cannot be null");
		property.store(writerStream, commend);
	}
	public Set keySet(Properties property) throws InputDefectException {
		UtilityHelper.nullCheck(property,"The properties cannot be empty");
		return property.keySet();
	}
	public void load(Reader connection,Properties table) throws IOException, InputDefectException,IllegalArgumentException {
		UtilityHelper.nullCheck(table,"The properties cannot be empty");
		table.load(connection);
	}

}
