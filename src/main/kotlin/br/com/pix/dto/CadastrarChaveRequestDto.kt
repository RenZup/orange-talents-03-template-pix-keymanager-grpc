package br.com.pix.dto

import br.com.pix.enum.TipoChave
import br.com.pix.enum.TipoConta
import br.com.pix.validators.ChavePix
import io.micronaut.core.annotation.Introspected
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Introspected
@ChavePix
data class CadastrarChaveRequestDto (

    @field:NotBlank
    val idCliente : String,
    val valorChave: String,
    @field:Valid
    val tipoChave : TipoChave,
    val tipoConta: TipoConta
){


}