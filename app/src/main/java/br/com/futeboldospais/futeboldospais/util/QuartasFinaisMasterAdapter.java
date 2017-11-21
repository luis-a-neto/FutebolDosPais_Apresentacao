package br.com.futeboldospais.futeboldospais.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.controller.QuartasFinaisFragmentMaster;

/**
 * Created by Pamela Fidels on 15/11/17.
 */

public class QuartasFinaisMasterAdapter extends FragmentPagerAdapter {

    public QuartasFinaisMasterAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new QuartasFinaisFragmentMaster();

        Log.d("quarta", "POSITION " + position);

        Bundle args;
        Log.d("quarta", "Entrei no adapter master");
        switch (position) {
            case 0:
                Log.d("quarta", "Entrei no principal");

                  args = new Bundle();
                args.putString("grupo", "principal");
                Log.d("quarta", "Bundle" + args.toString());
                fragment.setArguments(args);


                break;

            case 1:
                Log.d("quarta", "Entrei no repescagem");

                args = new Bundle();
                args.putString("grupo", "repescagem");
                Log.d("quarta", "Bundle" + args.toString());
                fragment.setArguments(args);

                break;

        }
        Log.d("quarta", "Vou retornar");

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
