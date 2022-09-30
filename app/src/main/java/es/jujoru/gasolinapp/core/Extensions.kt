package es.jujoru.gasolinapp.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import es.jujoru.gasolinapp.domain.model.Error
import es.jujoru.gasolinapp.core.Constants.DATE_DEFAULT_FORMAT
import es.jujoru.gasolinapp.core.Constants.USER_PREFERENCES
import retrofit2.HttpException
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

fun Date.convertString( locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(DATE_DEFAULT_FORMAT, locale)
    return formatter.format(this)
}

fun String.convertDate(locale: Locale = Locale.getDefault()): Date {
    val calendar = Calendar.getInstance()
    val formatter = SimpleDateFormat(DATE_DEFAULT_FORMAT, locale)
    val date = formatter.parse(this)
    date?.let {
        calendar.time = it
    }
    return calendar.time

}

suspend fun <T> tryCall(action: suspend () -> T): Either<Error, T> = try {
    action().right()
} catch (exception: Exception) {
    exception.toErrorRetrieved().left()
}

fun Throwable.toErrorRetrieved(): Error = when (this) {
    is IOException -> Error.Connectivity
    is HttpException -> Error.Server(code())
    else -> Error.Unknown(message ?: "")
}