package com.sprAnnotation.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter{
    /**
     *
     * @param metadataReader: 读取到当前正在扫描的类信息
     * @param metadataReaderFactory：读取到其任何他类信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 当前类资源(类路径等)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();

        System.out.println("--> "+className);

        return false;
    }
}
