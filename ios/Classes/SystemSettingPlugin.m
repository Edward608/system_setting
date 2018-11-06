#import "SystemSettingPlugin.h"
#import <system_setting/system_setting-Swift.h>

@implementation SystemSettingPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftSystemSettingPlugin registerWithRegistrar:registrar];
}
@end
