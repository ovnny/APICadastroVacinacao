package com.ovnny.cadastrovacinacaozup.model.entities;

import com.ovnny.cadastrovacinacaozup.model.enums.VacinaTipo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "cadastro_vacinacao")
public class CadastroVacinacaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long cadastroID;

    @Column(unique = true)
    @JoinColumn(name = "email")
    UUID userID;

    @Column(nullable = false)
    String vacina;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    LocalDateTime dataVacinacao;

    public CadastroVacinacaoUsuario(String email) {
        this.email = email;
    }

    private UUID getUserID() {
        return userID;
    }

    private UUID setUserID(String email) {
        return userID = UUID.fromString(getEmail());
    }

    final String getVacina() {
        return vacina;
    }

    final VacinaTipo setVacina() {
        List<VacinaTipo> vacinas = Arrays.asList(VacinaTipo.values());
        Random rand = new Random();

        return vacinas.get(rand.nextInt(vacinas.size()));
    }

    private String getEmail() {
        return email;
    }

    private LocalDateTime getDataVacinacao() {
        return dataVacinacao;
    }

    private LocalDateTime setDataVacinacao() {
        return LocalDateTime.now();
    }
}
