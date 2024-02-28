package arraylisttask;
import java.util.List;
import java.util.ArrayList;
import utility.UtilityHelper;
import utility.InputDefectException;

public class ArrayListTask {
	
	public<E> ArrayList<E> createArrayList() {
		return new ArrayList<E>();
		}
	
	public <E>int findSize(List<E> list) throws InputDefectException  {
		UtilityHelper.nullCheck(list,"The collection cannot be null");
		return list.size();
	}
	public<E,T extends E> void addList(List<E> list ,T obj)throws InputDefectException {
		int size=findSize(list);
		addList(list,size,obj);
	  }
	public <E,T extends E> void addList(List<E> list ,int index,T obj)throws InputDefectException {
		 int size=findSize(list);
         UtilityHelper.lengthIndexCheck(size, index);
		 list.add(index, obj);
	  }
	public <E> void addAllList(List<E> baseList,List<E> addList) throws InputDefectException {
		UtilityHelper.nullCheck(baseList,"The collection cannot be null");
		UtilityHelper.nullCheck(addList,"The List cannot be null");
		addList.addAll(baseList);
	}
	public<E,T extends E> boolean checkList(List<E> list,T obj) throws InputDefectException {
		UtilityHelper.nullCheck(list,"The collection cannot be null");
		return list.contains(obj);
	  }	
	public<E> E getObj(List<E> list,int index) throws InputDefectException{
		int size=findSize(list);
        UtilityHelper.lengthIndexCheck(size, index);
		return list.get(index);
	}
	public<E,T extends E> int getIndex(List<E> list,T obj) throws InputDefectException {
		UtilityHelper.nullCheck(list,"The collection cannot be null");
		return list.indexOf(obj);
	}
	public<E,T extends E> int getLastIndex(List<E> list,T obj)throws InputDefectException {
		UtilityHelper.nullCheck(list,"The collection cannot be null");
		return list.lastIndexOf(obj);
	}
	public<E> List<E> slice(List<E> list,int startIndex,int endIndex) throws InputDefectException{
	    int size=findSize(list);
	    UtilityHelper.startStopCheck( startIndex, endIndex,size);
		return  list.subList(startIndex,endIndex);
	}
	public<E> void remove(List<E> baseList,List<E> addList) throws InputDefectException{
		UtilityHelper.nullCheck(baseList,"The main list cannot be null");                             
		UtilityHelper.nullCheck(addList,"The required object cannot be null"); 
		baseList.removeAll(addList);
	}
	public<E> void retain(List<E> baseList,List<E> addList) throws InputDefectException{
		UtilityHelper.nullCheck(baseList,"The main list cannot be null");
		UtilityHelper.nullCheck(addList,"The requirement list cannot be null");
		baseList.retainAll(addList);
	}
	public<E> void clear(List<E> list)throws InputDefectException {
		UtilityHelper.nullCheck(list);
		list.clear();
	}

	public<E> boolean contain(List<E> list,E obj) throws InputDefectException{
		UtilityHelper.nullCheck(list);
		return list.contains(obj);
	}
	public<E> void remove(List<E> list,int index) throws InputDefectException{
		int size=findSize(list);
		UtilityHelper.lengthIndexCheck(size, index);
		list.remove(index);
	}	
}
