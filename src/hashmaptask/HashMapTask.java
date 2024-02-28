package hashmaptask;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import utility.UtilityHelper;
import utility.InputDefectException;

public class HashMapTask {
	public <K,V> HashMap<K,V> createHashMap() {
		return new HashMap<K,V>();
	}
	public <K,V> void add(Map<K,V> map,K key,V value) throws InputDefectException{
		UtilityHelper.nullCheck(map);
		map.put(key, value);
	}
	public<K,V> int size(Map<K,V> map ) throws InputDefectException{
		UtilityHelper.nullCheck(map);
		return map.size();	
	}
	public boolean checkKey(Map<String,String> map,String key) throws InputDefectException {
		UtilityHelper.nullCheck(map);
		return map.containsKey(key);
	}
	public boolean checkValue(Map<String,String> map,String key) throws InputDefectException {
		UtilityHelper.nullCheck(map);
		return map.containsValue(key);
	}
	public void replace(Map<String,String> map ,String key,String value) throws InputDefectException {
		UtilityHelper.nullCheck(map);
		map.replace(key,value);
	}
	public Boolean replaceIf(Map<String,String> map ,String key,String oldValue,String newValue) throws InputDefectException {
		UtilityHelper.nullCheck(map);
		return map.replace(key,oldValue,newValue);
	}
	
	public Set<String> keySet(Map<String,String> map) throws InputDefectException{
		UtilityHelper.nullCheck(map);
		return map.keySet();
	}
	public String get(Map<String,String> map,String key) throws InputDefectException{
		UtilityHelper.nullCheck(map);
		return map.get(key);
	}
	public String remove(Map<String,String> map,String key) throws InputDefectException{
		UtilityHelper.nullCheck(map);
		return map.remove(key);
	}
	public boolean removeIf(Map<String,String> map,String key,String value) throws InputDefectException{
		UtilityHelper.nullCheck(map);
		return map.remove(key,value);
	}
	public void copyContent(Map<String,String> originalMap,Map<String,String> copyMap) throws InputDefectException{
		UtilityHelper.nullCheck(copyMap);
		UtilityHelper.nullCheck(originalMap);
	    copyMap.putAll(originalMap);
	}
	public void clear(Map<String,String> map) throws InputDefectException{
		UtilityHelper.nullCheck(map);
	    map.clear();
	}	
	public String getOrDefault(Map<String,String> map,String key,String word) throws InputDefectException{
		UtilityHelper.nullCheck(map);
	    return map.getOrDefault(key,word);
	}
}
