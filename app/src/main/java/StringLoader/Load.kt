package StringLoader




import android.content.Context
import com.example.tp.MainApplication
import com.example.tp.Question
import com.example.tp.Theme


class Load() {

    var context: Context = MainApplication.applicationContext()

    fun Stringload(Nom: String): String {
        val id:Int = context.getResources().getIdentifier( Nom, "string", context.getPackageName())
        return if (id==0) {
            ""
        } else {
            context.getString(id)
        }
    }
    fun Themeload(): List<Theme> {
        val Thèmes: MutableList<Theme> = mutableListOf()
        var Enoncé: String
        val temp = StrListload("Th")
        for(i in 1..temp.size){
            var list: MutableList<Question> = mutableListOf()
            var j: Int = 1
            while(true){
                Enoncé = Stringload("Th${i}_Q${j}")
                val i1 = if (Enoncé == "")
                    break
                else {
                    list.add(Question(Enoncé, StrListload("Th${i}_Q${j}_R")))
                    j++
                }
            }
            Thèmes.add(
                Theme(
                    temp[i - 1],
                    context.getString(context.getResources().getIdentifier("Th${i}", "color", context.getPackageName())),
                    list
                )
            )
        }
        return Thèmes
    }


    fun StrListload(Nom: String): List<String> {
        val List: MutableList<String> = mutableListOf()
        var str: String = ""
        var i: Int = 1
        while(true){
            str=Stringload("${Nom}${i}")
            if(str == "")
                break
            else{
                List.add(str)
                i++
            }
        }
        return List
    }
}

