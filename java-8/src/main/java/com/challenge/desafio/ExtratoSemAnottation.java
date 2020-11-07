package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class ExtratoSemAnottation {

    private BigDecimal salario;

    private BigDecimal bonus;

    private  BigDecimal boletoAluguel;
    private BigDecimal contaDeEnergia;

    public ExtratoSemAnottation(BigDecimal salario, BigDecimal bonus, BigDecimal boletoAluguel, BigDecimal contaDeEnergia) {
        this.salario = salario;
        this.bonus = bonus;
        this.boletoAluguel = boletoAluguel;
        this.contaDeEnergia = contaDeEnergia;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public BigDecimal getBoletoAluguel() {
        return boletoAluguel;
    }

    public BigDecimal getContaDeEnergia() {
        return contaDeEnergia;
    }
}
