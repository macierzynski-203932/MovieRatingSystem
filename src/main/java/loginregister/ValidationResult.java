package loginregister;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {
    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }

    private Map<String,String> results = new HashMap<>();
}
