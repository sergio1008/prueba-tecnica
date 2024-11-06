package com.serbernal.prueba_tecnica.infraestructure.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class ConfigAspects {

  @Before("execution(* findById(..))")
  public void loggingController(final JoinPoint jp) {
    final Object[] args = jp.getArgs();
    if ((long) args[0] < 1L) {
      log.info("Id negativo no valido: " + args[0]);
    }
  }
}
