package br.com.fintech.projeto.emprestimo.DTOs.DTOsEntrada;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

public record DadosSalvarCliente(
        @NotBlank
        String nome,
        @NotBlank
        String documento,
        @NotBlank
        String celular,
        @Min(0)
        @Max(1000)
        Long score,

        boolean negativado


) {
}
