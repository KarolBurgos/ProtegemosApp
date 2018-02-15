package com.example.karolb.protegemosapp;




import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    private ImageView logo;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_principal, container, false);
        View contenedor = (View) container.getParent();
        appBar = (AppBarLayout) contenedor.findViewById(R.id.appbar);
        appBar.setBackgroundColor(Color.parseColor("#FF37D97C"));
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);

        int icons[] = {R.drawable.bus, R.drawable.inicio, R.drawable.inicio};
        tabs.getTabAt(0).setIcon(icons[0]);
        tabs.getTabAt(1).setIcon(icons[1]);
        tabs.getTabAt(2).setIcon(icons[2]);

        //    ImageView logo= (ImageView)view.findViewById(R.id,i);
        //  logo.setImageResource(R.drawable.inicio);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabs);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        //String tabtext=getResources().getStringArray(R.array.tabs);
        String[] tirulotabs = {"Inicio", "Inf", "NUestra"};

//String.valueOf(getResources().getDrawable(R.drawable.inicio))

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new InicioFragment();
                case 1:
                    return new contactenosFragment();
                case 2:
                    return new NuestraEmpresaFragment();

            }
            return null;
        }

        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return 3;
        }

        /**
         * This method may be called by the ViewPager to obtain a title string
         * to describe the specified page. This method may return null
         * indicating no title for this page. The default implementation returns
         * null.
         *
         * @param position The position of the title requested
         * @return A title for the requested page
         */
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    //tabs.addTab(tabs.newTab().setIcon(R.drawable.inicio));
                   // tabs.addTab(tabs.getTabAt(0).setIcon(R.drawable.inicio));
                    return "inicio";
                case 1:
                    return "inicio";
                case 2:
                    return "inicio";
            }
            return null;

        }
        // return tirulotabs[position];

    }



}