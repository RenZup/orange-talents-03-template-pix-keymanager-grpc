package br.com.pix.services

import br.com.pix.externo.erpItau.ErpClient
import br.com.pix.dto.CadastrarChaveRequestDto
import br.com.pix.enum.TipoChave
import br.com.pix.exception.ChaveDuplicadaException
import br.com.pix.exception.ObjetoNaoEncontradoException
import br.com.pix.externo.bcb.CadastrarChaveBcbRequest
import br.com.pix.externo.bcb.enums.OwnerType
import br.com.pix.externo.bcb.enums.TipoContaRequestBcb
import br.com.pix.externo.bcb.BcbClient
import br.com.pix.model.ChavePix
import br.com.pix.repository.ChavePixRepository
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import javax.validation.Valid

@Singleton
@Validated
class CadastrarChaveService(
    @Inject private val ErpClient: ErpClient,
    @Inject private val repository: ChavePixRepository,
    @Inject private val bcbClient: BcbClient
) {
    @Transactional
    fun cadastrar(@Valid dto: CadastrarChaveRequestDto): ChavePix {
        //verificar se a chave ja existe no banco
        if(repository.existsByValorChave(dto.valorChave)) throw ChaveDuplicadaException()

        val response = ErpClient.consulta(dto.idCliente, dto.tipoConta.name)

        val conta = response.body()?.toConta() ?: throw ObjetoNaoEncontradoException("Conta nao encontrada")
        val chavePix = ChavePix(tipoChave = dto.tipoChave, valorChave = dto.valorChave, conta = conta)

        //Cadastrar no BCB
        val bcbRequest = CadastrarChaveBcbRequest.builder(chavePix, TipoContaRequestBcb.CACC, OwnerType.NATURAL_PERSON)
        val responseCadastro = bcbClient.cadastrar(bcbRequest)

        //Verificar se a chave é randomica e persistir no banco
        if(chavePix.tipoChave == TipoChave.RANDOM){
            val novaChavePixRandomica: ChavePix = ChavePix(chavePix.tipoChave,responseCadastro.body()!!.key,chavePix.conta)
            repository.save(novaChavePixRandomica)
            return novaChavePixRandomica
        }else{
            repository.save(chavePix)
            return chavePix
        }





    }

}