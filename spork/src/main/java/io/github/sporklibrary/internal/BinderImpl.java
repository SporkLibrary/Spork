package io.github.sporklibrary.internal;

import java.util.List;

import io.github.sporklibrary.interfaces.Binder;
import io.github.sporklibrary.annotations.Nullable;

public class BinderImpl implements Binder {
	private final BinderCache binderCache;

	public BinderImpl(BinderCache binderCache) {
		this.binderCache = binderCache;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void bind(Object object, @Nullable Object... modules) {
		Class<?> objectClass = object.getClass();

		while (objectClass != null && objectClass != Object.class) {
			List<Binder> binders = binderCache.getBinders(objectClass);
			bind(object, binders, modules);
			objectClass = objectClass.getSuperclass();
		}
	}

	/**
	 * Bind all annotations for an object instance for one specific class at a single level of inheritance.
	 *
	 * @param object  the instance to bind annotations for
	 * @param binders the list of cached binders
	 * @param modules either null or an array of non-null modules
	 */
	private void bind(Object object, List<Binder> binders, @Nullable Object[] modules) {
		for (Binder binder : binders) {
			binder.bind(object, modules);
		}
	}
}
