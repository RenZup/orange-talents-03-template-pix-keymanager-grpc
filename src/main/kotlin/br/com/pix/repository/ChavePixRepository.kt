package br.com.pix.repository

import br.com.pix.model.ChavePix
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ChavePixRepository: CrudRepository<ChavePix,Long>{
    fun existsByContaTitularId(idCliente: String):Boolean
    fun existsByValorChave(valorChave: String):Boolean
}