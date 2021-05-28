package br.com.pix.externo.bcb

import br.com.pix.externo.bcb.enums.OwnerType
import br.com.pix.externo.bcb.enums.TipoContaRequestBcb
import br.com.pix.model.ChavePix
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CadastrarChaveBcbRequest(
    @field:NotBlank val keyType:String,
    @field:NotBlank val key: String,
    @field:NotNull @Valid val bankAccount: BankAccount,
    @field:NotNull @Valid val owner: Owner,
) {
companion object{
    fun builder(
        chave: ChavePix,
        tipoContaBcb: TipoContaRequestBcb,
        tipoOwner: OwnerType
    ): CadastrarChaveBcbRequest {
        return with(chave) {
            return@with CadastrarChaveBcbRequest(
                keyType = tipoChave.name,
                key = valorChave,
                bankAccount = BankAccount(
                    participant = conta.instituicao.ispb,
                    branch = conta.agencia,
                    accountNumber = conta.numero,
                    accountType = tipoContaBcb,
                ),
                owner = with(conta.titular) {
                    return@with Owner(
                        type = tipoOwner,
                        name = nome,
                        taxIdNumber = cpf
                    )
                }
            )
        }
    }
}

}
data class Owner(
    @field:Enumerated(EnumType.STRING) val type: OwnerType,
   @field:NotBlank val name:String,
   @field:NotBlank val taxIdNumber:String
)

data class BankAccount(
    @field:NotBlank val participant:String,
    @field:NotBlank val branch:String,
    @field:NotBlank val accountNumber:String,
    @field:Enumerated(EnumType.STRING)val accountType: TipoContaRequestBcb,
)

