package br.com.pix.services

import br.com.pix.conexaoERP.ChavePix
import br.com.pix.conexaoERP.ErpClient
import br.com.pix.dto.CadastrarChaveRequestDto
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.inject.Singleton
import javax.validation.Valid

@Singleton
@Validated
class CadastrarChaveService(@Inject private val cliente: ErpClient) {

    fun cadastrar(@Valid dto: CadastrarChaveRequestDto){
        //verificar se o id do cliente existe no sistema ERP do Itau
        val response = cliente.consulta(dto.idCliente,dto.tipoConta.name).body()
        val chavePix: ChavePix = response.toChavePix()

        //if(!repository.existsById_Cliente(dto.idCliente))

        println(response)
        println(chavePix)

        //Retornar NOT FOUND caso nao existe
        //Se o meu cliente existe, devo cadastrar uma nova chave pix
        //Persistir a chave criada no bacno
    }

}