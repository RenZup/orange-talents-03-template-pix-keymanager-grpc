package br.com.pix.externo.bcb

import br.com.pix.model.ChavePix
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client
import java.awt.PageAttributes
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Client(value = "http://localhost:8082")
interface BcbClient {
    @Post("/api/v1/pix/keys")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    fun cadastrar(@Body request :CadastrarChaveBcbRequest): HttpResponse<CadastrarChaveBcbRequest>

    @Delete("/api/v1/pix/keys/{key}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    fun deletar(@Body request: DeletarChaveBcbRequest, @PathVariable key: String) : HttpResponse<DeletarChaveBcbResponse>



}


