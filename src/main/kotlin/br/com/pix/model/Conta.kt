package br.com.pix.model

import br.com.pix.enum.TipoConta
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Embeddable
class Conta (

    @field:NotBlank
    val agencia : String,
    @field:NotBlank
    val numero: String,
    @field:NotNull
    @Embedded
    @AttributeOverride(name = "nome", column = Column(name = "nome_Instituicao"))
    val instituicao:Instituicao,
    @Embedded
    @AttributeOverride(name="id", column = Column(name = "id_Cliente"))
    val titular: Cliente,
    @Enumerated(EnumType.STRING)
    @field:NotBlank
    val tipoConta: TipoConta


){
    override fun toString(): String {
        return "Conta(agencia='$agencia', numero='$numero', instituicao =$instituicao, titular=$titular, tipoConta=$tipoConta)"
    }
}