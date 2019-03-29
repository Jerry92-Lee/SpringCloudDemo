package com.jerry.hello;

import com.jerry.hello.annotation.API;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Jerry
 * @version 2019-03-28
 */
@Component
public class ApiProcessor implements BeanPostProcessor {

    private static final String ANNOTATIONS = "annotations";
    private static final String ANNOTATION_DATA = "annotationData";

    public Object postProcessBeforeInitialization(@NonNull final Object bean, String beanName) throws BeansException {
        API myApi = bean.getClass().getAnnotation(API.class);
        if (myApi != null) {
            API alteredMyApi = new API() {

                @Override
                public Class<? extends Annotation> annotationType() {
                    return API.class;
                }

                @Override
                public String apiPath() {
                    System.out.println("apiType:" + myApi.apiType());

                    return "/" + myApi.apiType() + myApi.apiPath();
                }

                @Override
                public String apiType() {
                    System.out.println("apiType:" + myApi.apiType());
                    return myApi.apiType();
                }

            };
            alterAnnotationOn(bean.getClass(), API.class, alteredMyApi);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @SuppressWarnings("unchecked")
    private static void alterAnnotationOn(Class clazzToLookFor, Class<? extends Annotation> annotationToAlter, Annotation annotationValue) {
        try {
            // In JDK8 Class has a private method called annotationData().
            // We first need to invoke it to obtain a reference to AnnotationData class which is a private class
            Method method = Class.class.getDeclaredMethod(ANNOTATION_DATA, null);
            method.setAccessible(true);
            // Since AnnotationData is a private class we cannot create a direct reference to it. We will have to manage with just Object
            Object annotationData = method.invoke(clazzToLookFor);
            // We now look for the map called "annotations" within AnnotationData object.
            Field annotations = annotationData.getClass().getDeclaredField(ANNOTATIONS);
            annotations.setAccessible(true);
            Map<Class<? extends Annotation>, Annotation> map = (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);
            map.put(annotationToAlter, annotationValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
