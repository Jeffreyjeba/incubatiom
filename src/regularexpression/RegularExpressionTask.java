package regularexpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utility.InputDefectException;
import utility.UtilityHelper;

public class RegularExpressionTask {
	public boolean validatePhoenNo(CharSequence phoneNumber) {
		return comparator("^[7-9]{1}[0-9]{9}$",phoneNumber);
	}

	public boolean ValidateAlphaNume(CharSequence input) {
		return comparator("\\P{Alnum}", input);
	}

	public boolean validateStartsWith(CharSequence keyWord,CharSequence subject) {
		return comparator("^"+keyWord, subject);
	}

	public boolean validateEndsWith(CharSequence keyWord,CharSequence subject) {
		return comparator(keyWord+"$", subject);
	}

	public boolean validateStartsAndEndsWith(CharSequence keyWord,CharSequence subject) {
		return comparator("^"+keyWord+"$", subject);
	}

	public boolean validateContains(CharSequence keyWord,CharSequence subject) {
		return comparator(keyWord.toString(), subject);
	}

	public boolean validateEmail(CharSequence emailId) {
		return comparator("^[^@\\.]{1}[^@]+[@]{1}[^@\\.]+[\\.]{1}[^@\\.]+$",emailId);
	}
	
	public boolean validatePassWord(CharSequence passWord) {
		return comparator("((?=.*[A-Z]{1,})(?=.*[a-z]{1,})(?=.*[0-9]{1,})(?=.*\\p{Punct}{1,})).{8,}", passWord);
	}

	public<E extends CharSequence> int countListInSensitive(CharSequence KeyWord,List<E> subject) {
		int matchNo=0;
		for(CharSequence sub:subject) {
			if(caseInsensitiveComparator(KeyWord.toString(), sub)) {
				matchNo++;
			}
		}
		return matchNo ;
	}

	public<E extends CharSequence> boolean validateLengthRange(List<E> subject,int min,int max) throws InputDefectException {
		UtilityHelper.checkTwo(min, max);
		String regex="^.{"+min+","+max+"}$";
		for(CharSequence sub:subject) {
			if(!comparator(regex, sub)) {

				return false;
			}
		}
		return true;
	}

	public List<String> findAndSlice(CharSequence subject ,CharSequence beg,CharSequence end ) {
		Pattern pattern= Pattern.compile("["+beg+"]{1}[^"+end+"]*["+end+"]{1}");
		Matcher matcher1=pattern.matcher(subject);
		ArrayList<String> list= new ArrayList<>();
		while(matcher1.find()) {
			list.add( matcher1.group());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public<K,E extends CharSequence> Map<K, Integer> checkList(List<E> key,List<E> subject) throws InputDefectException {
		String regex = regexListMaker(key);
		HashMap<K, Integer> map= new HashMap<K, Integer>();
		UtilityHelper.nullCheck(regex,"The key list cannot be empty");
		int index=0;
		for(CharSequence sequence:subject) {
			if(comparator(regex, sequence)) {
				map.put((K) sequence,index);
			}
			index++;
		}
		return map;
	}



	private boolean comparator(String regex,CharSequence subject) {
		Pattern pattern= Pattern.compile(regex);
		Matcher matcher=pattern.matcher(subject);
		return matcher.find();
	}
	private boolean caseInsensitiveComparator(String regex,CharSequence subject) {
		Pattern pattern= Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(subject);
		return matcher.find();
	}
	private<E extends CharSequence> String regexListMaker(List<E> key) {
		String regex = null;
		for(CharSequence sequence:key) {
			regex=regex+"|"+sequence;
		}
		regex=regex.substring(1);
		return regex;
	}

}