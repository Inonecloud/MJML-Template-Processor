package space.artway.factory;

import space.artway.config.MjmlTemplateProcessorConfig;
import space.artway.mjml.MjmlClient;
import space.artway.processor.Context;
import space.artway.processor.TemplateProcessor;
import space.artway.utils.FileUtils;


public class MjmlTemplateBuilder implements TemplateBuilder {
    private MjmlClient mjmlClient = new MjmlClient();

    private String body;

    private final Context context;

    protected MjmlTemplateBuilder() {
        this.context = new Context();
    }


    @Override
    public TemplateBuilder withParam(String key, Object value) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Key cannot be empty or null");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        context.setVariable(key.trim(), value);
        return this;
    }

    @Override
    public TemplateBuilder loadTemplate(String templatePath) {
        if (templatePath == null || templatePath.trim().isEmpty())
            throw new IllegalArgumentException("Template path can not be null or empty");
        if (!templatePath.endsWith(".mjml")) {
            templatePath += ".mjml";
        }
        this.body = renderTemplate(templatePath);
        return this;
    }


    private String renderTemplate(String templatePath) {
        MjmlTemplateProcessorConfig config = MjmlTemplateProcessorConfig.get();
        templatePath = config.getTemplateDirectory() + templatePath;

        final String emailTemplate = FileUtils.readFileAsString(templatePath);
        if (emailTemplate == null || emailTemplate.isEmpty()) {
            throw new RuntimeException();
        }
        TemplateProcessor templateProcessor = new TemplateProcessor(emailTemplate);

        return templateProcessor.process(this.context);
    }

    @Override
    public String build() {
        return mjmlClient.render(this.body);
    }

}
