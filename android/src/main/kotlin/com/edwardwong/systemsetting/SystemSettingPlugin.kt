package com.edwardwong.systemsetting

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class SystemSettingPlugin(
  private val registrar: Registrar
) : MethodCallHandler {

  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "system_setting")
      channel.setMethodCallHandler(SystemSettingPlugin(registrar))
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    val method = call.method
    when (method) {
      "getPlatformVersion" -> result.success("Android ${Build.VERSION.RELEASE}")
      "gotoSetting"        -> handleJump(call.arguments as String, result)
      else                 -> result.notImplemented()
    }
  }

  private fun handleJump(target: String, result: Result) {
    val action = when (target) {
      "wifi"         -> Settings.ACTION_WIFI_SETTINGS
      "bluetooth"    -> Settings.ACTION_BLUETOOTH_SETTINGS
      "notification" -> {
        handleNotificationJump(result)
        return
      }
      else           -> Settings.ACTION_SETTINGS
    }
    registrar.context().startActivity(Intent(action).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    result.success(null)
  }

  private fun handleNotificationJump(result: Result) {
    val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
      Intent(action).putExtra(Settings.EXTRA_APP_PACKAGE, registrar.context().packageName)
    } else {
      val action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
      Intent(action).setData(Uri.parse("package:${registrar.context().packageName}"))
    }
    registrar.context().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    result.success(null)
  }
}
