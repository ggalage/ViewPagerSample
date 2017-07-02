package com.viewpagersample.sei.viewpagersample.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by sei on 7/1/17.
 */

@Scope
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MainActivityScope {
}
