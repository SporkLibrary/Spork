package io.github.sporklibrary.caching;

import java.lang.annotation.Annotation;
import java.util.Set;

import io.github.sporklibrary.annotations.Nullable;
import io.github.sporklibrary.binders.MethodBinder;
import io.github.sporklibrary.interfaces.ObjectBinder;
import io.github.sporklibrary.reflection.AnnotatedMethod;

/**
 * A binder that caches method bindings for a specific class.
 *
 * @param <AnnotationType> the annotation type that is being bound
 */
class AnnotatedMethodBinder<AnnotationType extends Annotation> implements ObjectBinder {
    private final Set<AnnotatedMethod<AnnotationType>> annotatedMethods;
    private final MethodBinder<AnnotationType> methodBinder;

    AnnotatedMethodBinder(MethodBinder<AnnotationType> methodBinder, Set<AnnotatedMethod<AnnotationType>> annotatedMethods) {
        this.methodBinder = methodBinder;
        this.annotatedMethods = annotatedMethods;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bind(Object object, @Nullable Object[] modules) {
        // Bind all methods for this object
        for (AnnotatedMethod<AnnotationType> annotatedMethod : annotatedMethods) {
            methodBinder.bind(object, annotatedMethod, modules);
        }
    }
}
