package com.sim.javamodule.common.util;


import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class OptionalUtils {
    private OptionalUtils() {
    }

    public static <T, R> R findEntityOrElseThrow(Function<T, Optional<R>> findMethod, T specificationData, Supplier<? extends RuntimeException> exceptionSupplier) {
        return findMethod.apply(specificationData)
            .orElseThrow(exceptionSupplier);
    }
}
