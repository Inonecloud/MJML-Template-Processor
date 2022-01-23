package space.artway.config;

public final class MjmlTemplateProcessorConfig {
    private static MjmlTemplateProcessorConfig instance;

    private String templateDirectory;
    private String mjmlApplicationId;
    private String mjmlPublicKey;
    private String mjmlSecretKey;


    private MjmlTemplateProcessorConfig() {
        init();
    }

    private void init() {
        templateDirectory = System.getenv("TEMPLATE_DIR") != null ? System.getenv("TEMPLATE_DIR") : "./templates/";
        mjmlApplicationId = System.getenv("MJML_APPLICATION_ID");
        mjmlPublicKey = System.getenv("MJML_PUBLIC_KEY");
        mjmlSecretKey = System.getenv("MJML_SECRET_KEY");

    }

    public static MjmlTemplateProcessorConfig get() {
        if (instance == null) {
            return new MjmlTemplateProcessorConfig();
        }
        return instance;
    }

    public static MjmlTemplateProcessorConfig get(MjmlTemplateProcessorConfig outerInstance) {
        return instance = outerInstance;
    }

    public void setTemplateDirectory(String templateDirectory) {
        if (templateDirectory == null) {
            throw new IllegalArgumentException("TemplateDirectory shouldn't be null");
        }
        this.templateDirectory = templateDirectory.trim();
    }

    public String getTemplateDirectory() {
        return templateDirectory;
    }

    public void setMjmlApplicationId(String mjmlApplicationId) {
        if (mjmlApplicationId == null) {
            throw new IllegalArgumentException("Application id should't be null");
        }
        this.mjmlApplicationId = mjmlApplicationId;
    }

    public String getMjmlApplicationId() {
        return this.mjmlApplicationId;
    }

    public void setMjmlPublicKey(String mjmlPublicKey) {
        if (mjmlPublicKey == null) {
            throw new IllegalArgumentException("Public key shouldn't be null");
        }
        this.mjmlPublicKey = mjmlPublicKey;
    }

    public String getMjmlPublicKey() {
        return this.mjmlPublicKey;
    }

    public void setMjmlSecretKey(String mjmlSecretKey) {
        if (mjmlSecretKey == null) {
            throw new IllegalArgumentException("Secret key shouldn't be null");
        }
        this.mjmlSecretKey = mjmlSecretKey;
    }

    public String getMjmlSecretKey() {
        return this.mjmlSecretKey;
    }
}
