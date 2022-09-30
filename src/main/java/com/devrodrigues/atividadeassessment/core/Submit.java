package com.devrodrigues.atividadeassessment.core;

import java.time.Instant;

public record Submit(
        Long id,
        Long alunoId,
        Long atividadeId,
        String resposta,
        Instant createdAt
) {
}
