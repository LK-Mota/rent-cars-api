package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;

import java.util.Date;

public record AluguelResponse(Date datainicio, Date datafim, double valor, Cliente cliente, Carro carro) {}
