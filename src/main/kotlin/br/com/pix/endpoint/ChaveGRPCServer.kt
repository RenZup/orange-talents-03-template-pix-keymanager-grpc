package br.com.pix.endpoint

import br.com.pix.CadastrarChaveRequest
import br.com.pix.CadastrarChaveResponse
import br.com.pix.PixCrudServiceGrpc
import br.com.pix.dto.CadastrarChaveRequestDto
import br.com.pix.enum.TipoChave
import br.com.pix.enum.TipoConta
import br.com.pix.services.CadastrarChaveService
import io.grpc.stub.StreamObserver
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChaveGRPCServer(@Inject private val cadastraService: CadastrarChaveService): PixCrudServiceGrpc.PixCrudServiceImplBase() {
    override fun create(request: CadastrarChaveRequest, responseObserver: StreamObserver<CadastrarChaveResponse>) {

        val dto = request.toDto()
        cadastraService.cadastrar(dto)

        responseObserver.onNext(CadastrarChaveResponse.newBuilder().setIdPixGerado(dto.valorChave).build())
        responseObserver.onCompleted()



    }
    fun CadastrarChaveRequest.toDto(): CadastrarChaveRequestDto{

        val localChave: String = if(tipoChave.name == TipoChave.CHAVE_ALEATORIA.toString()){
            UUID.randomUUID().toString()
        }else{
            valorChave
        }

        return CadastrarChaveRequestDto(idCliente = idCliente,
        tipoChave = TipoChave.valueOf(tipoChave.name),
        tipoConta = TipoConta.valueOf(tipoConta.name),
        valorChave = localChave)
    }


}