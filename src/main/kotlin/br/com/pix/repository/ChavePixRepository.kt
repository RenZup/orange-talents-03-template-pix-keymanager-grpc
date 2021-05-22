package br.com.pix.repository

import br.com.pix.conexaoERP.ChavePix
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ChavePixRepository: CrudRepository<ChavePix,Long>{
}