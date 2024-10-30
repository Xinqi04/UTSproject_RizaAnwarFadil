package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val inputUsername = etUsername.text.toString()
            val inputPassword = etPassword.text.toString()

            if (validateCredentials(inputUsername, inputPassword)) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                // Pindah ke HomeActivity setelah login berhasil
                val intent = Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
                finish()  // Optional: menutup MainActivity agar tidak kembali ke sini saat menekan tombol "back"
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }


        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val registeredUsername = sharedPreferences.getString("username", "")
        val registeredPassword = sharedPreferences.getString("password", "")

        return username == registeredUsername && password == registeredPassword
    }
}
