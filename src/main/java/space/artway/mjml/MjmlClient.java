package space.artway.mjml;

import io.camassia.mjml.MJMLClient;
import io.camassia.mjml.model.request.RenderRequest;
import io.camassia.mjml.model.response.RenderResponse;
import space.artway.config.MjmlTemplateProcessorConfig;

public class MjmlClient {

    private MJMLClient mjmlClient;


    public MjmlClient() {
        MjmlTemplateProcessorConfig config = MjmlTemplateProcessorConfig.get();
        mjmlClient = MJMLClient.newDefaultClient()
                .withApplicationID(config.getMjmlApplicationId())
                .withApplicationKey(config.getMjmlSecretKey());
    }


    public String render(String mjml) {
        RenderRequest request = new RenderRequest(mjml);
        RenderResponse response = mjmlClient.render(request);
        if (response.getErrors().isEmpty()) {
            return response.getHTML();
        }
        response.getErrors().forEach(renderResponseError -> {
            throw new RuntimeException(renderResponseError.getMessage());
        });
        return "";
    }
}
