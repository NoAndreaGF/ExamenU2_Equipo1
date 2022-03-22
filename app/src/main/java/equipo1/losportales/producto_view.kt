package equipo1.losportales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
//aquí es donde se manipula al producto, se selecciona su ingrediente y
//la cantidad de dicho producto
class producto_view : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_producto_view)

        val producto_nombre: TextView = findViewById(R.id.producto_nombre)
        val producto_precio: TextView = findViewById(R.id.producto_precio)
        val producto_img: ImageView = findViewById(R.id.producto_img)
        val producto_total: TextView = findViewById(R.id.producto_total)

        val nomOpcion = intent.getStringExtra("nombre")
        val preOpcion = intent.getStringExtra("precio")

        if (nomOpcion != null && preOpcion != null) {
            producto_nombre.setText(nomOpcion)
            producto_precio.setText(preOpcion)
        }

        val bundle = intent.extras

        var imagen = 0
        if(bundle!=null)
        {
            imagen = bundle.getInt("imagen")
            producto_img.setImageResource(bundle.getInt("imagen"))
            producto_total.setText(bundle.getString("precio"))
        }

        val btn_mas: Button = findViewById(R.id.producto_cantidad_mas)
        val btn_menos: Button = findViewById(R.id.producto_cantidad_menos)
        val producto_cantidad: TextView = findViewById(R.id.producto_cantidad)

        var cantidadInt: Int
        var cantidad: Float = 0.0f
        var  total: Float = 0.0f

        btn_mas.setOnClickListener{
            cantidad = producto_cantidad.text.toString().toFloat()
            var precio = producto_precio.text.toString().toFloat()

            cantidad += 1
            producto_cantidad.setText(cantidad.toInt().toString())
            total= cantidad*precio
            producto_total.setText(total.toString())
        }

        btn_menos.setOnClickListener{
            cantidad = producto_cantidad.text.toString().toFloat()
            var precio = producto_precio.text.toString().toFloat()
            if(cantidad>1){
                cantidad -= 1
                producto_cantidad.setText(cantidad.toInt().toString())
                total= cantidad*precio
                producto_total.setText(total.toString())
            }
        }

        cantidadInt = cantidad.toInt()

        val btn_agregar: Button = findViewById(R.id.producto_agregar)

        btn_agregar.setOnClickListener{
            var intent: Intent = Intent(this, PedidoActivity::class.java)
            intent.putExtra("nombre", nomOpcion)
            intent.putExtra("precio", total)
            intent.putExtra("imagen", imagen)
            intent.putExtra("cantidad", cantidadInt)

            startActivity(intent)
        }

    }
}

