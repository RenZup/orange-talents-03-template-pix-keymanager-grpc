package br.com.pix.conexaoERP

import javax.validation.constraints.NotBlank

data class Cliente (
    @NotBlank
    val id: String,
    @NotBlank
    val nome: String,
    @NotBlank
    val cpf: String
        ){

}
