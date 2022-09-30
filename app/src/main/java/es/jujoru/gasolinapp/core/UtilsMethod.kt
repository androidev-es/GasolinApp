package es.jujoru.gasolinapp.core
import android.text.format.DateUtils
import java.util.*

object UtilsMethod {

    fun getCurrentDate(): String {
        val dateNow = Calendar.getInstance().time
        return dateNow.convertString()
    }

    fun isDateDiffToday(date: String): Boolean {
        val dateCompare = date.convertDate()
        return !DateUtils.isToday(dateCompare.time)
    }
}