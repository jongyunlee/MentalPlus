// Generated code from Butter Knife. Do not modify!
package com.plusmental.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HomeFragment$$ViewInjector<T extends com.plusmental.ui.HomeFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689600, "field 'mLoginButton'");
    target.mLoginButton = finder.castView(view, 2131689600, "field 'mLoginButton'");
  }

  @Override public void reset(T target) {
    target.mLoginButton = null;
  }
}
