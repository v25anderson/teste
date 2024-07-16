package br.com.javamagazine.clinicajm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 10, max = 255)
    @Column(name = "sintomas", nullable = false, length = 255)
    private String sintomas;

    @Column(name = "receita",length = 255)
    private String receita;

    @Column(name="data_consulta")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate data_consulta;

    @Column(name="data_atendimento")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate data_atendimento;

    @Column(name="avaliacao_atendimento")
    private Double avaliacao_atendimento;



    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
