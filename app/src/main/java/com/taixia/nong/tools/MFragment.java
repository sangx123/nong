package com.taixia.nong.tools;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.taixia.nong.app.BaseConfig;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/7
 * Description: Fragment工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/7         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class MFragment extends BaseConfig {
    /**
     * @param fragmentTransaction
     * @param currentFragment
     * @param fragment
     * @param fragmentTag
     * @param layout
     */
    private void changeFrament(FragmentTransaction fragmentTransaction, Fragment currentFragment, Fragment fragment, String fragmentTag, int layout) {
        if (fragment == currentFragment) {
            return;
        }
        if (!fragment.isAdded()) {
            fragmentTransaction.hide(currentFragment).add(layout, fragment, fragmentTag).commit();
        } else {
            fragmentTransaction.hide(currentFragment).show(fragment).commit();
        }
        currentFragment = fragment;
    }
}
