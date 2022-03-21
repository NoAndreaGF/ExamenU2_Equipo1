package equipo1.losportales

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*

class CategoriasActivity : AppCompatActivity() {
    var categories = ArrayList<Categoria>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_categorias)
        addCategories()
        var listView: ListView = findViewById(R.id.list_categoria) as ListView
        var adapter: CategoriesAdapter = CategoriesAdapter(this, categories)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            if (position.equals(0)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }else if (position.equals(1)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
            else if (position.equals(2)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
            else if (position.equals(3)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
            else if (position.equals(4)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
            else if (position.equals(5)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
            else if (position.equals(6)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
            else if (position.equals(7)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
            else if (position.equals(8)){
                var intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun addCategories(){
        categories.add(Categoria(getString(R.string.tacos), R.drawable.tacoscategoria, getString(R.string.tacos_desc)))
        categories.add(Categoria(getString(R.string.antojitos),  R.drawable.antojitoscategoria, getString(R.string.antojitos_desc)))
        categories.add(Categoria(getString(R.string.bebidas),  R.drawable.bebidascategoria, getString(R.string.bebidas_desc)))
        categories.add(Categoria(getString(R.string.especialidades),  R.drawable.especialidadescategoria, getString(R.string.especialidades_desc)))
        categories.add(Categoria(getString(R.string.caldos),  R.drawable.caldoscategoria, getString(R.string.caldos_desc)))
        categories.add(Categoria(getString(R.string.combinations),  R.drawable.combinadoscategoria, getString(R.string.combinations_desc)))
        categories.add(Categoria(getString(R.string.tortas),  R.drawable.tortacategoria, getString(R.string.tortas_desc)))
        categories.add(Categoria(getString(R.string.sopas),  R.drawable.sopascategoria, getString(R.string.sopas_desc)))
    }

    private class CategoriesAdapter: BaseAdapter {
        var categories = ArrayList<Categoria>()
        var context: Context?=null

        constructor(context: Context, categories: ArrayList<Categoria>){
            this.categories = categories
            this.context = context
        }

        override fun getCount(): Int {
            return categories.size
        }

        override fun getItem(p0: Int): Any {
            return categories[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var cat = categories[p0]
            var inflator = LayoutInflater.from(context)
            var view = inflator.inflate(R.layout.activity_categoria_view, null)

            var image = view.findViewById(R.id.img_categoria) as ImageView
            var name = view.findViewById(R.id.categoria_nombre) as TextView
            var desc = view.findViewById(R.id.categoria_desc) as TextView

            image.setImageResource(cat.imagen)
            name.setText(cat.nombre)
            desc.setText(cat.descripcion)
            return view
        }
    }
}