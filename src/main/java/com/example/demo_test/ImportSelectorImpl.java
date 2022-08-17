package com.example.demo_test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author qiwenbo
 * @date 2022/8/17 14:46
 * @Description
 */
public class ImportSelectorImpl implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MergedAnnotations annotations = importingClassMetadata.getAnnotations();
        MergedAnnotation<TestImport> testImportMergedAnnotation = annotations.get(TestImport.class);
        System.out.println("======="+testImportMergedAnnotation.getString("value"));

        return new String[]{"com.example.e.TestImportA","com.example.e.TestImportB"};
    }
}
