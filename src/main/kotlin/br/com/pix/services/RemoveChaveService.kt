package br.com.pix.services

import br.com.pix.exception.ObjetoNaoEncontradoException
import br.com.pix.externo.bcb.BcbClient
import br.com.pix.externo.bcb.DeletarChaveBcbRequest
import br.com.pix.repository.ChavePixRepository
import io.micronaut.http.HttpStatus
import io.micronaut.validation.Validated
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import javax.validation.constraints.NotBlank

@Validated
@Singleton
class RemoveChaveService(@Inject private val repository: ChavePixRepository,
                         @Inject private val bcbClient: BcbClient) {


    @Transactional
    fun remove(@NotBlank idCliente: String, @NotBlank valorChave: String) {
        val chave = repository.findByValorChaveAndContaTitularId(idCliente = idCliente, valorChave = valorChave)
            ?: throw ObjetoNaoEncontradoException("Chave Pix nao existe ou nao pertence ao cliente")

            val bcbRequest = DeletarChaveBcbRequest(key= chave.valorChave, participant = chave.conta.instituicao.ispb)
            repository.deleteByValorChave(valorChave)
        // deletar do bcb

        val httpResponse = bcbClient.deletar(bcbRequest, chave.valorChave)
        if(httpResponse.status != HttpStatus.OK) throw IllegalStateException("Erro ao remover chave Pix do BCB")
    }

}
