// Generated code from Butter Knife. Do not modify!
package com.plusmental.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SignupFragment$$ViewInjector<T extends com.plusmental.ui.SignupFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689606, "field 'rootView'");
    target.rootView = finder.castView(view, 2131689606, "field 'rootView'");
    view = finder.findRequiredView(source, 2131689610, "field 'mCancelButton'");
    target.mCancelButton = finder.castView(view, 2131689610, "field 'mCancelButton'");
    view = finder.findRequiredView(source, 2131689611, "field 'mSignupButton'");
    target.mSignupButton = finder.castView(view, 2131689611, "field 'mSignupButton'");
    view = finder.findRequiredView(source, 2131689620, "field 'mNameEdit'");
    target.mNameEdit = finder.castView(view, 2131689620, "field 'mNameEdit'");
    view = finder.findRequiredView(source, 2131689608, "field 'mEmailEdit'");
    target.mEmailEdit = finder.castView(view, 2131689608, "field 'mEmailEdit'");
    view = finder.findRequiredView(source, 2131689609, "field 'mPasswordEdit'");
    target.mPasswordEdit = finder.castView(view, 2131689609, "field 'mPasswordEdit'");
  }

  @Override public void reset(T target) {
    target.rootView = null;
    target.mCancelButton = null;
    target.mSignupButton = null;
    target.mNameEdit = null;
    target.mEmailEdit = null;
    target.mPasswordEdit = null;
  }
}
