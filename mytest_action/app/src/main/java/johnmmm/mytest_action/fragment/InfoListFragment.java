package johnmmm.mytest_action.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.LinearLayout;

import johnmmm.mytest_action.R;

public class InfoListFragment extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_AGE = "age";

    private String name;
    private int age;
    private String msg = "John APP:";

    private View mView = null;
    private LinearLayout curView;

    public InfoListFragment() {
        // Required empty public constructor
    }

    public static InfoListFragment newInstance(String name, int age) {
        InfoListFragment fragment = new InfoListFragment();
        Bundle args = new Bundle();

        args.putString(ARG_NAME, name);
        args.putInt(ARG_AGE, age);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(msg, "on create");
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            age = getArguments().getInt(ARG_AGE);
        }
    }

    private void initInfoListFragment() {
        Log.d(msg, "init info list fragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView != null) {
            return mView;
        }

        Log.d(msg, "on create view");

        //curView = (LinearLayout) inflater.inflate(R.layout.)
        //TODO: create a new layout of the fragment and show it.

        initInfoListFragment();

        return mView;
    }
}
