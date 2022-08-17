package com.example.demo_test;

import com.example.e.TestImportB;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author qiwenbo
 * @date 2022/8/17 14:50
 * @Description
 */
public class ImportBeanDefinitionRegistrarImpl implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        MergedAnnotations annotations = importingClassMetadata.getAnnotations();
        MergedAnnotation<TestImport> testImportMergedAnnotation = annotations.get(TestImport.class);
        System.out.printf("======" + testImportMergedAnnotation.getString("value"));
        beanDefinitionRegistry.registerBeanDefinition("testImportB", new RootBeanDefinition(TestImportB.class));
    }
}
