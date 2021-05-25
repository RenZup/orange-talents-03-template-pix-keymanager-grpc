package br.com.pix.conexaoERP

import br.com.pix.enum.TipoChave
import br.com.pix.enum.TipoConta
import java.util.*

data class ContaResponse (
  val tipo: String,
  val titular: Cliente,
  val instituicao: Instituicao,
  val agencia: String,
  val numero: String,


        ){

  fun toConta(): Conta{

      return Conta(agencia,numero,instituicao.nome,instituicao.ispb,titular,TipoConta.valueOf(tipo))
  }

}

/*{
  "tipo": "CONTA_CORRENTE",
  "instituicao": {
    "nome": "ITAÚ UNIBANCO S.A.",
    "ispb": "60701190"
  },
  "agencia": "0001",
  "numero": "291900",
  "titular": {
    "id": "c56dfef4-7901-44fb-84e2-a2cefb157890",
    "nome": "Rafael M C Ponte",
    "cpf": "02467781054"
  }
}*/
