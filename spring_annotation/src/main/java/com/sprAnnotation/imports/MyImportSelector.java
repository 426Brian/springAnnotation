package com.sprAnnotation.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by Brian in 0:35 2018/12/13
 */
public class MyImportSelector implements ImportSelector {
    // AnnotationMetadata: 当前标注@Import 注解类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.sprAnnotation.bean.Blue", "com.sprAnnotation.bean.Yellow"};
    }
}
