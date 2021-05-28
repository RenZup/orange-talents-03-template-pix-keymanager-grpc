package br.com.pix.repository

import br.com.pix.model.ChavePix
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ChavePixRepository: JpaRepository<ChavePix,Long>{
    fun existsByContaTitularId(idCliente: String):Boolean
    fun existsByValorChave(valorChave: String):Boolean
    fun findByValorChaveAndContaTitularId(valorChave: String,idCliente: String): ChavePix?
    fun deleteByValorChave(valorChave: String): Unit
}