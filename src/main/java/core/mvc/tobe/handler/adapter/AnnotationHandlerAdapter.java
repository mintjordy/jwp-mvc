package core.mvc.tobe.handler.adapter;

import core.mvc.tobe.handler.resolver.HandlerMethodArgumentResolvers;
import core.mvc.tobe.view.ModelAndView;
import core.mvc.tobe.handler.mapping.HandlerExecution;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnotationHandlerAdapter implements HandlerAdapter {

    private final HandlerMethodArgumentResolvers handlerMethodArgumentResolvers;

    public AnnotationHandlerAdapter(HandlerMethodArgumentResolvers handlerMethodArgumentResolvers) {
        this.handlerMethodArgumentResolvers = handlerMethodArgumentResolvers;
    }

    @Override
    public boolean support(Object target) {
        return target instanceof HandlerExecution;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object target) {
        HandlerExecution invoker = (HandlerExecution) target;
        invoker.setHandlerMethodArgumentResolvers(handlerMethodArgumentResolvers);
        return invoker.handle(request, response);
    }
}
