package com.example.sys.school.domain;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ALUNO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ALUNO")
    private Long COD_ALUNO;

    @Column(name = "NOME_ALUNO", nullable = false, length = 100)
    private String NOME_ALUNO;

    @Column(name = "DES_EMAIL", nullable = false)
    private String DES_EMAIL;

    @ManyToMany
    @JoinTable(name = "TB_ALUNOS_CURSANDO", 
        joinColumns = { @JoinColumn(name = "COD_ALUNO") }, 
        inverseJoinColumns = { @JoinColumn(name = "COD_DISCIPLINA") })
    private List<Disciplina> disciplinasEmCurso;
}
