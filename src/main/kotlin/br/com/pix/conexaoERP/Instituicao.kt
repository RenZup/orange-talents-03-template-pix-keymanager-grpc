package br.com.pix.conexaoERP

import javax.validation.constraints.NotBlank

data class Instituicao(

    @field:NotBlank
    val nome: String,
    @field:NotBlank
    val ispb: String

)