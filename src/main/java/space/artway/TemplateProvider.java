package space.artway;

import space.artway.config.MjmlTemplateProcessorConfig;
import space.artway.factory.TemplateBuilder;

public class TemplateProvider {



   public TemplateProvider(MjmlTemplateProcessorConfig config){
    MjmlTemplateProcessorConfig.get(config);
   }

   public String generate(TemplateBuilder templateBuilder){
       return templateBuilder.build();
   }
}
