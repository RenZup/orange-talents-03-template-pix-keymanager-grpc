package br.com.pix.services

import br.com.pix.conexaoERP.ChavePix
import br.com.pix.conexaoERP.ContaResponse
import br.com.pix.conexaoERP.ErpClient
import br.com.pix.dto.CadastrarChaveRequestDto
import br.com.pix.repository.ChavePixRepository
import io.micronaut.http.HttpStatus
import io.micronaut.validation.Validated
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Singleton
import javax.validation.Valid

@Singleton
@Validated
class CadastrarChaveService(
    @Inject private val cliente: ErpClient,
    @Inject private val repository: ChavePixRepository
) {

    fun cadastrar(@Valid dto: CadastrarChaveRequestDto) {
        //verificar se a chave ja existe no banco
        if(repository.existsByValorChave(dto.valorChave)){
            throw IllegalArgumentException("Ja existe uma chave com esse valor")
        }

        val response = cliente.consulta(dto.idCliente, dto.tipoConta.name)
        val conta = response.body()?.toConta() ?: throw IllegalStateException("Cliente nao encontrado no Itau")
        val chavePix = ChavePix(tipoChave = dto.tipoChave, valorChave = dto.valorChave, conta = conta)

        println(response)
        println(chavePix)

        //Persistir a chave criada no banco
        repository.save(chavePix)

    }

}