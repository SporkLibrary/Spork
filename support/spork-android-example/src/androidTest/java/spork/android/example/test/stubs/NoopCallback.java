package spork.android.example.test.stubs;

import spork.android.example.concurrent.Callback;

/**
 * A callback that does nothing.
 * @param <T> the callback success type
 */
public class NoopCallback<T> implements Callback<T> {
	@Override
	public void onSuccess(T object) {
	}

	@Override
	public void onFailure(Exception caught) {
	}
}
