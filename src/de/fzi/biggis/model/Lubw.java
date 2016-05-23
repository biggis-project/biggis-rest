package de.fzi.biggis.model;

import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;

import de.fzi.biggis.exceptions.ParameterException;
import de.fzi.biggis.util.ReadFile;

public class Lubw {
	private ReadFile files;
	private Parameters parameters;
	private Set<String> allowedParams;
	private int limit = 0;
	private int offset = 0;
	private String provenance;
	
	public Lubw() {
		files = ReadFile.getInstance();
		parameters = new Parameters();
		allowedParams = parameters.getParameters();
		provenance = "https://amazonas.fzi.de/biggis/index.php/Messstation_4444_%28Karlsruhe_Nordweststadt%29";
	}

	public Lubw(MultivaluedMap<String, String> queryParameters) throws ParameterException {
		this();
		checkParams(queryParameters);
		
		// set limit
		if(queryParameters.containsKey("limit")) {
			limit = Integer.parseInt(queryParameters.get("limit").get(0));
		} else {
			limit = Integer.parseInt(parameters.getDefaultValue("limit"));
		}	
		
		// set offset
		if(queryParameters.containsKey("offset")) {
			offset = Integer.parseInt(queryParameters.get("offset").get(0));
		} else {
			offset = Integer.parseInt(parameters.getDefaultValue("offset"));
		}
	}

	public String getHtml() {
		StringBuilder sb = new StringBuilder();
		List<String> list = files.getFileContent("LUBW_Karlruhe-Nordwest.csv");
		String[] values;
		sb.append("<html>");
		sb.append("<head><title>LUBW_Karlruhe Nordwest csv</title></head>");
		sb.append("<body>");
		sb.append("<table border = 1>");
		sb.append("<tr><th>Datum / Uhrzeit</th><th>Wert</th><th>Herkunft</th></tr>");
		if (limit != 0) {
			for(int i = offset; i < limit + offset ; i++) {
				values = list.get(i).split(",");
				sb.append("<tr><td>");
				sb.append(values[0]);
				sb.append("</td><td>");
				if(values.length > 1) {
					sb.append(values[1]);
				}
				sb.append("</td><td><a href=");
				sb.append(provenance);
				sb.append(">LUBW 4444</a></td></tr>");
			}
		} else {
			for(String line: list) {
				values = line.split(",");
				sb.append("<tr><td>");
				sb.append(values[0]);
				sb.append("</td><td>");
				if(values.length > 1) {
					sb.append(values[1]);
				}
				sb.append("</td><td><a href=");
				sb.append(provenance);
				sb.append(">LUBW 4444</a></td></tr>");
			}
		}		
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");		
		return sb.toString();
	}

	public String getCsv() throws ParameterException {		
		StringBuilder sb = new StringBuilder();
		List<String> list = files.getFileContent("LUBW_Karlruhe-Nordwest.csv");
		sb.append("Datum / Uhrzeit,Wert,Herkunft");
		sb.append("\n");
		if (limit != 0) {
			for(int i = offset; i < limit + offset ; i++) {
				sb.append(list.get(i));
				sb.append(",");
				sb.append(provenance);
				sb.append("\n");
			}
		} else {
			for(String line: list) {
				sb.append(line);
				sb.append(",");
				sb.append(provenance);
				sb.append("\n");
			}
		}		
		return sb.toString();
	}

	public String getJson() throws ParameterException {
		StringBuilder sb = new StringBuilder();
		List<String> list = files.getFileContent("LUBW_Karlruhe-Nordwest.csv");
		String[] values;
		sb.append("{\n");
		sb.append("\"rows\" : [ \n");
		if (limit != 0) {
			for(int i = offset; i < limit + offset ; i++) {
				values = list.get(i).split(",");
				sb.append("{\"");
				sb.append(values[0]);
				sb.append("\",\n");
				if(values.length > 1) {
					sb.append(values[1]);
				} else {
					sb.append("null");
				}
				sb.append(",\n\"");
				sb.append(provenance);
				sb.append("\"\n},\n");
			}
		} else {
			for(String line: list) {
				values = line.split(",");
				sb.append("{\"");
				sb.append(values[0]);
				sb.append("\",\n");
				if(values.length > 1) {
					sb.append(values[1]);
				} else {
					sb.append("null");
				}
				sb.append(",\n\"");
				sb.append(provenance);
				sb.append("\"\n},\n");
			}
		}		
		sb.append("\n]");
		sb.append("}");			
		return sb.toString();
	}
	
	private void checkParams (MultivaluedMap<String, String> params) throws ParameterException {
		
		List<String> allowedValues = null;
		for(String param: params.keySet()) {
			if(allowedParams.contains(param)) {
				allowedValues = parameters.getValues(param);
				for(String value: params.get(param)) {
					if(!allowedValues.contains(value)) {
						StringBuilder message = new StringBuilder();
						message.append(value);
						message.append(" is not a valid value for the parameter ");
						message.append(param);
						message.append(". Valid values for ");
						message.append(param);
						message.append(" are: ");
						message.append(allowedValues);
						throw new ParameterException (message.toString());
					}
				}
			} else {
				StringBuilder message = new StringBuilder();
				message.append(param);
				message.append(" is not a valid parameter for this api. Valid parameters are: ");
				message.append(allowedParams);
				throw new ParameterException (message.toString());
			}
		}
	}
}
