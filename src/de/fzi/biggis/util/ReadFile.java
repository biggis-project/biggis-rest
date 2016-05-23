package de.fzi.biggis.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {
	private static ReadFile instance;
	private Map<String,List<String>> files;
	
	private ReadFile() {
		super();
		this.files = new HashMap<String, List<String>>();
	}
	
	public static synchronized ReadFile getInstance() {
		if(ReadFile.instance == null) {
			ReadFile.instance = new ReadFile();
		}
		return ReadFile.instance;
	}

	private List<String> openFile (String fileName) {
		List<String> fileContent;
		Path path = Paths.get("files/" + fileName);
		try {
			fileContent = Files.readAllLines(path);
		} catch (IOException e) {
			fileContent = new ArrayList<String>();
			fileContent.add(e.getMessage());
			e.printStackTrace();
		}		
		return fileContent;
	}

	public List<String> getFileContent(String fileName) {
		if (!files.containsKey(fileName)) {
			files.put(fileName, openFile(fileName));
		}
		return files.get(fileName);
	}
}
