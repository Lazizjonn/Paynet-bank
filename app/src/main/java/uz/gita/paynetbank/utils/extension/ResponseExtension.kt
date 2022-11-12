package uz.gita.paynetbank.utils.extension

import com.google.gson.Gson
import retrofit2.Response
import uz.gita.paynetbank.R
import uz.gita.paynetbank.data.model.common.ErrorResponse


fun <T> Response<T>.resultCodeCheck(errorHandler: ((String) -> String)? = null): ResultData<T> = when (code()) {
//    in 100.199 -> Informational response
    in 200..299 -> ResultData.success(body()!!)
//    in 300..399 -> Redirection message
//    in 400..499 -> Client error responses
    in 500..599 -> ResultData.fail(getErrorMessage(errorHandler))
    else -> ResultData.fail(getErrorMessage(errorHandler))

}


private fun <T> Response<T>.getErrorMessage(errorHandler: ((String) -> String)?): MessageData = when {
    errorBody() != null -> {
        MessageData.Text(
            if (errorHandler != null) errorHandler(errorBody()!!.toString())
//            else Json.decodeFromString(ErrorResponse, errorBody()!!.string()).error
            else Gson().fromJson(errorBody()!!.string(), ErrorResponse::class.java).error
        )
    }
    else -> MessageData.Resource(R.string.app_name)
}