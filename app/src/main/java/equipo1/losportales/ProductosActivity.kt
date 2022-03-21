package equipo1.losportales

import android.content.Context
import android.content.Intent
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

class ProductosActivity : AppCompatActivity() {
    var titulo: Int = 0

    var menu: ArrayList<Producto> = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_productos)

        val menuOpcion = intent.getStringExtra("menuType")

        if(menuOpcion != null){
            agregarProductos(menuOpcion)
        }

        var imageView: ImageView = findViewById(R.id.imagen_titulo)

        imageView.setImageResource(titulo)

        var listview: ListView = findViewById<ListView>(R.id.list_producto) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)

        listview.adapter = adaptador
    }

    fun agregarProductos(opcion: String?) {
        when(opcion) {
            "Tacos" ->{
                titulo = R.drawable.tacos
                menu.add(Producto(R.string.tacoT,R.drawable.tacotradicional,R.string.tacoT_desc,R.string.tacoT_precio))
                menu.add(Producto(R.string.tacoP,R.drawable.tacopescado,R.string.tacoP_desc,R.string.tacoP_precio))
            }
            "Antojitos" ->{
                titulo = R.drawable.antojitos
                menu.add(Producto(R.string.quesadilla,R.drawable.quesadillas,R.string.quesadilla_desc,R.string.quesadilla_precio))
                menu.add(Producto(R.string.huaraches,R.drawable.huarache,R.string.huaraches_desc,R.string.huarache_precio))
                menu.add(Producto(R.string.gringas,R.drawable.gringa,R.string.gringas_desc,R.string.gringas_precio))
                menu.add(Producto(R.string.sincronizadas,R.drawable.sincronizada,R.string.sincronizadas_desc,R.string.sincronizadas_precio))
                menu.add(Producto(R.string.sopes,R.drawable.sopes,R.string.sopes_desc,R.string.sopes_precio))
                menu.add(Producto(R.string.tostadas,R.drawable.tostadas,R.string.tostadas_desc,R.string.tostadas_precio))
            }
            "Especialidades" ->{
                titulo = R.drawable.especialidades
                menu.add(Producto(R.string.mojarra,R.drawable.mojarrafrita,R.string.mojarra_desc,R.string.mojarra_precio))
                menu.add(Producto(R.string.tostadasCev,R.drawable.tostadaceviche,R.string.tostadasCev_desc,R.string.tostadasCev_precio))
                menu.add(Producto(R.string.fajitaBurrito,R.drawable.fajitaburrito,R.string.fajitaBurrito_desc,R.string.fajitaBurrito_precio))
                menu.add(Producto(R.string.fajitaBurrito,R.drawable.fajitaquesadilla,R.string.fajitaQuesadilla_desc,R.string.fajitaQuesadilla_precio))
                menu.add(Producto(R.string.botanaCamarones,R.drawable.botanacamarones,R.string.vacio,R.string.botanaCamarones_precio))
                menu.add(Producto(R.string.coctelCamaron,R.drawable.coctelcamaron,R.string.vacio,R.string.coctelCamaron_precio))
            }
            "Caldos" ->{
                titulo = R.drawable.caldos
                menu.add(Producto(R.string.larger,R.drawable.caldopollo,R.string.vacio,R.string.larger_precio))
                menu.add(Producto(R.string.camaron,R.drawable.camaron,R.string.vacio,R.string.camaron_precio))
            }
            "Combinaciones" ->{
                titulo = R.drawable.combinados
                menu.add(Producto(R.string.traditionalTacoCombo,R.drawable.tradicionaltacocombo,R.string.traditionalTacoCombo_desc,R.string.traditionalTacoCombo_precio))
                menu.add(Producto(R.string.mexicanBurritos,R.drawable.burritosmexicanos,R.string.mexicanBurritos_desc,R.string.mexicanBurritos_precio))
                menu.add(Producto(R.string.losPortalesBurritos,R.drawable.portalesburritos,R.string.losPortalesBurritos_des,R.string.losPortalesBurritos_precio))
                menu.add(Producto(R.string.cinco,R.drawable.cinco,R.string.cinco_desc,R.string.cinco_precio))
                menu.add(Producto(R.string.dosAmigos,R.drawable.dosamigos,R.string.dosAmigos_desc,R.string.dosAmigos_precio))
                menu.add(Producto(R.string.burritoPepe,R.drawable.burritopepe,R.string.burritoPepe_desc,R.string.burritoPepe_precio))
            }
            "Tortas" ->{
                titulo = R.drawable.combinados
                menu.add(Producto(R.string.vacio,R.drawable.tortaregular,R.string.tortas_desc,R.string.vacio))
                menu.add(Producto(R.string.tortaRegular,R.drawable.tortaregular,R.string.tortaRegular_desc,R.string.tortaRegular_precio))
                menu.add(Producto(R.string.tortaMilanesaResOPollo,R.drawable.torta,R.string.tortaMilanesaResOPollo_desc,R.string.tortaMilanesaResOPollo_precio))
                menu.add(Producto(R.string.tortaCubana,R.drawable.tortacubana,R.string.tortaCubana_desc,R.string.tortaCubana_precio))
                menu.add(Producto(R.string.tortaMixta,R.drawable.tortamixta,R.string.tortaMixta_desc,R.string.tortaMixta_precio))
                menu.add(Producto(R.string.smallMexicanTorta,R.drawable.tortachica,R.string.smallMexicanTorta_desc,R.string.smallMexicanTorta_precio))
            }
            "Sopas" ->{
                titulo = R.drawable.sopas
                menu.add(Producto(R.string.pozole,R.drawable.pozole,R.string.pozole_desc,R.string.pozole_precio))
                menu.add(Producto(R.string.menudo,R.drawable.menudo,R.string.menudo_desc,R.string.menudo_precio))
                menu.add(Producto(R.string.caldoRes,R.drawable.caldores,R.string.vacio,R.string.caldoRes_precio))
                menu.add(Producto(R.string.caldoCamaron,R.drawable.caldocamaron,R.string.caldoCamaron_desc,R.string.caldoCamaron_precio))
                menu.add(Producto(R.string.sopaMariscos,R.drawable.sopamariscos,R.string.sopaMariscos_desc,R.string.sopaMariscos_precio))
                menu.add(Producto(R.string.coctelCamaron,R.drawable.coctelcamaron,R.string.coctelCamaron_desc,R.string.coctelCamaron_precio))
            }
            "Extras" ->{
                titulo = R.drawable.extras
                menu.add(Producto(R.string.sideGuacamole,R.drawable.guacamole,R.string.vacio,R.string.sideGuacamole_precio))
                menu.add(Producto(R.string.sideRice,R.drawable.arroz,R.string.vacio,R.string.sideRice_precio))
                menu.add(Producto(R.string.sideBeans,R.drawable.frijoles,R.string.vacio,R.string.sideBeans_precio))
                menu.add(Producto(R.string.chipsSalsa,R.drawable.salsaytostadas,R.string.vacio,R.string.chipsSalsa_precio))
                menu.add(Producto(R.string.flourTacos,R.drawable.tortillas,R.string.vacio,R.string.flourTacos_precio))
            }
            "Bebidas-Drinks" ->{
                titulo = R.drawable.bebidas
                menu.add(Producto(R.string.sodas,R.drawable.soda20oz,R.string.vacio,R.string.sodas_precio))
                menu.add(Producto(R.string.jarritos,R.drawable.jarritos,R.string.vacio,R.string.jarritos_precio))
                menu.add(Producto(R.string.aguasFrescas,R.drawable.aguasfrescas,R.string.vacio,R.string.aguasFrescas_precio))
                menu.add(Producto(R.string.domesticBeer,R.drawable.cerveza,R.string.vacio,R.string.domesticBeer_precio))
                menu.add(Producto(R.string.mexicanBeer,R.drawable.cervezamexicana,R.string.vacio,R.string.mexicanBeer))
                menu.add(Producto(R.string.micheladas,R.drawable.michelada,R.string.vacio,R.string.micheladas_precio))
                menu.add(Producto(R.string.caguamas,R.drawable.caguama,R.string.vacio,R.string.caguamas_precio))
                menu.add(Producto(R.string.caguamaMichelada,R.drawable.caguamamichelada,R.string.vacio,R.string.caguamaMichelada_precio))
                menu.add(Producto(R.string.cubetazos,R.drawable.cubetazo,R.string.vacio,R.string.cubetazos_precio))
                menu.add(Producto(R.string.lataBeer,R.drawable.cervezalata,R.string.vacio,R.string.lataBeer_precio))
                menu.add(Producto(R.string.charolazo,R.drawable.charolazo,R.string.vacio,R.string.charolazo_precio))
                menu.add(Producto(R.string.charolazoCamarones,R.drawable.charolazocamarones,R.string.vacio,R.string.charolazoCamarones_precio))
                menu.add(Producto(R.string.laMamalona,R.drawable.mamalona,R.string.vacio,R.string.laMamalona_precio))
                menu.add(Producto(R.string.laMamalonaCamarones,R.drawable.mamalonacamaron,R.string.vacio,R.string.laMamalonaCamarones_precio))
                menu.add(Producto(R.string.cubetazo,R.drawable.cubetazoseis,R.string.vacio,R.string.cubetazo))
            }
        }
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Producto>()
        var contexto: Context?= null

        constructor(contexto: Context, productos: ArrayList<Producto>) {
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
            var prod = productos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.activity_menu_view, null)

            var imagen = vista.findViewById(R.id.img_producto) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.imagen)
            nombre.setText(prod.nombre)
            desc.setText(prod.descripcion)
            precio.setText(prod.precio)

            var queVariable = prod.imagen

            //Este hace que se vaya a al producto view
            imagen.setOnClickListener{
                val intent:Intent = Intent(contexto, producto_view::class.java)
                intent.putExtra("nombre", prod.nombre)
                intent.putExtra("imagen",prod.imagen)
                intent.putExtra("precio",prod.precio)
                contexto!!.startActivity(intent)

            }
            nombre.setOnClickListener{
                val intent:Intent = Intent(contexto, producto_view::class.java)
                intent.putExtra("nombre", prod.nombre)
                intent.putExtra("imagen",prod.imagen)
                intent.putExtra("precio",prod.precio)
                contexto!!.startActivity(intent)

            }
            desc.setOnClickListener{
                val intent:Intent = Intent(contexto, producto_view::class.java)
                intent.putExtra("nombre", prod.nombre)
                intent.putExtra("imagen",prod.imagen)
                intent.putExtra("precio",prod.precio)
                contexto!!.startActivity(intent)

            }
            precio.setOnClickListener{
                val intent:Intent = Intent(contexto, producto_view::class.java)
                intent.putExtra("nombre", prod.nombre)
                intent.putExtra("imagen",prod.imagen)
                intent.putExtra("precio",prod.precio)
                contexto!!.startActivity(intent)

            }

            return vista
        }

    }

}