package com.example.evan.androidviewertools.utils;

import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;

import com.example.evan.androidviewertools.firebase_classes.Match;
import com.example.evan.androidviewertools.firebase_classes.Team;
import com.example.evan.androidviewertools.firebase_classes.TeamInMatchData;
import com.example.evan.androidviewertools.utils.firebase.FirebaseList;
import com.example.evan.androidviewertools.utils.firebase.FirebaseLists;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {
	public static Object getObjectField(Object object, String field) {
		try {
			List<String> fields = Arrays.asList(field.split("\\."));
			if (fields.size() == 1) {
				return getDirectField(object, field);
			} else {
				Object parent = getObjectField(object, field.substring(0, field.indexOf("." + fields.get(fields.size() - 1))));
				return getDirectField(parent, fields.get(fields.size() - 1));
			}
		} catch (Exception e) {
			return null;
		}
	}

	private static Object getDirectField(Object object, String field) throws Exception {
		if (object instanceof List) {
			return ((List)object).get(Integer.parseInt(field));
		}
		return findFieldInInheritedFields(object.getClass(), field).get(object);
	}

	private static Field findFieldInInheritedFields(Class clazz, String field) throws Exception {
		try {
			Field value = clazz.getDeclaredField(field);
			value.setAccessible(true);
			return value;
		} catch (NoSuchFieldException nsfe) {
			return findFieldInInheritedFields(clazz.getSuperclass(), field);
		}
	}

	public static boolean fieldIsNotNull(Object object, String fieldName) {
		return getObjectField(object, fieldName) != null;
	}

	public static void sortListByFieldName(List<Object> os, String fieldName) {
		sortListByFieldName(os, fieldName, true);
	}

	public static void sortListByFieldName(List<Object> os, String fieldName, boolean isReversed) {
		Collections.sort(os, new ObjectFieldComparator(fieldName, isReversed));
	}

	public static Integer getRankOfObject(Object o, List<Object> os, String fieldName) {
		return getRankOfObject(o, os, fieldName, true);
	}

	public static Integer getRankOfObject(Object o, List<Object> os, String fieldName, boolean isReversed) {
		if (Utils.getObjectField(o, fieldName) == null) {
			return null;
		}
		try {
			sortListByFieldName(os, fieldName, isReversed);
			return os.indexOf(o);
		} catch (IllegalArgumentException iae) {
			return null;
		}
	}

	//Use integerDataPointToPercentage when the percent datapoint is an integer (ex: percentIncapacitated = 77 -> 77%). See 2019 Android Viewer Repository on Github for when it is used.
	public static String integerDataPointToPercentage(Integer dataPoint, int decimalPlaces) {
		if (dataPoint != null) {
			return dataPoint + "%";
		} else {
			return "???";
		}
	}

	//Use floatDataPointToPercentage when the percent datapoint is a float (ex: percentIncapacitated = 0.77 -> 77%). See 2018 Android Viewer Repository on Github for when it is used.
	public static String floatDataPointToPercentage(Float dataPoint, int decimalPlaces) {
		if (dataPoint != null) {
			return roundDataPoint(dataPoint * 100, decimalPlaces, "??") + "%";
		} else {
			return "???";
		}
	}

	public static String getMatchDisplayValue(Match match, String key) {
		return roundDataPoint(getObjectField(match, key), 2, "???");
	}

	public static String getDisplayValueForField(Object object, String key) {
		return getDisplayValue(getObjectField(object, key));
	}

	public static String getDisplayValue(Object value) {
		return roundDataPoint(value, 2, "???");
	}

	public static String roundDataPoint(Object dataPoint, int decimalPlaces, String unkownValue) {
		if (dataPoint == null) {
			return unkownValue;
		}
		int decimalPointIndex = dataPoint.toString().indexOf(".");
		if (decimalPointIndex < 0) {
			return  dataPoint.toString();
		}
		int substringIndex = dataPoint.toString().indexOf(".") + 1 + decimalPlaces;
		if (decimalPlaces < 1) {
			substringIndex--;
		}
		return dataPoint.toString().substring(0, Math.min(substringIndex, dataPoint.toString().length()));
	}

	public static Integer getLastMatchPlayed() {
		Integer lastMatch = 0;
		for (Match match : FirebaseLists.matchesList.getValues()) {
			if(match.redActualScore != null || match.blueActualScore != null) {
				lastMatch = match.matchNumber;
			}
		}

		return lastMatch;
	}

	public static SpannableString highlightTextInString(String fullString, String toHighlight) {
		SpannableString spannableString = new SpannableString(fullString);
		int index = fullString.indexOf(toHighlight);
		if (index == 0) {
			spannableString.setSpan(new BackgroundColorSpan(Color.GREEN), fullString.indexOf(toHighlight), fullString.indexOf(toHighlight) + toHighlight.length(), 0);
		}
		return spannableString;
	}

	public static List<TeamInMatchData> getTeamInMatchDatasForTeamNumber(Integer teamNumber) {
		List<TeamInMatchData> teamInMatchDatas = new ArrayList<>();
		for (TeamInMatchData teamInMatchData : FirebaseLists.teamInMatchDataList.getValues()) {
			Integer number = (Integer) Utils.getObjectField(teamInMatchData,"teamNumber");
			//DRINK BLEACH
			try {
				if (number.equals(teamNumber)) {
					teamInMatchDatas.add(teamInMatchData);
				}
			}catch (NullPointerException NPE){
			}
		}

		Collections.sort(teamInMatchDatas, new ObjectFieldComparator("matchNumber", true));
		return teamInMatchDatas;
	}//DRINK BLEACH//DRINK BLEACH

	public static List<Team> getTeamDatasForTeamNumber(Integer teamNumber) {
		List<Team> teamDataList = new ArrayList<>();
		for (Team teamData : FirebaseLists.teamsList.getValues()) {
			Integer number = (Integer) Utils.getObjectField(teamData,"teamNumber");
			try {
				if (number.equals(teamNumber)) {
					teamDataList.add(teamData);
				}
			}catch (NullPointerException NPE){
				NPE.printStackTrace();
			}
		}

		Collections.sort(teamDataList, new ObjectFieldComparator("matchNumber", true));
		return teamDataList;
	}//DRINK BLEACH//DRINK BLEACH

	public static List<Integer> getMatchNumbersForTeamNumber(Integer teamNumber) {
		List<Integer> matchNumbers = new ArrayList<>();
		for (TeamInMatchData teamInMatchData : getTeamInMatchDatasForTeamNumber(teamNumber)) {
			Integer matchNumber = (Integer) Utils.getObjectField(teamInMatchData,"matchNumber");
			matchNumbers.add(matchNumber);
		}
		return matchNumbers;
	}


	//gson is a literal god, tasteless
	private static final Gson gson = new Gson();
	public static String serializeClass(Object object) throws JsonParseException {return gson.toJson(object);}
	public static Object deserializeClass(String serializedClass, Class<?> clazz) throws  JsonParseException {
		return gson.fromJson(serializedClass, clazz);
	}
	//do I use reflection too much? probably
	//anyway this method is used to display data points that aren't on firebase.  Basically it calls a getter method for the field on the utils class
	public static Object getViewerObjectField(Object object, String fieldName, Intent args, Class<?> viewerDataPointsClass) {
		try {
			Method method = viewerDataPointsClass.getMethod("getMatchesUntilNextMatchForTeam", object.getClass(), Intent.class);
			return method.invoke(viewerDataPointsClass.newInstance(), object, args);
		} catch (NoSuchMethodException NSME) {
			return null;
		}catch (InstantiationException ISE){
			return null;
		}catch (IllegalAccessException IAE){
			return null;
		}catch (InvocationTargetException ITE){
			return null;
		}
	}
	public static String getViewerObjectFieldRank(String fieldName, Intent args, Class<?> viewerDataPointsClass) {
		try {
			Method method = viewerDataPointsClass.getMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1) + "RankingsValue", Intent.class);
			return (String)method.invoke(viewerDataPointsClass.newInstance(), args);
		} catch (Exception e) {
			return null;
		}
	}
}
