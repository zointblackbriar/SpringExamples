package com.tudresden.springapp.annotationprocessor;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface MASProperty {

}
