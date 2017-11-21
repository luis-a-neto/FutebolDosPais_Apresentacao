package br.com.futeboldospais.futeboldospais.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.controller.QuartasFinaisFragmentSenior;

/**
 * Created by Pamela Fidels on 11/11/17.
 */

public class QuartasFinaisSeniorAdapter extends FragmentPagerAdapter {

    public QuartasFinaisSeniorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new QuartasFinaisFragmentSenior();

        Bundle args;
        Log.d("quarta", "Entrei no adapter Senior");
        switch (position) {
            case 0:
                Log.d("quarta", "Entrei na primeira principal");

                args = new Bundle();
                args.putString("grupo", "principal");
                Log.d("quarta", "Bundle" + args.toString());
                fragment.setArguments(args);

                break;

            case 1:
                Log.d("quarta", "Entrei na repescagem");

                args = new Bundle();
                args.putString("grupo", "repescagem");

                fragment.setArguments(args);

                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String tab = null;

        switch (position) {
            case 0:
                tab = "Principal";

                break;

            case 1:
                tab = "Repescagem";
                break;
        }

        return tab;
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }
}
