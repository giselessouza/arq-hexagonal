package org.example.entrypoint.rest.mapper

import org.example.core.model.EnderecoCore
import org.example.entrypoint.rest.dto.EnderecoResponse

fun enderecoCoreToEnderecoResponse(enderecoCore: EnderecoCore) : EnderecoResponse {
    return EnderecoResponse(
        nome = enderecoCore.nomeCliente,
        logradouro = enderecoCore.logradouro
    )
}