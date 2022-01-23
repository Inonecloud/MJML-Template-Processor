package space.artway.processor;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateProcessor {
    private String mjml;

    public TemplateProcessor(String mjml) {
        this.mjml = mjml;
    }

    public String process(Context context) {
        for (String key : context.getVariableNames()) {

            process(key, context.getVariable(key));
        }
        return mjml;
    }

    public void process(String key, Object variable) {
        Pattern pattern = Pattern.compile("\\{\\{" + key + "\\}\\}");
        Matcher matcher = pattern.matcher(mjml);
        while (matcher.find()) {
            mjml = mjml.replace(matcher.group(0), Objects.toString(variable));
        }
    }
}
