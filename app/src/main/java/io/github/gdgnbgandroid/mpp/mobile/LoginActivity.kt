package io.github.gdgnbgandroid.mpp.mobile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setTitle(R.string.title_login)

        floatingActionButton.setOnClickListener {
            when {
                emailTextInputEditText.text.isNullOrBlank() ->
                    emailTextInputEditText.error = getString(R.string.error_no_email_provided)
                passwordTextInputEditText.text.isNullOrBlank() ->
                    passwordTextInputEditText.error = getString(R.string.error_no_password_provided)
                else -> {
                    authenticate(
                        emailTextInputEditText.text!!.toString(),
                        passwordTextInputEditText.text!!.toString()
                    )
                }
            }
        }
    }

    private fun authenticate(email: String, password: String) {
        try {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(EXTRA_USER_IDENTIFICATION, "$email$password".toHash())
            })
            finish()
        } catch (e: Exception) {
            showError(e) {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }

    private fun showError(throwable: Throwable?, onDoneAction: () -> Unit) {
        Snackbar.make(
            findViewById(android.R.id.content),
            throwable?.localizedMessage ?: getString(R.string.error_general),
            Snackbar.LENGTH_INDEFINITE
        ).setAction(getString(android.R.string.ok)) {
            onDoneAction.invoke()
        }
    }

    companion object {
        const val EXTRA_USER_IDENTIFICATION = "extra_user_identification"
    }
}