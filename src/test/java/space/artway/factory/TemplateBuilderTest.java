package space.artway.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateBuilderTest {

    @Test
    void build() {
        final String htmlMail = TemplateBuilder.mjml()
                .loadTemplate("test.mjml")
                .build();

        assertAll(
                ()-> assertFalse(htmlMail.isEmpty())

        );
    }
}