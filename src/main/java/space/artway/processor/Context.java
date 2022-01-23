package space.artway.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Context {
    private final Map<String, Object> variables;

    public Context(){
        variables = new HashMap<>();
    }

    public final Set<String> getVariableNames() {
        return this.variables.keySet();
    }

    public final Object getVariable(String name) {
        return this.variables.get(name);
    }

    public void setVariable(String name, Object value) {
        this.variables.put(name, value);
    }

    public void setVariables(Map<String, Object> variables) {
        if (variables != null) {
            this.variables.putAll(variables);
        }
    }

    public void removeVariable(String name) {
        this.variables.remove(name);
    }

    public void clearVariables() {
        this.variables.clear();
    }

}
