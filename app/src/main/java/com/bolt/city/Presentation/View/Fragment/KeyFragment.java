package com.bolt.city.Presentation.View.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bolt.city.Presentation.Contract.KeyContract;
import com.bolt.city.Presentation.Presenter.KeyPresenter;
import com.bolt.city.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeyFragment extends Fragment implements View.OnKeyListener, KeyContract {

    private static String LOG_TAG = KeyFragment.class.getSimpleName();

    EditText mKeyEdit;
    KeyPresenter mPresenter;



    public KeyFragment() {
        // Required empty public constructor
    }

    public static KeyFragment createInstance() {
        return new KeyFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_key, container, false);

        mKeyEdit = (EditText) view.findViewById(R.id.key_entry);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter = new KeyPresenter();
        mKeyEdit.setOnKeyListener(this);
    }

    @Override
    public void showUserData(String username, int id) {
        Toast.makeText(getActivity(), username + " " + id, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                (keyCode == KeyEvent.KEYCODE_ENTER)) {
            // Perform action on key press
            //TODO: Send key to the presenter
            //TODO: Return a username & id
            mPresenter.getUserCredentials(mKeyEdit.getText().toString());
            return true;
        }
        return false;
    }

}
