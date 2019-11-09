package br.senac.tads.dsw.usuariocrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String username;

	@Column
	private String nomeCompleto;

	@Column
	private String senha;

	@Column
	private boolean ativado;

	@Column
	private LocalDateTime dataHoraCadastro;

	@JoinTable(name = "USUARIO_PAPEL",
			joinColumns = {@JoinColumn (name = "ID_USUARIO")},
			inverseJoinColumns = @JoinColumn (name = "ID_PAPEL"))
	@OneToMany
	private Set<Papel> papeis;

}
