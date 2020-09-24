package com.hemendra.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var spf = getSharedPreferences(Contasts.SPF_FILE_NAME,Context.MODE_PRIVATE)
        btn_Register.setOnClickListener {
            // creation of Shared Preference object

            // creation of Shared Preference  editor object
            var spe = spf.edit()

            spe.putString(Contasts.EMAIL_KEY,et_Email.text.toString())
            spe.putString(Contasts.PASSWORD_KEY,et_Password.text.toString())
            spe.commit()

        }

        btn_Login.setOnClickListener {

            var email = et_Email.text.toString()
            var password = et_Password.text.toString()

            var spf_email = spf.getString(Contasts.EMAIL_KEY,"")
            var spf_password = spf.getString(Contasts.PASSWORD_KEY,"")

            if(email.equals(spf_email))
            {
                if(password.equals(spf_password))
                {
                    var i = Intent(this@MainActivity,HomeActivity::class.java)
                    startActivity(i)
                }
                else{
                    Toast.makeText(this@MainActivity,"Incorrect Password",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this@MainActivity,"Invalid Email",Toast.LENGTH_SHORT).show()

            }

        }
    }
}