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

    var productos = ArrayList<ProductoPedido>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_pedido)

        val nomOpcion = intent.getStringExtra("nombre")
        val preOpcion = intent.getStringExtra("precio")
        val canOpcion = intent.getStringExtra("cantidad")

        val bundle = intent.extras

        var imagen = 0
        if(bundle != null) {
            imagen = bundle.getInt("imagen")
        }

        agregarPedido(nomOpcion, imagen, preOpcion, canOpcion)

        val adapter = adaptadorPedido(this, productos)
        val listview: ListView = findViewById(R.id.list_pedidos)
        listview.adapter = adapter

    }

    fun agregarPedido(nomOpcion: String?, imagen: Int, preOpcion: String?, canOpcion: String?) {
        productos.add(ProductoPedido(nomOpcion, imagen, preOpcion, canOpcion))
    }

    class adaptadorPedido: BaseAdapter {
        var productos = ArrayList<ProductoPedido>()
        var contexto: Context?= null

        constructor(contexto:Context, productos:ArrayList<ProductoPedido>) {
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
            var cantid = vista.findViewById(R.id.pedido_cantidad) as TextView
            var precio = vista.findViewById(R.id.pedido_precio) as TextView

            imagen.setImageResource(produ.imagen)
            nombre.setText(produ.nombre)
            precio.setText(produ.precio)
            cantid.setText(produ.cantidad)

            return vista
        }
    }

}