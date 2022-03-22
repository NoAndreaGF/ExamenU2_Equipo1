package equipo1.losportales

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils

class CategoriasActivity : AppCompatActivity() {

    var categorias: ArrayList<CategoriaMenu> = ArrayList<CategoriaMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.activity_categorias)

        agregarCategorias()

        var listview: ListView = findViewById<ListView>(R.id.list_categoria) as ListView
        var adaptador: AdaptadorCategorias = AdaptadorCategorias(this, categorias)

        listview.adapter = adaptador

    }

    fun agregarCategorias() {
        categorias.add(CategoriaMenu(R.string.tacos,R.drawable.tacoscategoria,R.string.tacos_desc))
        categorias.add(CategoriaMenu(R.string.antojitos,R.drawable.antojitoscategoria,R.string.antojitos_desc))
        categorias.add(CategoriaMenu(R.string.especialidades,R.drawable.especialidadescategoria,R.string.especialidades_desc))
        categorias.add(CategoriaMenu(R.string.caldos,R.drawable.caldoscategoria,R.string.caldos_desc))
        categorias.add(CategoriaMenu(R.string.combinations,R.drawable.combinadoscategoria,R.string.combinations_desc))
        categorias.add(CategoriaMenu(R.string.tortas,R.drawable.tortacategoria,R.string.tortas_desc))
        categorias.add(CategoriaMenu(R.string.sopas,R.drawable.sopascategoria,R.string.sopas_desc))
        categorias.add(CategoriaMenu(R.string.sideOrders,R.drawable.extrascategoria,R.string.sideOrders_desc))
        categorias.add(CategoriaMenu(R.string.bebidas,R.drawable.bebidascategoria,R.string.bebidas_desc))
    }

    private class AdaptadorCategorias: BaseAdapter {

        var categorias = ArrayList<CategoriaMenu>()
        var contexto: Context?= null

        constructor(contexto: Context, categorias: ArrayList<CategoriaMenu>) {
            this.categorias = categorias
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return categorias.size
        }

        override fun getItem(p0: Int): Any {
            return categorias[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var categ = categorias[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.activity_categoria_view, null)

            var imagen = vista.findViewById(R.id.img_categoria) as ImageView
            var nombre = vista.findViewById(R.id.categoria_nombre) as TextView
            var desc = vista.findViewById(R.id.categoria_desc) as TextView

            var nom = categ.nombre

            imagen.setImageResource(categ.imagen)
            nombre.setText(categ.nombre)
            desc.setText(categ.descripcion)

            imagen.setOnClickListener{
                val intent: Intent = Intent(contexto, ProductosActivity::class.java)
                intent.putExtra("menuType", contexto?.getString(nom))
                contexto!!.startActivity(intent)
            }
            nombre.setOnClickListener{
                val intent: Intent = Intent(contexto, ProductosActivity::class.java)
                intent.putExtra("menuType", contexto?.getString(nom))
                contexto!!.startActivity(intent)
            }
            desc.setOnClickListener{
                val intent: Intent = Intent(contexto, ProductosActivity::class.java)
                intent.putExtra("menuType", contexto?.getString(nom))
                contexto!!.startActivity(intent)
            }

            return vista
        }


    }
}