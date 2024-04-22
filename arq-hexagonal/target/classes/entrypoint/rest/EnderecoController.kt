package org.example.entrypoint.rest

import org.example.core.ports.EntryPointPort
import org.example.entrypoint.rest.dto.EnderecoResponse
import org.example.entrypoint.rest.mapper.enderecoCoreToEnderecoResponse

@Controller("/endereco")
class controller(
    val entryPointPort: EntryPointPort

) {
    @Get("/{enderecoId}")
    fun getEndereco(@PathVariable enderecoId: String): EnderecoResponse {
        val enderecoCore = entryPointPort.getAll(enderecoId)
        return enderecoCoreToEnderecoResponse(enderecoCore)
    }

    @Post("/")
    fun createEndereco(@Body enderecoRequest: EnderecoRequest): HttpResponse<EnderecoResponse> {
        // Lógica para criar um novo endereço com base nos dados recebidos no corpo da requisição
        val enderecoCore = entryPointPort.createEndereco(enderecoRequest)
        val enderecoResponse = enderecoCoreToEnderecoResponse(enderecoCore)
        return HttpResponse.created(enderecoResponse)
    }

    @Put("/{cep}")
    fun updateEndereco(@PathVariable cep: String, @Body enderecoRequest: EnderecoRequest): HttpResponse<EnderecoResponse> {
        // Lógica para atualizar o endereço com base no CEP e nos dados recebidos no corpo da requisição
        val enderecoCore = entryPointPort.updateEndereco(cep, enderecoRequest)
        val enderecoResponse = enderecoCoreToEnderecoResponse(enderecoCore)
        return HttpResponse.ok(enderecoResponse)
    }

    @Delete("/{cep}")
    fun deleteEndereco(@PathVariable cep: String): HttpResponse<Unit> {
        // Lógica para excluir o endereço com base no CEP
        entryPointPort.deleteEndereco(cep)
        return HttpResponse.noContent()
    }
}