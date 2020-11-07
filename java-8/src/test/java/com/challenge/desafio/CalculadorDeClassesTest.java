package com.challenge.desafio;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculadorDeClassesTest {
  @Test
    public void deveSomar() {
        Extrato extrato = new Extrato(new BigDecimal("1500"), new BigDecimal("600"), new BigDecimal("750"), new BigDecimal("250"));
        CalculadorDeClasses calculadora = new CalculadorDeClasses();
      BigDecimal somar = calculadora.somar(extrato);
      Assert.assertEquals(new BigDecimal("2100"), somar);
    }
    @Test
    public void deveSubtrair() {
    Extrato extrato = new Extrato(new BigDecimal("1500"), new BigDecimal("600"), new BigDecimal("750"), new BigDecimal("250"));
    CalculadorDeClasses calculadora = new CalculadorDeClasses();
    BigDecimal subtrair = calculadora.subtrair(extrato);
    Assert.assertEquals(new BigDecimal("1000"), subtrair);
  }
    @Test
    public void deveTotalizar() {
        Extrato extrato = new Extrato(new BigDecimal("1500"), new BigDecimal("600"), new BigDecimal("750"), new BigDecimal("250"));
        CalculadorDeClasses calculadora = new CalculadorDeClasses();
        BigDecimal totalizar = calculadora.totalizar(extrato);
        Assert.assertEquals(new BigDecimal("1100"), totalizar);
    }
    @Test
    public void naoDeveCalcular(){
        ExtratoSemAnottation extrato = new ExtratoSemAnottation(new BigDecimal("1500"), new BigDecimal("600"), new BigDecimal("750"), new BigDecimal("250"));
        CalculadorDeClasses calculadora = new CalculadorDeClasses();
        BigDecimal totalizar = calculadora.totalizar(extrato);
        Assert.assertEquals(new BigDecimal("0"), totalizar);
    }
    @Test
    public void deveSubtrairNegativo(){
        Extrato extrato = new Extrato(new BigDecimal("1500"), new BigDecimal("600"), new BigDecimal("45"), new BigDecimal("-30"));
        CalculadorDeClasses calculadora = new CalculadorDeClasses();
        BigDecimal subtrair = calculadora.subtrair(extrato);
        Assert.assertEquals(new BigDecimal("15"), subtrair);
    }
}
