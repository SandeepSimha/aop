@file:Suppress("unused")

package me.jdvp.androidaspectexample.lib.aspect

import android.util.Log
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature


/**
 * Aspect file used to add logging logic at compile time to common actions
 */
@Aspect
class AOPLog {

    // TODO change with your package name or class name here
    // Consider having a class in com.example.packA.packB.MyClass.java

    // To include all classes in packA and classes in subpackage : within(com.example.packA..*)
    // To include only one MyClass.java : within(com.example.packA.packB.MyClass.*)
    // Similarly for excluding just user '!within' Ex: !within(com.example.packA..*)
    // Also can append multiple condition using &&, || Ex: within(com.example.packA..*) && !within(com.example.packA.packB.MyClass.*)
    // Last once all classes are fetched using within, for executing methods just add execution(* *(..)) like below
    @Pointcut("(within(com.andhroid.myapplication..*) && !within(com.andhroid.myapplication.AOPLog..*)) && execution(* *(..))")
    fun allMethods() {
    }

    @Around("allMethods()")
    fun onMethodAdvice(joinPoint: JoinPoint?): Any? {
        val methodSignature = joinPoint!!.signature as MethodSignature

        val params = StringBuilder()
        for (param in joinPoint.args) {
            params.append(" $param")
        }
        val methodName = methodSignature.name + params
        val startTime = System.currentTimeMillis();
        val result = (joinPoint as ProceedingJoinPoint).proceed()
        val endTime = System.currentTimeMillis() - startTime
        Log.e("LoggingVM", "$methodName ---> ${endTime}")
        return result
    }
}