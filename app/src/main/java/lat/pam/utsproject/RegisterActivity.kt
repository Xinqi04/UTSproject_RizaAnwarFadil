package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var etRegisterUsername: EditText
    private lateinit var etRegisterPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etRegisterUsername = findViewById(R.id.etRegisterUsername)
        etRegisterPassword = findViewById(R.id.etRegisterPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val username = etRegisterUsername.text.toString()
            val password = etRegisterPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                saveCredentials(username, password)
                Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveCredentials(username: String, password: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }
}
