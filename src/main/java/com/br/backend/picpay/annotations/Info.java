package com.br.backend.picpay.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Autor: Jean Paul <jeanpaulwebb@gmail.com>
 * Info: A classe Info é uma anotação personalizada para adicionar autor, comentário e data a classes.
 * Data: 2023-08-24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Info {
    String author() default "Jean Paul <jeanpaulwebb@gmail.com>";

    String comment() default "";

    String date() default "";
}