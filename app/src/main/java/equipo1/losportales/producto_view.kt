package equipo1.losportales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
//aquí es donde se manipula al producto, se selecciona su ingrediente y
//la cantidad de dicho producto
class producto_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_view)
        val producto_nombre: TextView = findViewById(R.id.producto_nombre)
        val producto_precio: TextView = findViewById(R.id.producto_precio)
        val producto_img: ImageView = findViewById(R.id.producto_img)
        val producto_total: TextView = findViewById(R.id.producto_total)

        val bundle = intent.extras

        if(bundle!=null)
        {
            producto_nombre.setText(bundle.getString("nombre"))
            producto_precio.setText(bundle.getString("precio"))
            producto_img.setImageResource(bundle.getInt("imagen"))
            producto_total.setText(bundle.getString("precio"))
        }

        val btn_mas: Button = findViewById(R.id.producto_cantidad_mas)
        val btn_menos: Button = findViewById(R.id.producto_cantidad_menos)
        val producto_cantidad: TextView = findViewById(R.id.producto_cantidad)

        btn_mas.setOnClickListener{
            var cantidadInt = Integer.parseInt(producto_cantidad.text.toString())
            var precio = Integer.parseInt(producto_precio.text.toString())

            cantidadInt += 1
            producto_cantidad.setText(cantidadInt.toString())
            var  total= cantidadInt*precio
            producto_total.setText(total.toString())
        }

        btn_menos.setOnClickListener{
            var cantidadInt = Integer.parseInt(producto_cantidad.text.toString())
            var precio = Integer.parseInt(producto_precio.text.toString())
            if(cantidadInt>1){
                cantidadInt -= 1
                producto_cantidad.setText(cantidadInt.toString())
                var  total= cantidadInt*precio
                producto_total.setText(total.toString())
            }
        }
    }
}
