package edu.uwyo.toddt.helloworldplus;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HelloFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HelloFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HelloFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    String name;
    EditText myText;
    private Button myButton;

    public HelloFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HelloFragment newInstance() {
        HelloFragment fragment = new HelloFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View helloInflate =  inflater.inflate(R.layout.fragment_hello, container, false);
        myText = (EditText) helloInflate.findViewById( R.id.name);
        myButton = (Button) helloInflate.findViewById(R.id.Button01);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = myText.getText().toString();

                Toast.makeText(getActivity(), "Hello " + name, Toast.LENGTH_SHORT).show();

                if(mListener != null){
                    mListener.onFragmentInteraction(name);
                }

                Log.d("HelloFrag", "Logged Name: " + name);
            }
        });
        return helloInflate;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String name);
    }
}
