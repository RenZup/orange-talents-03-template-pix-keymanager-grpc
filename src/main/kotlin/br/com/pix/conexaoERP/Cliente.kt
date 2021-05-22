package br.com.pix.conexaoERP

import javax.persistence.Embeddable
import javax.validation.constraints.NotBlank

@Embeddable
 class Cliente (
    @field:NotBlank
    val id: String,
    @field:NotBlank
    val nome: String,
    @field:NotBlank
    val cpf: String
        ){
    override fun toString(): String {
        return "Cliente(id='$id', nome='$nome', cpf='$cpf')"
    }
}
