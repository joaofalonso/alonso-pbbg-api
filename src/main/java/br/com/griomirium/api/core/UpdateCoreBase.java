package br.com.griomirium.api.core;

import br.com.griomirium.api.core.CoreElementType;

public record UpdateCoreBase(Long id, String name, CoreElementType coreElementType) {
}
