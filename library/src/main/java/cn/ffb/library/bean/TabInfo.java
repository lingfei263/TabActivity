package cn.ffb.library.bean;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class TabInfo {
  public Class<? extends Fragment> clss;
  public Fragment fragment;
  public String title;
  public Bundle bundle;

  public TabInfo(String title, Class<? extends Fragment> clss) {
    super();
    this.clss = clss;
    this.title = title;
  }

  public TabInfo(String title, Class<? extends Fragment> clss, Bundle bundle) {
    super();
    this.clss = clss;
    this.title = title;
    this.bundle = bundle;
  }


}
