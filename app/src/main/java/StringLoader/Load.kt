package StringLoader

import android.content.Context
import com.example.tp.Question


class Load(private val context: Context) {


    fun Stringload(Nom: String): String {
            val id:Int = context.getResources().getIdentifier( Nom, "string", context.getPackageName())
        return if (id==0) {
            ""
        } else {
            context.getString(id)
        }
    }
    fun Questionsload(): MutableMap<MutableList<Question>, String> {
        var Questions: MutableMap<MutableList<Question>,String> = mutableMapOf()
        var Q: Question
        var Enoncé: String
        val Themes = StrListload("Th")
        for(i in 1..Themes.size){
            var list: MutableList<Question> = mutableListOf()
            var j: Int = 1
            while(true){
                Enoncé = Stringload("Th${i}_Q${j}")
                val i1 = if (Enoncé == "")
                    break
                else {
                    list.add(Question(Themes[i - 1], Enoncé, StrListload("Th${i}_Q${j}_R")))
                    j++
                }
            }
            Questions[list] = Themes[i-1]
        }
        return Questions
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