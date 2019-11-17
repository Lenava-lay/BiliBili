package com.example.bilibili.contentobj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import androidx.annotation.NonNull;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RecommendLabel {
    @NonNull String value();
}
