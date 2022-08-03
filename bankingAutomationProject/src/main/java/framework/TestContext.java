package framework;

import java.util.HashMap;

public class TestContext {

	public static HashMap<String, Object> attributes;

	public static void setAttribute(String key, Object value) {
		if(attributes == null) {
			attributes = new HashMap<String, Object>();
		}
		if(getAttribute(key) != null) {
			attributes.remove(key);
		}
		attributes.put(key, value);
	}

	public static Object getAttribute(String key) {
		if(attributes == null) {
			return null;
		}
		return attributes.get(key);
	}
}