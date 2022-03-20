package equipo1.losportales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.view.menu.MenuView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn :Button = findViewById(R.id.botonE)
        btn.setOnClickListener{
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }
    }

}