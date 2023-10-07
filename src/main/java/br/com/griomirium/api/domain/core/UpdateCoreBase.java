package br.com.griomirium.api.domain.core;

public record UpdateCoreBase(Long id, String name, CoreElementType coreElementType, int gold, int food, int units, int buildings) {
}
