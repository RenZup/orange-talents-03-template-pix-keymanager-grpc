package br.com.pix.model

import br.com.pix.enum.TipoConta
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Embeddable
class Conta (

    @field:NotBlank
    val agencia : String,
    @field:NotBlank
    val numero: String,
    @field:NotBlank
    val nomeInstituicao: String,
    @field:NotBlank
    val ispbInstituicao: String,
    @Embedded
    @AttributeOverride(name="id",column = Column(name = "id_Cliente"))
    val titular: Cliente,
    @Enumerated(EnumType.STRING)
    @field:NotBlank
    val tipoConta: TipoConta


){
    override fun toString(): String {
        return "Conta(agencia='$agencia', numero='$numero', nomeInstituicao='$nomeInstituicao', ispbInstituicao='$ispbInstituicao', titular=$titular, tipoConta=$tipoConta)"
    }
}