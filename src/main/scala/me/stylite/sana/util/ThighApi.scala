package me.stylite.sana.util

import okhttp3._
import org.json.JSONObject
import java.io.IOException
import java.util.Objects

object ThighApi {
  val client = new OkHttpClient

  def getThigh: String = {
    val request = new Request.Builder()
      .url("https://boob.bot/api/v2/img/ThighBot")
      .header("key", "Key")
      .build
    val response = client.newCall(request).execute
    try {
      val responseBody = response.body
      try {
        if (!response.isSuccessful) throw new IOException("Unexpected code " + response)
        new JSONObject(Objects.requireNonNull(responseBody).string).get("url").toString
      } finally if (responseBody != null) responseBody.close()
    }
  }

}
