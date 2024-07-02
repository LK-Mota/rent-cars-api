package br.gov.sp.fatec.domain.entity;

import br.gov.sp.fatec.domain.enums.AluguelStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue
    private Long id;
    private Date datainicio;
    private Date datafim;
    private double valor;

    @Enumerated(value = EnumType.STRING)
    private AluguelStatus status;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Carro carro;

    public Aluguel(Long id, Date datainicio, Date datafim, double valor, AluguelStatus status, Cliente cliente, Carro carro) {
        this.id = id;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.valor = valor;
        this.status = status;
        this.cliente = cliente;
        this.carro = carro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public AluguelStatus getStatus() {
        return status;
    }

    public void setStatus(AluguelStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }



}
