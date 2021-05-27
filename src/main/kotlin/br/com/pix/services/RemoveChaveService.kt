package br.com.pix.services

import br.com.pix.exception.ObjetoNaoEncontradoException
import br.com.pix.repository.ChavePixRepository
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import javax.validation.constraints.NotBlank

@Validated
@Singleton
class RemoveChaveService(@Inject val repository: ChavePixRepository) {
    @Transactional
    fun remove(@NotBlank idCliente: String, @NotBlank valorChave: String) {
        val chave = repository.findByValorChaveAndContaTitularId(idCliente = idCliente, valorChave = valorChave)
            ?: throw ObjetoNaoEncontradoException("Chave Pix nao existe ou nao pertence ao cliente")
            repository.deleteByValorChave(valorChave)
    }

}
