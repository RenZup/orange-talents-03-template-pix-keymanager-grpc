package br.com.pix
import br.com.pix.conexaoERP.ErpClient
import br.com.pix.endpoint.CadastraChaveEndpoint
import br.com.pix.model.ChavePix
import br.com.pix.model.Cliente
import br.com.pix.model.Conta
import br.com.pix.model.Instituicao
import br.com.pix.repository.ChavePixRepository
import io.micronaut.context.annotation.Factory
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest(transactional = false)
internal class KeyManagerGrpcTest(
    val repository: ChavePixRepository,
    val cadastraChaveEndpoint: CadastraChaveEndpoint
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
        val idCliente = "5260263c-a3c1-4727-ae32-3bdb2538841b"
        val chave = ChavePix(
            tipoChave = br.com.pix.enum.TipoChave.EMAIL,
            valorChave = "renzo.piedade@zup.com.br",conta = Conta(
                    agencia = "0001",
                    numero = "291900",
                    instituicao = Instituicao(nome = "ITAÚ UNIBANCO S.A.",ispb = "60701190"),
                    titular = Cliente(idCliente,"Yuri Matheus","86135457004"),
                    tipoConta = br.com.pix.enum.TipoConta.CONTA_CORRENTE
            )
        )


    }

    @MockBean(ErpClient::class)
    fun erpItauClient(): ErpClient?{
        return Mockito.mock(ErpClient::class.java)
    }

    @Factory
    class Clients{

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
