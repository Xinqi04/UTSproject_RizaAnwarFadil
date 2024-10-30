package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    private lateinit var etFoodName: EditText
    private lateinit var etServings: EditText
    private lateinit var etName: EditText
    private lateinit var etNotes: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Inisialisasi EditText
        etFoodName = findViewById(R.id.etFoodName)
        etServings = findViewById(R.id.etServings)
        etName = findViewById(R.id.etName)
        etNotes = findViewById(R.id.etNotes)
    }

    // Fungsi untuk mengirim data ke ConfirmationActivity
    fun confirmOrder(view: View) {
        // Ambil data dari EditText
        val foodName = etFoodName.text.toString()
        val servings = etServings.text.toString()
        val name = etName.text.toString()
        val notes = etNotes.text.toString()

        // Buat intent untuk pindah ke ConfirmationActivity dan kirim data
        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("FOOD_NAME", foodName)
            putExtra("SERVINGS", servings)
            putExtra("NAME", name)
            putExtra("NOTES", notes)
        }
        startActivity(intent)
    }
}
