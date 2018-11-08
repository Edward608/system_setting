# system_setting

[![pub package](version_image.svg)](https://pub.dartlang.org/packages/system_setting)

A Flutter plugin for jumping to system settings. 

For Android, this plugin currently support jumping to WiFi, Bluetooth and App Notification setting. 
Other setting path will be added soon.

For iOS, this plugin only opens the iOS `Settings` application, as using url schemes to open inner setting path is a violation of Apple's regulations. 
Using url scheme to open settings can also leads to possible App Store rejection.

If you can find any workaround or enhancement, pull requests are always welcome.

## Usage

To use this plugin, add `system_setting` as a [dependency in your pubspec.yaml file](https://flutter.io/platform-plugins/).

### Example

```dart
import 'package:flutter/material.dart';
import 'packages:system_setting/system_setting.dart';

void main() => runApp(MaterialApp(
      home: Scaffold(
        body: Center(
          child: RaisedButton(
            onPressed: _jumpToSetting,
            child: Text('Goto setting'),
          ),
        ),
      ),
    ));

_jumpToSetting() {
  SystemSetting.goto(SettingTarget.WIFI);
}
```