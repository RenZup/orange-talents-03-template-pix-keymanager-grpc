package br.com.pix
import br.com.pix.conexaoERP.ContaResponse
import br.com.pix.conexaoERP.ErpClient
import br.com.pix.endpoint.ChaveGRPCServer
import br.com.pix.model.ChavePix
import br.com.pix.model.Conta
import br.com.pix.repository.ChavePixRepository
import io.micronaut.data.annotation.Repository
import io.micronaut.http.HttpResponse
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*
import javax.inject.Inject
import org.mockito.Mockito.`when`

@MicronautTest
internal class KeyManagerGrpcTest(
    val repository: ChavePixRepository,
    val chaveGRPCServer: ChaveGRPCServer
) {

    @Inject
    lateinit var application: EmbeddedApplication<*>
    @Inject
    lateinit var clientItau: ErpClient

    @AfterEach
    fun cleanUp(){
        repository.deleteAll()
    }

   /* @BeforeEach
    fun setup(){
        repository.save(buildChave(tipoChave = TipoChave.EMAIL,
        chave = "renzo.piedade@zup.com.br",
        idCliente = UUID.randomUUID()))
    }*/



    @Test
    fun `deve registrar nova chave pix`() {
        /*val chave = ChavePix(tipoChave = br.com.pix.enum.TipoChave.EMAIL,
        valorChave = "renzo.piedade@zup.com.br",conta = Conta(
                agencia = "001",
                numero = "213216489",

        ))*/

        `when`(
            clientItau.consulta(clienteId = UUID.randomUUID().toString(),
            tipo = TipoConta.CONTA_CORRENTE.toString()
            )
        ).thenReturn(HttpResponse.ok())

    }

    @MockBean(ErpClient::class)
    fun erpItauClient(): ErpClient?{
        return Mockito.mock(ErpClient::class.java)
    }

   /* internal fun buildChave(
        tipoChave: TipoChave,
        chave: String = UUID.randomUUID().toString(),
        idCliente: UUID = UUID.randomUUID()
    ): ChavePix {
        return ChavePix(
        tipoChave = tipochave,valorChave = chave,Conta(

        )
        )
    }*/
}
