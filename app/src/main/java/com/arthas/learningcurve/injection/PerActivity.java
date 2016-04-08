package com.arthas.learningcurve.injection;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by garrett on 3/10/16.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
