// Generated code from Butter Knife. Do not modify!
package com.plusmental.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HomeFragment$$ViewInjector<T extends com.plusmental.ui.HomeFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689599, "field 'mNameView'");
    target.mNameView = finder.castView(view, 2131689599, "field 'mNameView'");
    view = finder.findRequiredView(source, 2131689600, "field 'mEmailView'");
    target.mEmailView = finder.castView(view, 2131689600, "field 'mEmailView'");
    view = finder.findRequiredView(source, 2131689601, "field 'mHeartsCountView'");
    target.mHeartsCountView = finder.castView(view, 2131689601, "field 'mHeartsCountView'");
    view = finder.findRequiredView(source, 2131689602, "field 'mLevelView'");
    target.mLevelView = finder.castView(view, 2131689602, "field 'mLevelView'");
    view = finder.findRequiredView(source, 2131689603, "field 'mTotalXpView'");
    target.mTotalXpView = finder.castView(view, 2131689603, "field 'mTotalXpView'");
    view = finder.findRequiredView(source, 2131689604, "field 'mCurrentXpView'");
    target.mCurrentXpView = finder.castView(view, 2131689604, "field 'mCurrentXpView'");
    view = finder.findRequiredView(source, 2131689605, "field 'mStartButton'");
    target.mStartButton = finder.castView(view, 2131689605, "field 'mStartButton'");
  }

  @Override public void reset(T target) {
    target.mNameView = null;
    target.mEmailView = null;
    target.mHeartsCountView = null;
    target.mLevelView = null;
    target.mTotalXpView = null;
    target.mCurrentXpView = null;
    target.mStartButton = null;
  }
}
