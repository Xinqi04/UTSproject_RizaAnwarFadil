package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME")
        val servings = intent.getStringExtra("SERVINGS")
        val name = intent.getStringExtra("NAME")
        val notes = intent.getStringExtra("NOTES")

        // Set data ke TextView
        findViewById<TextView>(R.id.tvFoodName).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.tvServings).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.tvName).text = "Ordering Name: $name"
        findViewById<TextView>(R.id.tvNotes).text = "Additional Notes: $notes"

        // Fungsi untuk tombol kembali
        findViewById<Button>(R.id.backToMenu).setOnClickListener {
            // Kembali ke OrderActivity atau ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
