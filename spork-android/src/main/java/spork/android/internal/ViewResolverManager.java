package spork.android.internal;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import spork.android.interfaces.Registry;
import spork.android.interfaces.ViewResolver;

/**
 * The main {@link ViewResolver} implementation that holds child {@link ViewResolver} instances
 * and uses them one by one to resolve a {@link View}.
 */
public final class ViewResolverManager implements ViewResolver, Registry<ViewResolver> {
	private final List<ViewResolver> viewResolvers = new ArrayList<>(2);

	@Override
	public void register(ViewResolver viewResolver) {
		viewResolvers.add(viewResolver);
	}

	@Override
	@Nullable
	public View resolveView(Object object) {
		for (ViewResolver viewResolver : viewResolvers) {
			View view = viewResolver.resolveView(object);

			if (view != null) {
				return view;
			}
		}

		return null;
	}
}