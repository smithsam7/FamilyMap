package Layout;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import Activities.MainActivity;
import Objects.ClientModel;
import Objects.LoginRequest;
import Objects.LoginResult;
import Objects.PersonModel;
import Objects.RegisterRequest;
import Objects.RegisterResult;
import academy.learnprogramming.familymap.R;

public class LoginFragment extends Fragment {

    private Button signinButton;
    private Button registerButton;
    private EditText serverHostField;
    private EditText serverPortField;
    private EditText usernameField;
    private EditText passwordField;
    private EditText firstnameField;
    private EditText lastnameField;
    private EditText emailField;
    private RadioGroup genderField;


    public static LoginFragment newInstance(Context in){
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View v = layoutInflater.inflate(R.layout.fragment_login_fragment, container, false);

        serverHostField = (EditText) v.findViewById(R.id.serverHostInput);
        serverPortField = (EditText) v.findViewById(R.id.serverPortInput);
        usernameField = (EditText) v.findViewById(R.id.userNameInput);
        passwordField = (EditText) v.findViewById(R.id.passwordInput);
        firstnameField = (EditText) v.findViewById(R.id.firstNameInput);
        lastnameField = (EditText) v.findViewById(R.id.lastNameInput);
        emailField = (EditText) v.findViewById(R.id.emailInput);
        genderField = (RadioGroup) v.findViewById(R.id.genderInput);
        signinButton = (Button) v.findViewById(R.id.signInButton);
        registerButton = (Button) v.findViewById(R.id.registerButton);

        checkLoginValidation();
        checkRegisterValidation();

        serverHostField.addTextChangedListener(textFieldSignIn);
        serverHostField.addTextChangedListener(textFieldRegister);

        serverPortField.addTextChangedListener(textFieldSignIn);
        serverPortField.addTextChangedListener(textFieldRegister);

        usernameField.addTextChangedListener(textFieldSignIn);
        usernameField.addTextChangedListener(textFieldRegister);

        passwordField.addTextChangedListener(textFieldSignIn);
        passwordField.addTextChangedListener(textFieldRegister);

        firstnameField.addTextChangedListener(textFieldRegister);
        lastnameField.addTextChangedListener(textFieldRegister);
        emailField.addTextChangedListener(textFieldRegister);

        signinButton = (Button) v.findViewById(R.id.signInButton);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientModel.getInstance().setServerHost(serverHostField.getText().toString());
                ClientModel.getInstance().setServerPort(serverPortField.getText().toString());
                ClientModel.getInstance().setUserName(usernameField.getText().toString());
                ClientModel.getInstance().setPassword(passwordField.getText().toString());

                LoginRequest loginRequest = new LoginRequest(usernameField.getText().toString(), passwordField.getText().toString());
                new signinRequestAsycTask().execute(loginRequest);

            }
        });


        registerButton = (Button) v.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientModel.getInstance().setServerHost(serverHostField.getText().toString());
                ClientModel.getInstance().setServerPort(serverPortField.getText().toString());
                ClientModel.getInstance().setUserName(usernameField.getText().toString());
                ClientModel.getInstance().setPassword(passwordField.getText().toString());
                ClientModel.getInstance().setFirstName(firstnameField.getText().toString());
                ClientModel.getInstance().setLastName(lastnameField.getText().toString());
                ClientModel.getInstance().setEmail(emailField.getText().toString());
                int index = genderField.getCheckedRadioButtonId();
                if(index == R.id.maleButton){
                    ClientModel.getInstance().setGender("m");
                }
                else {
                    ClientModel.getInstance().setGender("f");
                }

                RegisterRequest registerRequest = new RegisterRequest(usernameField.getText().toString(),
                        passwordField.getText().toString(),
                        emailField.getText().toString(),
                        firstnameField.getText().toString(),
                        lastnameField.getText().toString(),
                        ClientModel.getInstance().getGender());
                new registerRequestAsycTask().execute(registerRequest);
            }
        });


        return v;
    }

    TextWatcher textFieldSignIn = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkLoginValidation();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    TextWatcher textFieldRegister = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkRegisterValidation();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void checkLoginValidation(){
        if(TextUtils.isEmpty(serverHostField.getText())
                || TextUtils.isEmpty(serverPortField.getText())
                || TextUtils.isEmpty(usernameField.getText())
                || TextUtils.isEmpty(passwordField.getText()) ){
            signinButton.setEnabled(false);
        }
        else {
            signinButton.setEnabled(true);
        }

    }

    public void checkRegisterValidation(){
        if(TextUtils.isEmpty(serverHostField.getText())
                || TextUtils.isEmpty(serverPortField.getText())
                || TextUtils.isEmpty(usernameField.getText())
                || TextUtils.isEmpty(passwordField.getText())
                || TextUtils.isEmpty(firstnameField.getText())
                || TextUtils.isEmpty(lastnameField.getText())
                || TextUtils.isEmpty(emailField.getText()) ){
            registerButton.setEnabled(false);
        }
        else {
            registerButton.setEnabled(true);
        }
    }



    private class signinRequestAsycTask extends AsyncTask<LoginRequest, Void, LoginResult> {
        @Override
        protected LoginResult doInBackground(LoginRequest... params) {
            return ClientModel.getInstance().getProxy().login(params[0]);
        }

        @Override
        protected void onPostExecute(LoginResult result){
            if(result.isSuccess()){
                new getdataAsycTask().execute();
            }
            else {
                Toast.makeText(getActivity(), "SignIn Failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    private class registerRequestAsycTask extends AsyncTask<RegisterRequest, Void, RegisterResult> {
        @Override
        protected RegisterResult doInBackground(RegisterRequest... params) {
            return ClientModel.getInstance().getProxy().register(params[0]);
        }

        @Override
        protected void onPostExecute(RegisterResult result){
            if(result.isSuccess()){
                new getdataAsycTask().execute();
            }
            else {
                Toast.makeText(getContext(), "SignIn Failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    private class getdataAsycTask extends AsyncTask<LoginRequest, Void, LoginResult> {
        @Override
        protected LoginResult doInBackground(LoginRequest... params) {
            ClientModel.getInstance().getProxy().getEvents();
            ClientModel.getInstance().getProxy().getPeople();
            LoginResult loginResult = new LoginResult();
            return loginResult;
        }

        @Override
        protected void onPostExecute(LoginResult loginResult ){
            for (PersonModel person : ClientModel.getInstance().getPeople()) {
                if (person.getPerson_id().equals(ClientModel.getInstance().getPersonID())) {
                    ClientModel.getInstance().setFirstName(person.getFirstname());
                    ClientModel.getInstance().setLastName(person.getLastname());
                }
            }
            if(ClientModel.getInstance().getFirstName() == null){
                Toast.makeText(getActivity(), "Not Registered", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getActivity(), ClientModel.getInstance().getFirstName() + " " + ClientModel.getInstance().getLastName(), Toast.LENGTH_LONG).show();

                ((MainActivity) getActivity()).swapFragments();
            }
        }

    }




}
