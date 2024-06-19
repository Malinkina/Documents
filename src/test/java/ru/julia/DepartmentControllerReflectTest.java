package ru.julia;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.julia.controller.DepartmentController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentControllerReflectTest {

    @Test
    void printAllMethods() {
        final String sout = "%s %s.%s(%s)";
        final String args = "%s %s";
        String httpMethod = null;
        String className;
        String methodName;
        Class<DepartmentController> dc = DepartmentController.class;
        className = dc.getSimpleName();
        Method[] methods = dc.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                RequestMapping requestMapping = annotation.annotationType().getAnnotation(RequestMapping.class);
                if (requestMapping != null) {
                    RequestMethod[] methoded = requestMapping.method();
                    httpMethod = Arrays.stream(methoded).map(Enum::name).collect(Collectors.joining());
                }
            }
            methodName = method.getName();
            Parameter[] parameters = method.getParameters();
            List<String> params = new ArrayList<>();
            for (Parameter parameter : parameters) {
                String formattedArgs = args.formatted(parameter.getType().getSimpleName(), parameter.getName());
                params.add(formattedArgs);
            }
            String allArgs = String.join(", ", params);
            System.out.println(sout.formatted(httpMethod, className, methodName, allArgs));
        }
    }
}
