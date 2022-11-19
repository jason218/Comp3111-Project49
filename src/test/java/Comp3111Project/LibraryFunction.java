package Comp3111Project;


import java.util.ArrayList;
import java.util.List;


public class LibraryFunction {
	
	public static  int checkForValidInput(String search){
        if (search.matches("[0-9]+")){
            if (search.length() !=8) {
                return -1;
            }
            return 0;
            // return checkForExistingStudentID(search);
        }
        if (checkForFormat(search)==1){
            return 1;
            // return checkForExistingStudentName(search);
        }
        return -1;
    }
	
	public static  int checkForFormat(String search){
        List<String> stringList = new ArrayList<>();
        char[] charSearch = search.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<charSearch.length;i++) {
        	if (charSearch[i]==' '||charSearch[i]==',') {
        		stringList.add(sb.toString());
        		sb.setLength(0);
        		if (charSearch[i]==' ') {
        			continue;
        		}
        		sb.append(charSearch[i]);
        		continue;
        	}
        	if (i==charSearch.length-1) {
        		sb.append(charSearch[i]);
        		stringList.add(sb.toString());
        	}
        	sb.append(charSearch[i]);
        }
        if (stringList.size()!=3) {
        	return -1;
        }
        else {
        	if (!stringList.get(0).matches("[a-zA-Z]+")) {
        		return -1;
        	}
        	if (!stringList.get(2).matches("[a-zA-Z]+")) {
        		return -1;
        	}
        	return 1;
        }
    }
	
}
