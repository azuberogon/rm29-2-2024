import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.MAS.examenpmdm.R
import com.MAS.examenpmdm.model.entity.Usuario


class UserAdapter(private val userList: List<Usuario>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var usuario: MutableList<Usuario>  = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(usuario: MutableList<Usuario>, context: Context){
        this.usuario = usuario
        this.context = context

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.usuario_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user, context)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usrNombre = itemView.findViewById(R.id.form_tv_nombre) as TextView
        var usredad = itemView.findViewById(R.id.form_tv_edad) as TextView
        val usrProfesion = itemView.findViewById(R.id.form_tv_profesion) as TextView

        fun bind(user: Usuario, context: Context) {
            usrNombre.text = user.nombre
            usredad.text = user.edad.toString()
            usrProfesion.text = user.profesion
        }

    }
}
