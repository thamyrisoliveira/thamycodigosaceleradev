package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object objeto) {
        BigDecimal somar = BigDecimal.ZERO;
        Field[] declaredFields = objeto.getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            Somar declaredAnnotation = f.getDeclaredAnnotation(Somar.class);
            if(declaredAnnotation != null){
                try {
                    f.setAccessible(true);
                    somar = somar.add((BigDecimal) f.get(objeto));
                } catch (ClassCastException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return somar;
    }

    @Override
    public BigDecimal subtrair(Object objeto) {
        BigDecimal resultado = BigDecimal.ZERO;
        Field[] declaredFields = objeto.getClass().getDeclaredFields();
        for (Field f: declaredFields) {
            Subtrair declaredAnnotation = f.getDeclaredAnnotation(Subtrair.class);
            if(declaredAnnotation != null){
                try {
                    f.setAccessible(true);
                    resultado = resultado.add((BigDecimal) f.get(objeto));
                } catch (ClassCastException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return resultado;
    }

    @Override
    public BigDecimal totalizar(Object objeto) {
        BigDecimal totalizador = BigDecimal.ZERO;
        totalizador = totalizador.add(somar(objeto));
        totalizador = totalizador.subtract(subtrair(objeto));
        return totalizador;
    }
}
