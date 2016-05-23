package de.fzi.biggis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parameters {
	private Map<String,List<String>> parameters;

	public Parameters() {
		super();
		parameters = new HashMap<String, List<String>>();
		parameters.put("quantity", quantities());
		parameters.put("unit", units());
		parameters.put("start", start());
		parameters.put("end", end());
		parameters.put("timeFormat", time());
		parameters.put("placeFormat", place());
		parameters.put("limit", limit());
		parameters.put("offset", offset());
//		parameters.put("resultFormat", result());
	}
	
	private List<String> quantities() {
		List<String> comp = new ArrayList<String>();
		comp.add("temp");
		return comp;
	}
	
	private List<String> units() {
		List<String> value = new ArrayList<String>();
		value.add("degreeeCelsius");
		return value;
	}
	
	private List<String> start() {
		List<String> start = new ArrayList<String>();
		start.add("1995-01-01");
		return start;
	}
	
	private List<String> end() {
		List<String> end = new ArrayList<String>();
		end.add("2015-12-31");
		return end;
	}
	
	private List<String> time() {
		List<String> time = new ArrayList<String>();
		time.add("iso8601");
		return time;
	}
	
	private List<String> place() {
		List<String> place = new ArrayList<String>();
		place.add("gausskrueger");
		return place;
	}
	
	private List<String> limit() {
		List<String> limit = new ArrayList<String>();
		limit.add("100");
		limit.add("1000");
		limit.add("0");
		return limit;
	}
	
	private List<String> offset() {
		List<String> offset = new ArrayList<String>();
		offset.add("0");
		offset.add("100");
		offset.add("1000");
		return offset;
	}
	
	private List<String> result() {
		List<String> result = new ArrayList<String>();
		result.add("csv");
		result.add("json");
		result.add("html");
		return result;
	}
	
	public Set<String> getParameters() {
		return parameters.keySet();
	}
	
	public List<String> getValues(String key) {
		return parameters.get(key);
	}
	
	public String getDefaultValue(String key) {
		return parameters.get(key).get(0);
	}
}
