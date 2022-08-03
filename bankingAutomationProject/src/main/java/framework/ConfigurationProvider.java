package framework;

import java.util.HashMap;

public interface ConfigurationProvider {
	HashMap<String,String> get(String fileName);
}