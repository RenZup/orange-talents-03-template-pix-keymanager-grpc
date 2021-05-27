package br.com.pix.model

import javax.persistence.Embeddable
import javax.validation.constraints.NotBlank

data class Instituicao(

    @field:NotBlank
    val nome: String,
    @field:NotBlank
    val ispb: String

)