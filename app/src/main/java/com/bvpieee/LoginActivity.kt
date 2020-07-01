package com.bvpieee

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bvpieee.models.SavedPreference
import com.bvpieee.utils.snackbar
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    lateinit var mGoogleSignInClient: GoogleSignInClient
    private var RC_SIGN_IN = 1
    private val firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val gso =GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso)

        startActivityForResult(mGoogleSignInClient.signInIntent,RC_SIGN_IN)

        googleSign.setOnClickListener{
            startActivityForResult(mGoogleSignInClient.signInIntent,RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_SIGN_IN){
            val task =GoogleSignIn.getSignedInAccountFromIntent(data)
            progressBar.visibility = View.VISIBLE
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            }catch (e:Exception){
                progressBar.visibility = View.INVISIBLE
            }
        }
    }
    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount){
        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    progressBar.visibility = View.VISIBLE
                    SavedPreference.setEmail(this, account.email.toString())
                    SavedPreference.setUsername(this, account.displayName.toString())
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
                else snackbar(findViewById(R.id.googleSign),"Authentication Failed"); progressBar.visibility = View.INVISIBLE
            }
    }

    override fun onStart() {
        super.onStart()
        if(GoogleSignIn.getLastSignedInAccount(this) != null){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

}