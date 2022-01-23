package space.artway.factory;

public interface TemplateBuilder {

    String build();

    TemplateBuilder withParam(String key, Object value);

    TemplateBuilder loadTemplate(String templatePath);

    static TemplateBuilder mjml(){
        return new MjmlTemplateBuilder();
    }
}
