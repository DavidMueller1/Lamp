package com.example.newlamp.services

import android.util.Log
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException


val BACKEND_URL = "http://192.168.178.119"
//val BACKEND_URL = "http://192.168.178.132"

class LEDServerService {
    companion object {
        private val okHttpClient = OkHttpClient()

        private fun sendRequest(request: Request) {
            okHttpClient.newCall(request).enqueue(object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("ERROR", e.stackTraceToString())
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d("DEBUG", "Server responded with: ${response.body?.string()}")
                }

            })
        }

        fun postRGB(red: Int, green: Int, blue: Int) {
            val payload = "{\"red\":$red, \"green\":$green, \"blue\":$blue}"

            val okHttpClient = OkHttpClient()
            val requestBody = payload.toRequestBody()
            val request = Request.Builder()
                .method("POST", requestBody)
                .url("$BACKEND_URL/rgb")
                .build()

            Log.d("DEBUG", "Sending: $payload  ...")

            sendRequest(request)
        }

        fun setModeWater() {

            val okHttpClient = OkHttpClient()
            val request = Request.Builder()
                .get()
                .url("$BACKEND_URL/mode/water")
                .build()

            Log.d("DEBUG", "Setting mode to water")

            sendRequest(request)
        }

        fun setModeAudio() {

            val okHttpClient = OkHttpClient()
            val request = Request.Builder()
                .get()
                .url("$BACKEND_URL/mode/audio")
                .build()

            Log.d("DEBUG", "Setting mode to audio")

            sendRequest(request)
        }
    }
}