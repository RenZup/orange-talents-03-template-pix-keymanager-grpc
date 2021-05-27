package br.com.pix.dto

import br.com.pix.enum.TipoChave
import br.com.pix.enum.TipoConta
import br.com.pix.validators.ChavePixValida
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
@ChavePixValida
data class CadastrarChaveRequestDto (

    @field:NotBlank
    val idCliente : String,
    val valorChave: String,
    val tipoChave : TipoChave,
    val tipoConta: TipoConta
){


}