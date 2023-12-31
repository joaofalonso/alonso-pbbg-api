package br.com.griomirium.api.domain.core;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CoreRecord(
        @NotBlank
        String name,
        UserData userData,

        @NotNull
        int gold,

        @NotNull
        int food,
        @NotNull
        CoreElementType coreElementType) {
}
