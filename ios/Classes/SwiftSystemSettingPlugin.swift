import Flutter
import UIKit

public class SwiftSystemSettingPlugin: NSObject, FlutterPlugin {
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "system_setting", binaryMessenger: registrar.messenger())
        let instance = SwiftSystemSettingPlugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }
    
    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        switch call.method {
        case "gotoSetting":
            if let url = URL(string: UIApplicationOpenSettingsURLString) {
                if (UIApplication.shared.canOpenURL(url)) {
                    if #available(iOS 10.0, *) {
                        UIApplication.shared.open(url, options: [:], completionHandler: nil)
                    }
                    result(nil)
                }
            }
        default:
            result("iOS " + UIDevice.current.systemVersion)
        }
    }
}
