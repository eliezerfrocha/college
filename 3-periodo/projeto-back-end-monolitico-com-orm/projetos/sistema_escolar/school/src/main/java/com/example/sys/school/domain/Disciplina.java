package com.example.sys.school.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_DISCIPLINA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DISCIPLINA")
    private Long COD_DISCIPLINA;
    
    @Column(name = "NOM_DISCIPLINA", nullable = false, length = 100)
    private String NOM_DISCIPLINA;

    @Column(name = "NUM_HORAS", nullable = false)
    private Integer NUM_HORAS;

    @JsonBackReference
    @ManyToMany(mappedBy = "disciplinasEmCurso")
    private List<Aluno> alunos;
}