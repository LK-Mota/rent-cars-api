package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;

import java.util.Date;

public record AluguelRequest(Date datainicio, Date datafim, double valor, Cliente cliente, Carro carro) {}
