package spork.inject.internal.providers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Provider;

public class LazyProvider<T> implements Provider<T> {
	@Nullable
	private Provider<T> provider;
	private T cachedInstance;

	public LazyProvider(@Nonnull Provider<T> provider) {
		this.provider = provider;
	}

	@Override
	public T get() {
		if (provider != null) {
			cachedInstance = provider.get();
			provider = null;
		}

		return cachedInstance;
	}
}

