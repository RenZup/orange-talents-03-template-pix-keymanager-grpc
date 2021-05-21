package br.com.pix.conexaoERP

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client(value = "http://localhost:9091")
interface ErpClient {
    @Get("/api/v1/clientes/{clienteId}/contas{?tipo}")
    fun consulta(@PathVariable clienteId:String, @QueryValue tipo: String): HttpResponse<ClienteResponse>

}