package utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TimeUtility {
	public String getDay(long time,int regionNO)throws InputDefectException {
		ZoneId regionId=getZone(regionNO);
		Instant timeInstace=createInstaceMilly(time);
		ZonedDateTime zonedDateTime=createZonedDateTime(timeInstace, regionId);
		return zonedDateTime.getDayOfWeek().toString();
	}
	public String getMonth(long time,int regionNo)throws InputDefectException{
		ZoneId regionId=getZone(regionNo);
		Instant timeInstace=createInstaceMilly(time);
		ZonedDateTime zonedDateTime=createZonedDateTime(timeInstace, regionId);
		return zonedDateTime.getMonth().toString();
	}
	public int getYear(long time,int regionNo)throws InputDefectException{
		ZoneId regionId=getZone(regionNo);
		Instant timeInstace=createInstaceMilly(time);
		ZonedDateTime zonedDateTime=createZonedDateTime(timeInstace, regionId);
		return zonedDateTime.getYear();
	}
	public String currentZoneTime(int zoneIndex)throws InputDefectException {
		ZoneId region=getZone(zoneIndex);
		return ZonedDateTime.now(region).toString();
	}
	public Instant createInstaceMilly(long milliSecond) {
		return Instant.ofEpochMilli(milliSecond);
	}
	public ZonedDateTime createZonedDateTime(Instant time,ZoneId regionId) {
		return ZonedDateTime.ofInstant(time, regionId);
	}
	public ZoneId getZone(int index) throws InputDefectException{
		String[] zoneArray=getZoneArray();
		UtilityHelper.lengthIndexCheck(zoneArray.length, index);
		return ZoneId.of(zoneArray[index]);
	}
	public Set<String> getZoneIdSet() {
		return ZoneId.getAvailableZoneIds();
	}
	public String[] getZoneArray() {
		Set<String>  zoneIdSet=getZoneIdSet();
		String[] zoneId=new String[zoneIdSet.size()];
		return zoneIdSet.toArray(zoneId);
	}
	public String localTime() {		
		return LocalDateTime.now().toString();
	}	
}
