package es.jujoru.gasolinapp.domain.model

sealed interface Error {
    class Server(val code: Int): Error
    object Connectivity: Error
    class Unknown(val msg: String): Error
}