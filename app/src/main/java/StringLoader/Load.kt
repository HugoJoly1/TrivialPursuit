package StringLoader




import android.content.Context
import com.example.tp.MainApplication
import com.example.tp.Question
import com.example.tp.Theme


class Load() {

    var context: Context = MainApplication.applicationContext()

    fun stringLoad(nom: String): String {
        val id:Int = context.getResources().getIdentifier(nom, "string", context.getPackageName())
        return if (id==0) {
            ""
        } else {
            context.getString(id)
        }
    }
    fun themeLoad(): List<Theme> {
        val Thèmes: MutableList<Theme> = mutableListOf()
        var Enoncé: String
        val temp = strListLoad("Th")
        for(i in 1..temp.size){
            var list: MutableList<Question> = mutableListOf()
            var j: Int = 1
            while(true){
                Enoncé = stringLoad("Th${i}_Q${j}")
                val i1 = if (Enoncé == "")
                    break
                else {
                    list.add(Question(Enoncé, strListLoad("Th${i}_Q${j}_R")))
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


    fun strListLoad(Nom: String): MutableList<String> {
        val List: MutableList<String> = mutableListOf()
        var str: String = ""
        var i: Int = 1
        while(true){
            str=stringLoad("${Nom}${i}")
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

