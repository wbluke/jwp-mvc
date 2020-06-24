package core.mvc.tobe;

import core.mvc.asis.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class HandlerMappings {

    private static final Object[] ANNOTATION_BASE_PACKAGE = {"next"};

    private final List<HandlerMapping> mappings = Arrays.asList(new RequestMapping(), new AnnotationHandlerMapping(ANNOTATION_BASE_PACKAGE));

    public void init() {
        for (HandlerMapping mapping : mappings) {
            mapping.initialize();
        }
    }

    public HandlerExecution getHandler(HttpServletRequest request) {
        return mappings.stream()
                .filter(handlerMapping -> handlerMapping.supports(request))
                .map(handlerMapping -> handlerMapping.getHandler(request))
                .findFirst()
                .orElse(null);
    }
}