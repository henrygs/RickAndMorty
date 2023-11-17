package com.example.apimanager.interceptors


import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ResponseInterceptor(private val disableRetry: Boolean): Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var response = makeRequest(chain)
        if(disableRetry) {
            return response
        }

        var attempt = 0
        while (response.code == CODE_TIMEOUT && attempt < MAX_RETRY) {
            attempt++
            response = makeRequest(chain, attempt)
        }
        return response
    }

    private fun makeRequest(chain: Interceptor.Chain, attempt: Int = 0): Response {
        var tryOutTimeout = attempt
        try {
            return chain.proceed(chain.request())
        } catch (ex: Exception) {
            ex.message?.let{
                if(it.contains(TIMEOUT) && tryOutTimeout < MAX_RETRY) {
                    tryOutTimeout++
                    return makeRequest(chain, tryOutTimeout)
                }
            }
            throw IOException(TIMEOUT)
        }
    }

    companion object {
        private const val CODE_TIMEOUT = 504
        private const val MAX_RETRY = 2
        private const val TIMEOUT = "timeout"

    }
}