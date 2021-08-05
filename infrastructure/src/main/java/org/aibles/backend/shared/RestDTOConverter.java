package org.aibles.backend.shared;

import java.io.Serializable;

public interface RestDTOConverter<R, E extends Serializable>{

    default E mapToEntity(final R reqDTO){
        throw new UnsupportedOperationException();
    }

    default R mapToDTO(final E entity){
        throw new UnsupportedOperationException();
    }
}
