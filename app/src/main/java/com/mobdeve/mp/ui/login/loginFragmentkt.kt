package com.mobdeve.mp.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobdeve.mp.Job
import com.mobdeve.mp.MyDatabaseHelper
import com.mobdeve.mp.R
import com.mobdeve.mp.Student
import com.mobdeve.mp.databinding.FragmentLoginBinding


class loginFragmentkt : Fragment() {
    private var loginViewModel: LoginViewModel? = null
    private var binding: FragmentLoginBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)
        val usernameEditText = binding!!.username
        val passwordEditText = binding!!.password
        val loginButton = binding!!.login
        val loadingProgressBar = binding!!.loading
        loginViewModel!!.loginFormState.observe(viewLifecycleOwner,
            Observer<LoginFormState?> { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                loginButton.isEnabled = loginFormState.isDataValid
                if (loginFormState.usernameError != null) {
                    usernameEditText.error = getString(loginFormState.usernameError!!)
                }
                if (loginFormState.passwordError != null) {
                    passwordEditText.error = getString(loginFormState.passwordError!!)
                }
            })
        loginViewModel!!.loginResult.observe(viewLifecycleOwner,
            Observer<LoginResult?> { loginResult ->
                if (loginResult == null) {
                    return@Observer
                }
                loadingProgressBar.visibility = View.GONE
                if (loginResult.error != null) {
                    showLoginFailed(loginResult.error)
                }
                if (loginResult.success != null) {
                    updateUiWithUser(loginResult.success)
                }
            })
        val afterTextChangedListener: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                loginViewModel!!.loginDataChanged(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
        usernameEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel!!.login(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
            false
        }
        loginButton.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            loginViewModel!!.login(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
            // Assuming you have a Student instance
            val student = Student(
                id = 1,
                name = usernameEditText.text.toString(),
                password = passwordEditText.text.toString(),
                bookmarks = arrayListOf(Job(id = 1, company = "ABC Corp", name = "Software Engineer"))
            )

            // Assuming you have an instance of MyDatabaseHelper
            val dbHelper = MyDatabaseHelper(requireContext())

            // Add the student to the database
            val newRowId = dbHelper.addStudent(student)

            // Check the result
            if (newRowId != -1L) {
                // The student was added successfully
                println("Student added with ID: $newRowId")
            } else {
                // There was an error
                println("Error adding student to the database")
            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView?) {
        val welcome = getString(R.string.welcome) + model!!.displayName
        // TODO : initiate successful logged in experience
        if (context != null && requireContext().applicationContext != null) {
            Toast.makeText(requireContext().applicationContext, welcome, Toast.LENGTH_LONG).show()
        }
    }

    private fun showLoginFailed(@StringRes errorString: Int?) {
        if (context != null && requireContext().applicationContext != null) {
            Toast.makeText(
                requireContext().applicationContext,
                errorString!!,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}