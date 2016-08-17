// Generated code from Butter Knife. Do not modify!
package com.plusmental.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class LoginEmailFragment$$ViewInjector<T extends com.plusmental.ui.LoginEmailFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689602, "field 'mEmailEdit'");
    target.mEmailEdit = finder.castView(view, 2131689602, "field 'mEmailEdit'");
    view = finder.findRequiredView(source, 2131689603, "field 'mPasswordEdit'");
    target.mPasswordEdit = finder.castView(view, 2131689603, "field 'mPasswordEdit'");
    view = finder.findRequiredView(source, 2131689604, "field 'mNextButton'");
    target.mNextButton = finder.castView(view, 2131689604, "field 'mNextButton'");
  }

  @Override public void reset(T target) {
    target.mEmailEdit = null;
    target.mPasswordEdit = null;
    target.mNextButton = null;
  }
}
