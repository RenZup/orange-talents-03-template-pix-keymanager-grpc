package br.com.pix.conexaoERP

import br.com.pix.enum.TipoConta
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Entity
class ChavePix(
    @Id
    @GeneratedValue
    val id: String,

    @Column(nullable = false)
    @field:NotBlank
    val agencia : String,
    @Column(nullable = false)
    @field:NotBlank
    val numero: String,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @field:NotBlank
    val tipoConta: TipoConta,
    @Column(nullable=false)
    @field:NotBlank
    val nomeInstituicao: String,
    @Column(nullable=false)
    @field:NotBlank
    val ispbInstituicao: String,
    @Column(nullable = false)
    @field:NotBlank
    val nomeCliente: String,
    @Column(nullable = false)
    @field:NotBlank
    val cpfCliente: String

) {

}
