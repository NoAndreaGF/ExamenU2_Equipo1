package equipo1.losportales

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class PedidoActivity : AppCompatActivity() {

    private var productos = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_pedido)


        val adapter = adaptadorPedido(this, productos)
        val listview: ListView = findViewById(R.id.list_pedidos)
        listview.adapter = adapter

    }

    class adaptadorPedido: BaseAdapter {
        var productos = ArrayList<Producto>()
        var contexto: Context?= null

        constructor(contexto:Context, productos:ArrayList<Producto>) {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var produ = productos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.activity_pedido_view, null)

            var imagen = vista.findViewById(R.id.pedido_img) as ImageView
            var nombre = vista.findViewById(R.id.pedido_nombre) as TextView
            var desc = vista.findViewById(R.id.pedido_desc) as TextView
            var precio = vista.findViewById(R.id.pedido_precio) as TextView

            imagen.setImageResource(produ.imagen)
            nombre.setText(produ.nombre)
            desc.setText(produ.descripcion)
            precio.setText(produ.precio)

            return vista
        }
    }

}