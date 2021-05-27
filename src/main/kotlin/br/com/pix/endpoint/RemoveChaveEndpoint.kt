package br.com.pix.endpoint

import br.com.pix.PixRemoveServiceGrpc
import br.com.pix.RemoveChaveRequest
import br.com.pix.RemoveChaveResponse
import br.com.pix.compartilhado.HandleExceptions
import br.com.pix.exception.ObjetoNaoEncontradoException
import br.com.pix.services.RemoveChaveService
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.grpc.stub.StreamObserver
import javax.inject.Inject
import javax.inject.Singleton

@HandleExceptions
@Singleton
class RemoveChaveEndpoint(@Inject private val service: RemoveChaveService): PixRemoveServiceGrpc.PixRemoveServiceImplBase() {
    override fun remove(request: RemoveChaveRequest, responseObserver: StreamObserver<RemoveChaveResponse>) {

        try {
            service.remove(idCliente = request.idCliente, valorChave = request.valorChave)
        }catch (e:ObjetoNaoEncontradoException){
            responseObserver.onError(StatusRuntimeException(Status.NOT_FOUND.withDescription(e.message)))
        }
        responseObserver.onNext(RemoveChaveResponse.newBuilder()
                                .setIdCliente(request.idCliente)
                                .setValorChave((request.valorChave)).build())

        responseObserver.onCompleted()


    }
}